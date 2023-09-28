package com.the.simone.model.request;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class AddGenericRequest {

    @NonNull
    private String nome;
    @NonNull
    private String note;
    @NonNull
    private String descrizione;
    @NonNull
    private Double prezzoAcquisto;
    private LocalDateTime dataAcquisto;
}
