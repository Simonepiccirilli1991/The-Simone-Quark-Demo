package com.the.simone.model.response;

import lombok.Data;

@Data
public class PkmResponse {

    private String msg;
    private boolean successful;
    private int pkmId;
}
