package com.fh.exception;

import com.netflix.zuul.exception.ZuulException;

public class LoginException extends ZuulException {

    public LoginException(String sMessage, int nStatusCode, String errorCause) {
        super(sMessage, nStatusCode, errorCause);
    }
}
