package com.the.simone.service;

import com.the.simone.exception.PkmException;
import com.the.simone.model.entity.PkmAcquisto;
import com.the.simone.model.request.AddPokemonRequest;
import com.the.simone.model.response.PkmResponse;
import com.the.simone.repo.PkmAcquistoRepo;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Fallback;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
@Slf4j
public class PkmServices {


    @Inject
    PkmAcquistoRepo pkmAcquistoRepo;


    @Fallback( fallbackMethod = "fallBackPkmAcquisto")
    @Transactional
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
    public PkmAcquisto getPokemonAcquisto(String nome){

        var entity = pkmAcquistoRepo.findByNome(nome);

        if (entity.isEmpty())
            throw new PkmException("No acquisto found with this name: "+nome,null,null);

        return entity.get();
    }

    public List<PkmAcquisto> getAllPkmAcquisti(){
        try {
            return pkmAcquistoRepo.findAll().stream().toList();
        }catch (Exception e){
            log.error("Erro on getAllPkmAcquisti with error: {}",e);
            throw new PkmException("Error on getAllPkmAcquisti",e,null);
        }
    }

    public String deletePkmAcquisto(String nome){

        pkmAcquistoRepo.deleteByNome(nome);
        return "Eliminato con successo";
    }
    private PkmAcquisto mapRequestToPkmAcquisto(AddPokemonRequest request){

        var response = new PkmAcquisto();
        response.setNome(request.getNome());
        response.setCodice(request.getCodice());
        response.setDataAcquisto(request.getDataAcquisto());
        response.setCodice(request.getCodice());
        if(StringUtil.isNullOrEmpty(String.valueOf(request.getQuantita())))
            response.setQuantita(1);
        else
            response.setQuantita(request.getQuantita());
        response.setPrezzoSingoloAcquisto(request.getPrezzoSingoloAcquisto());
        response.setStatoOggetto(request.getStatoOggetto().value());
        response.setTipoItem(request.getTipoItem().value());
        response.setDataRegistrazione(LocalDateTime.now());

        return response;
    }
}
