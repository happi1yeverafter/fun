package com.jongwan.fun.common.error;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FunExceptionCode {
    POST(-1000),
    POST_NOT_FOUND(POST.code - 1, "POST NOT FOUND (ID = %s)"),

    CATEGORY(-2000),
    CATEGORY_NOT_FOUND(CATEGORY.code - 1, "CATEGORY NOT FOUND (ID = %s)");

    private int code;
    private String message;

    FunExceptionCode(int code) {
        this.code = code;
    }

    public FunException newInstance(String... ids) {
        return new FunException(String.format(message, ids));
    }

    public FunException newInstance(Throwable e, String... ids) {
        return new FunException(String.format(message, ids), e);
    }

    public FunException newInstance(Throwable e) {
        return new FunException(e);
    }
}
