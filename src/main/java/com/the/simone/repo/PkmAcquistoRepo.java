package com.the.simone.repo;

import com.the.simone.exception.PkmException;
import com.the.simone.model.entity.PkmAcquisto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class PkmAcquistoRepo implements PanacheRepositoryBase<PkmAcquisto, Long> {

    public Optional<PkmAcquisto> findByNome(String nome){
        return Optional.ofNullable(find("nome",nome).firstResult());
    };

    public void deleteByNome(String nome){

        var entity = findByNome(nome);
        if(entity.isEmpty())
            throw new PkmException("Error on deletePkmByNome",null,null);

        delete(entity.get());
    }
}
