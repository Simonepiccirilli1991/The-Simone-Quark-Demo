package com.the.simone.controller;

import com.the.simone.model.request.AddGenericRequest;
import com.the.simone.model.request.AddMmCreationRequest;
import com.the.simone.model.request.AddPokemonRequest;
import com.the.simone.service.GnrServices;
import com.the.simone.service.MmCreationServices;
import com.the.simone.service.PkmServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.annotations.Pos;

@Path("/thesimone")
public class TheSimoneController {

    @Inject
    PkmServices pkmServices;
    @Inject
    GnrServices gnrServices;
    @Inject
    MmCreationServices mmCreationServices;

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


    // Acquisti generici
    @POST
    @Path("add/gnr")
    public Response addGnrAcquisto(AddGenericRequest request){
        return Response.ok(gnrServices.addGnrAcquisto(request)).build();
    }

    @GET
    @Path("get/gnr/{nome}")
    public Response getGneAcquisto(@PathParam("nome") String nome){
        return Response.ok(gnrServices.getGnrAcquisto(nome)).build();
    }


    // creazioni
    @POST
    @Path("add/creation")
    public Response addMmCreation(AddMmCreationRequest request){
        return Response.ok(mmCreationServices.addMmCreation(request)).build();
    }

    @GET
    @Path("get/creation/{nome}")
    public Response getMmCreation(@PathParam("nome") String nome){
        return Response.ok(mmCreationServices.getMmCreation(nome)).build();
    }

    @DELETE
    @Path("delete/creation/{nome}")
    public Response deleteMmCreation(@PathParam("nome") String nome){
        return Response.ok(mmCreationServices.deleteMmCreation(nome)).build();
    }
}
