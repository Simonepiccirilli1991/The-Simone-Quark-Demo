package com.the.simone.model.request;

import com.the.simone.util.PkmEnum;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class AddPokemonRequest {

    @NonNull
    private String nome;
    private String codice; // puo essere vuoto se box
    @NonNull
    private PkmEnum tipoItem;
    @NonNull
    private Double prezzoAcquisto;

    private LocalDateTime dataAcquisto;
    private LocalDateTime dataRegistrazione;
    @NonNull
    private PkmEnum statoOggetto;
}
