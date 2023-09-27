package com.the.simone.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PkmResponse {

    private String msg;
    private boolean successful;
    private int pkmId;
}
