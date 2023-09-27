package com.the.simone.model.entity;

import java.time.LocalDateTime;

public class PkmAcquisto {

        private String nome;
        private String codice; // puo essere vuoto se box
        private String tipoItem;
        private Double prezzoAcquisto;
        private LocalDateTime dataAcquisto;
        private LocalDateTime dataRegistrazione;
        private String statoOggetto;

}
