package org.example.rest;

import org.example.rest.apps.PoolExecutorEJB;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;

@Stateless
@Path("/factory")
public class FactoryExecutorService {
    @EJB
    PoolExecutorEJB ejb;

    ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(14);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEjb() {

        ExecutorService executorService = ejb.getThreadPoolExecutor();

        for (int i = 0; i < 20; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                    System.out.println(this.hashCode());
//                    System.out.println(this.toString());
                    System.out.println("This is a message from the executor 0 " + arrayBlockingQueue.remainingCapacity());
                }
            });
        }


        return Response.status(Response.Status.OK).entity("DONE, check logs.").build();
    }
}