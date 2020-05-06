package com.jongwan.fun.common.error;

public class FunException extends RuntimeException {
    public FunException(Throwable e) {
        super(e);
    }

    public FunException(String message, Throwable e) {
        super(message, e);
    }

    public FunException(String message) {
        super(message);
    }

}
