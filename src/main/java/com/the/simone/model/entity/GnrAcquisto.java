package com.the.simone.model.entity;

import com.the.simone.exception.PkmException;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity( name = "Acquisto_Generico")
@Data
public class GnrAcquisto extends PanacheEntity {
    //usando sta porcata di panache entity non creo repository, ma istanzio oggetto per accedere ai suoi metodi che comprendono queery db
    private String nome;
    private String note;
    private String descrizione;
    private Double prezzoAcquisto;
    private LocalDateTime dataAcquisto;
    private LocalDateTime dataRegistrazione;

    // custom queey di ricerca per nome
    public Optional<GnrAcquisto> findByNome(String nome){
        return Optional.ofNullable(find("nome",nome).firstResult());
    }

    public void deleteByName(String name){
        delete(name);
    }
}
