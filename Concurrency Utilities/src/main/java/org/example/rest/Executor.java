package org.example.rest;

import org.example.rest.apps.SimpleTask;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/executor")
public class Executor {
    @Resource(lookup = "java:jboss/ee/concurrency/executor/default")
    ManagedExecutorService executor;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMessage() {

        executor.execute(new SimpleTask());
        String message = "Task executed, check logs.";
        return Response.status(Response.Status.OK).entity(message).build();
    }
}
