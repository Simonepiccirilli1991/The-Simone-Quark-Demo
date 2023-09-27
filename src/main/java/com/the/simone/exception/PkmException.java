package com.the.simone.exception;

import lombok.Data;

@Data

public class PkmException extends RuntimeException{

    private String customMsg;

    public PkmException(String message, Throwable cause, String customMsg) {
        super(message, cause);
        this.customMsg = customMsg;
    }
}
