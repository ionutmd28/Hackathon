package org.example.rest;

import org.example.rest.apps.CallableListenerTask;
import org.example.rest.apps.CallableTask;
import org.example.rest.apps.SimpleTask;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Stateless
@Path("/callableExecutor")
public class CallableExecutor {
    @Resource(lookup = "java:jboss/ee/concurrency/executor/default")
    ManagedExecutorService executor;

    @Resource(lookup = "java:jboss/ee/concurrency/scheduler/default")
    ManagedScheduledExecutorService scheduledExecutor;

    @Resource(lookup = "java:jboss/ee/concurrency/factory/default")
    ManagedThreadFactory factory;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMessage() {

        Future<Long> futureResult = executor.submit(new CallableTask(5));
        ScheduledFuture<Long> longScheduledFuture = scheduledExecutor.schedule(new CallableTask(5), 10, TimeUnit.SECONDS);
        Thread thread = factory.newThread(new SimpleTask());
        thread.setName("First Thread.");
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        String message = "m.m";
        return getResponse(longScheduledFuture, message);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/listener")
    public Response getListenerMessage() {

        Future<Long> futureResult = executor.submit(new CallableListenerTask(6));
        String message = "m..m";
        return getResponse(futureResult, message);
    }

    private Response getResponse(Future<Long> futureResult, String message) {
        while(!futureResult.isDone()) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            message = "Callable result is:" + futureResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.OK).entity(message).build();
    }
}
