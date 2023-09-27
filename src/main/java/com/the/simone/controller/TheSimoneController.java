package com.the.simone.controller;

import com.the.simone.model.request.AddPokemonRequest;
import com.the.simone.service.PkmServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/thesimone")
public class TheSimoneController {

    @Inject
    PkmServices pkmServices;

    @POST
    @Path("/add/pkm")
    public Response addPkmBuyed(AddPokemonRequest request){
        return Response.ok(pkmServices.addPokmAcquisto(request)).build();
    }
}
