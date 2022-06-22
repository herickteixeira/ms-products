package com.products.infrastructure.mediator;

import an.awesome.pipelinr.Command;
import com.products.core.shared.exceptions.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class ExceptionPipelineMiddleware implements Command.Middleware {

    private final List<CommandChecker<Command<?>>> commandCheckers;

    @Autowired
    public ExceptionPipelineMiddleware(List<CommandChecker<Command<?>>> commandCheckers) {
        this.commandCheckers = commandCheckers;
    }

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        try {
            return next.invoke();
        } catch (DomainException ex) {
            throw ex;
        } catch (Exception ex) {

            for (var checker : commandCheckers)
                checker.check(command, ex);

            for (var checker : commandCheckers)
                if (checker.shouldThrow()) throw ex;

            return null;
        }
    }
}