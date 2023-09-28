package com.the.simone.service;

import com.the.simone.exception.GnrException;
import com.the.simone.model.entity.MmCreation;
import com.the.simone.model.request.AddMmCreationRequest;
import com.the.simone.model.response.MmCreationResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class MmCreationServices {


    @Transactional
    public MmCreationResponse addMmCreation(AddMmCreationRequest request){

        log.info("Raw request before addMmCreation execution: {}",request);

        try {
            var entity = mapRequestToMmCreation(request);
            entity.persist();

            return new MmCreationResponse("Creazione salvata con successo",null,null);
        }catch (Exception e){
            log.error("Error on addMmCreation service with error: {}",e);
            throw new GnrException("Generic Error: {}",e,"Error on addMmCreation");
        }
    }

    public MmCreationResponse getMmCreation(String nome){

        log.info("Raw request before getMmCreation service: {}",nome);

        var entity = new MmCreation().getMmCreationByNome(nome);

        if (entity.isEmpty())
            return new MmCreationResponse("Not found",null,"creation not found with name: "+nome);

        return new MmCreationResponse("Creazione trovata",entity.get(),null);
    }

    public String deleteMmCreation(String nome){

        log.info("Raw request before getMmCreation service: {}",nome);

        var entity = new MmCreation();
        entity.deleteMmCreationByNome(nome);

        return "Creazione eliminata con successo";
    }

    private MmCreation mapRequestToMmCreation(AddMmCreationRequest request){

        var response = new MmCreation();
        response.setNome(request.getNome());
        response.setNote(request.getNote());
        response.setOreCreazione(request.getOreCreazione());
        response.setPrezzoDiVenditaPresunto(request.getPrezzoDiVenditaPresunto());

        return response;
    }
}
