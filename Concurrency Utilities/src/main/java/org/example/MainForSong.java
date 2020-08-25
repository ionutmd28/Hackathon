//package org.example;
//
//import com.sun.mail.iap.ResponseInputStream;
//
//import javax.annotation.Resource;
//import javax.enterprise.concurrent.ManagedExecutorService;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.concurrent.Callable;
//import java.util.concurrent.Future;
//
//@Path("/song")
//public class MainForSong {
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getMessage() {
////        System.out.println(Thread.currentThread().getName());
////        Runnable task = new MySong(new String[]{"Acesta este un cantec,",
////                "Si cantec este acesta,",
////                "Acum testam un cantec,",
////                "Il testam pe acesta."});
////        Thread worker = new Thread(task);
////
////        Thread secondWorkder = new Thread(task);
////
//////        Collection<MySong> tasks = new ArrayList<>();
//////
//////
//////        tasks.add(new MySong(new String[]{"Acesta este un cantec,",
//////                "Si cantec este acesta,",
//////                "Acum testam un cantec,",
//////                "Il testam pe acesta."}));
//////        tasks.add(new MySong((new String[]{"Acesta este un cantec,",
//////                "Il testam pe acesta."})));
//////
//////        List<Future<MySong>> results = executor.invokeAll(tasks);
////
////
////
////
////        synchronized (Integer.valueOf(1)) {
////            worker.start();
////        };
////
////        synchronized (Integer.valueOf(1)) {
////            secondWorkder.start();
////        };
////        System.out.println(Thread.currentThread().getName());
////
////        executor.execute(new MySong(new String[]{"Acesta este un cantec,",
////                "Si cantec este acesta,",
////                "Acum testam un cantec,",
////                "Il testam pe acesta."}));
////
////        return Response.status(Response.Status.OK).entity("Final.").build();
//    }
//}
