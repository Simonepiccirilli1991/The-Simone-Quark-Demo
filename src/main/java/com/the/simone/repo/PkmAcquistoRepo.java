package com.the.simone.repo;

import com.the.simone.model.entity.PkmAcquisto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class PkmAcquistoRepo implements PanacheRepositoryBase<PkmAcquisto, Long> {

    public Optional<PkmAcquisto> findByNome(String nome){
        return Optional.ofNullable(find("nome",nome).firstResult());
    };
}
