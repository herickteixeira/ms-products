package com.products.core.shared.exceptions;

public class MessageException extends RuntimeException{
    public MessageException(Throwable cause) {
        super(cause.getMessage(), cause);
    }
}
