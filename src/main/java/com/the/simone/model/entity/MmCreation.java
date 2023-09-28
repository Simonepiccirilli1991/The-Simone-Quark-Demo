package com.the.simone.model.entity;

import com.the.simone.exception.GnrException;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity( name = "Creazioni_M")
@Data
public class MmCreation extends PanacheEntity {

    private String nome;
    private String descrizione;
    private String note;
    private Double prezzoDiVenditaPresunto;
    private int oreCreazione;
    private LocalDateTime dataInserimento;


    public Optional<MmCreation> getMmCreationByNome(String nome){
        return Optional.ofNullable(find("nome",nome).firstResult());
    }

    public void deleteMmCreationByNome(String nome){

        var entyty = getMmCreationByNome(nome);
        if (entyty.isEmpty())
            throw new GnrException("Generic Error",null,"Mmcreation not found for delete");

        entyty.get().delete();
    }
}
