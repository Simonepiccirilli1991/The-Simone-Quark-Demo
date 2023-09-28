package com.the.simone.model.request;

import lombok.Data;

@Data
public class AddMmCreationRequest {

    private String nome;
    private String descrizione;
    private String note;
    private Double prezzoDiVenditaPresunto;
    private int oreCreazione;
}
