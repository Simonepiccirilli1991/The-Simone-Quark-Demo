package com.the.simone.service;

import com.the.simone.exception.GnrException;
import com.the.simone.model.entity.GnrAcquisto;
import com.the.simone.model.request.AddGenericRequest;
import com.the.simone.model.response.GnrResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@ApplicationScoped
@Slf4j
public class GnrServices {


    @Transactional
    public GnrResponse addGnrAcquisto(AddGenericRequest request){

        log.info("Raw request before addGnrAcquisto service executetion: {}",request);

        try {
            var entity = mapRequestToGneAcquisto(request);
            entity.persist();

            return new GnrResponse("Acquisto generico salvato con successo", null);
        }catch (Exception e){
            log.error("Error during addGnrAcquisto service with error: {}",e);
            throw new GnrException("Generic Error: {}",e,"Error on addGnrAcquisto service");
        }
    }

    public GnrAcquisto getGnrAcquisto(String nome){

        log.info("Raw request before getGnrAcquisto service: {}",nome);

        try{
            var entity = new GnrAcquisto().findByNome(nome);
            if(entity.isEmpty())
                return new GnrAcquisto();

            return entity.get();

        }catch (Exception e){
            log.error("Error on getGnrAcquisto with error: {}",e);
            throw new GnrException("Generic Error: {}",e,"Error on getGnrAcquisto service");
        }
    }
    private GnrAcquisto mapRequestToGneAcquisto(AddGenericRequest request){

        var resp = new GnrAcquisto();

        resp.setNote(request.getNote());
        resp.setNome(request.getNome());
        resp.setDescrizione(request.getDescrizione());
        resp.setPrezzoAcquisto(request.getPrezzoAcquisto());
        resp.setDataRegistrazione(LocalDateTime.now());

        return resp;
    }
}
