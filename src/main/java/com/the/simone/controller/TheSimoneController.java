package com.the.simone.controller;

import com.the.simone.model.request.AddPokemonRequest;
import com.the.simone.service.PkmServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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

    @GET
    @Path("get/pkm/{nome}")
    public Response getAcquistoPkm(@PathParam("nome") String nome){
        return Response.ok(pkmServices.getPokemonAcquisto(nome)).build();
    }

    @GET
    @Path("get/pkm/all")
    public Response getAllPkmAcquisti(){
        return Response.ok(pkmServices.getAllPkmAcquisti()).build();
    }

    @DELETE
    @Path("delete/pkm/{nome}")
    public Response deletePkmItem(@PathParam("nome") String nome){
        return Response.ok(pkmServices.deletePkmAcquisto(nome)).build();
    }
}
