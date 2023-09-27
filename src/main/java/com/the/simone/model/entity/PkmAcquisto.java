package com.the.simone.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity( name = "Acquisti_Pokemon")
@Data
public class PkmAcquisto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "pkm_id")
        private Integer pkmId;
        private String nome;
        private String codice; // puo essere vuoto se box
        private String tipoItem;
        private Double prezzoAcquisto;
        private LocalDateTime dataAcquisto;
        private LocalDateTime dataRegistrazione;
        private String statoOggetto;

}
