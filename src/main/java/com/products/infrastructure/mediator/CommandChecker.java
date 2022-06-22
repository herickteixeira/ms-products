package com.products.infrastructure.mediator;
import an.awesome.pipelinr.Command;

public interface CommandChecker<C extends Command<?>> {

    void check(C command, Exception ex);

    boolean shouldThrow();
}
