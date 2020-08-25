package services;

import beans.MySingletonBean;
import beans.MyStatefulBean;
import beans.MyStatelessBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("")
public class Service2 {
//    @EJB
//    MyStatefulBean myStatefulBean;

    @EJB
    MyStatelessBean myStatelessBean;

//    @EJB
//    MySingletonBean mySingletonBean;

    @PostConstruct
    public void preconstruct() {
        System.out.println("Postcconstruct sevice2 " + this.myStatelessBean.hashCode());
        System.out.println("NEW INSTANCE Service2" + this.hashCode());
    }
//    @GET
//    @Path("/getStatefulValue")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getStatefulValue() {
//        return Response.status(Response.Status.OK)
//                .entity(myStatefulBean.getMilliseconds())
//                .build();
//    }

//    @GET
//    @Path("/getStatelessValue")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getStatelessValue() {
//        return Response.status(Response.Status.OK)
//                .entity(myStatelessBean.getMilliseconds())
//                .build();
//    }
//
//    @GET
//    @Path("/getSingletonValue")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getMilliseconds() {
//        return Response.status(Response.Status.OK)
//                .entity(mySingletonBean.getMilliseconds())
//                .build();
//    }
}
