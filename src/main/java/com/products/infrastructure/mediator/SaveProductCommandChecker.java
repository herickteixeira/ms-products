package com.products.infrastructure.mediator;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.products.application.commands.SaveProductCommand;
import com.products.core.domain.aggregates.product.events.ErrorSaveProductEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveProductCommandChecker implements CommandChecker<Command<?>> {

    private final Pipeline pipeline;

    @Autowired
    public SaveProductCommandChecker(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public void check(Command<?> c, Exception ex) {
        if (!(c instanceof SaveProductCommand)) return;
        var command = (SaveProductCommand) c;
        pipeline.send(new ErrorSaveProductEvent(command.getMessage()));
    }

    @Override
    public boolean shouldThrow() {
        return true;
    }
}
