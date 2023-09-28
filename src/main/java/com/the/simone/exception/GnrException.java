package com.the.simone.exception;

import lombok.Data;

@Data
public class GnrException extends RuntimeException{

    private String customMsg;

    public GnrException(String message, Throwable cause, String customMsg) {
        super(message, cause);
        this.customMsg = customMsg;
    }
}
