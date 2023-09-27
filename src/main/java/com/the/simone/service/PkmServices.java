package com.the.simone.service;

import com.the.simone.model.entity.PkmAcquisto;
import com.the.simone.model.request.AddPokemonRequest;
import com.the.simone.model.response.PkmResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Fallback;

@ApplicationScoped
@Slf4j
public class PkmServices {


    @Fallback( fallbackMethod = "fallBackPkmAcquisto")
    public PkmResponse addPokmAcquisto(AddPokemonRequest request){

        log.info("Raw request before addPokmAcquisto service execution: {}",request);

        var entity = mapRequestToPkmAcquisto(request);


        return new PkmResponse();
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
