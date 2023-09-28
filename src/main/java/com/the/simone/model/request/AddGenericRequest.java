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
    private int quantita;
    @NonNull
    private Double prezzoSingoloAcquisto;
    private LocalDateTime dataAcquisto;
}
