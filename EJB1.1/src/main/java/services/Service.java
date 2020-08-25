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
import java.util.Date;

@Stateless
@Path("/service")
public class Service {
//    @EJB
//    MyStatefulBean myStatefulBean;

    @EJB
    MyStatelessBean myStatelessBean;

//    @EJB
//    MySingletonBean mySingletonBean;
    
    @PostConstruct
    public void preconstruct() {
        System.out.println("Postcconstruct sevice " + this.myStatelessBean.hashCode());
        System.out.println("NEW INSTANCE Service" + this);
    }

    @GET
    @Path("/getStatelessValue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatelessValue() {
        return Response.status(Response.Status.OK)
                .entity(myStatelessBean.getMilliseconds())
                .build();
    }

//    @GET
//    @Path("/updateStateful")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateStateful() {
//        this.myStatefulBean.changeValueToNewDate(new Date());
//        return Response.status(Response.Status.OK)
//                .entity(myStatefulBean.getMilliseconds())
//                .build();
//    }



    @GET
    @Path("/updateStateless")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStateless() throws InterruptedException {
        this.myStatelessBean.changeValueToNewDate(new Date());
        return Response.status(Response.Status.OK)
                .entity(myStatelessBean.getMilliseconds())
                .build();
    }

    
//    @GET
//    @Path("/updateSingleton")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateMillisecondsWithCurrentDate() {
//        mySingletonBean.changeValueToNewDate(new Date());
//        return Response.status(Response.Status.OK)
//                .entity(mySingletonBean.getMilliseconds())
//                .build();
//    }

}
