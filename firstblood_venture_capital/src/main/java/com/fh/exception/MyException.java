package com.fh.exception;

/**
 * 写一个异常类，运行时异常，也可以是其他的异常，根据情况需要
 */
public class MyException extends RuntimeException {

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
