package service;

import business.MagazinManager;
import persistence.entities.Magazin;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/parts")
public class MagazinService {

    @Resource
    TransactionSynchronizationRegistry tsr;

    @Inject
    MagazinManager magazinManager;

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParts() {
        System.out.println("Hello from Service before:" + tsr.getTransactionStatus());
        System.out.println("Hallo from: " + tsr.getTransactionKey());
        List<Magazin> parts = magazinManager.getParts();
        System.out.println("Hello from Service after:" + tsr.getTransactionStatus());
        System.out.println("Hallo from: " + tsr.getTransactionKey());
        return Response.status(Response.Status.OK).entity(parts).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPart(Magazin magazin){

        return Response.status(Response.Status.OK).entity(magazinManager.createNewPart(magazin)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePart(Magazin magazin) {
        magazinManager.updatePart(magazin);
        return Response.status(Response.Status.OK).entity("The auto part with the id 2 was updated!").build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePart() {

        magazinManager.deletePart(1);
        return Response.status(Response.Status.OK).entity("The auto part with the id 1 was deleted!").build();
    }

}
