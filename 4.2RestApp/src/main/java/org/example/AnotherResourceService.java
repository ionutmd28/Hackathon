package org.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/aResource")
public class AnotherResourceService {
    /**
     * Method to get the response header in body.
     * @param param param.
     * @return resp.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRespBody(@QueryParam("param")String param) {

        return Response.status(Response.Status.OK)
                .entity(param)
                .build();
    }
    /**
     * Method to get the response in case there already exists a QueryParam.
     * @param myParam1 param.
     * @return resp.
     */
    @Path("/check")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRespForMyParam1(@QueryParam("myParam1")String myParam1) {

        return Response.status(Response.Status.OK)
                .entity(myParam1)
                .build();
    }

}
