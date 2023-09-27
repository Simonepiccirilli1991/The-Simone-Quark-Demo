package com.the.simone.service;

import com.the.simone.model.entity.PkmAcquisto;
import com.the.simone.model.request.AddPokemonRequest;
import com.the.simone.model.response.PkmResponse;
import com.the.simone.repo.PkmAcquistoRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Fallback;

@ApplicationScoped
@Slf4j
public class PkmServices {


    @Inject
    PkmAcquistoRepo pkmAcquistoRepo;


    @Fallback( fallbackMethod = "fallBackPkmAcquisto")
    public PkmResponse addPokmAcquisto(AddPokemonRequest request){

        log.info("Raw request before addPokmAcquisto service execution: {}",request);

        var entity = mapRequestToPkmAcquisto(request);

        try{
            pkmAcquistoRepo.persist(entity);
            return new PkmResponse("Acquisto salvato con successo",true,0);
        }catch (Exception e){
            log.error("Error on addPokmAcquisto service with error: {}",e);
            throw new RuntimeException();
        }
    }

    public PkmResponse fallBackPkmAcquisto(AddPokemonRequest request){
        log.info("Erro happened durisng save service, fallback in action");

        var response = new PkmResponse();
        response.setMsg("Error during saving pkm item");
        response.setPkmId(0);
        response.setSuccessful(false);

        return response;
    }
    private PkmAcquisto mapRequestToPkmAcquisto(AddPokemonRequest request){

        var response = new PkmAcquisto();


        return response;
    }
}
