package org.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/resource")
public class SomeResource {
    /**
     * Get method.
     * @return elem List.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getElements() {
        System.out.println("Atentie ###");
        final List<String> elem = new ArrayList<>();
        elem.add("Andrei");
        elem.add("Luca");
        elem.add("George");

        return Response.status(Response.Status.OK).entity(elem)
                .build();
    }

    /**
     * post method.
     * @param firstName first.
     * @param lastName last.y
     * @return obj.
     */
    @POST
    @Path("/createUsingForm")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNameUsingForm(@FormParam("first")final String firstName,
            @FormParam("last")final String lastName) {
        final Name name = new Name();
        name.setFirstName(firstName);
        name.setLastName(lastName);
        return Response.status(Response.Status.OK).entity(name)
                .build();
    }
    // Note: The media type is not supported for form request. ^

    /**
     * post method.
     * @param fullName fullName.
     * @return obj.
     */
    @POST
//    @Path("/createUsingPathParam")
    @Path("{fullName}")

    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XHTML_XML})
    public Response createNameUsingPath(@PathParam("fullName")final String fullName) {
        final Name name = new Name();
        name.setFullName(fullName);
        return Response.status(Response.Status.OK).entity(name)
                .build();
    }

}
