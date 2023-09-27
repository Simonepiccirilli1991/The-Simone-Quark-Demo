package com.the.simone.repo;

import com.the.simone.model.entity.PkmAcquisto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public interface PkmAcquistoRepo extends PanacheRepository<PkmAcquisto> {

    Optional<PkmAcquisto> findByNome(String nome);
}
