package service;

import business.UserManager;
import persistence.entities.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/users")
public class UserService {
    @Inject
    UserManager userManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        return Response.status(Response.Status.OK).entity(userManager.getAllUsers()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewUser(User user) {
        return Response.status(Response.Status.OK).entity(userManager.createNewUser(user)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response resetPassword(User user) {
        return Response.status(Response.Status.OK).entity(userManager.resetPassword(user)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{userId}")
    public Response deleteUser(@PathParam("userId") int userId) {
        userManager.deleteUser(userId);
        return Response.status(Response.Status.OK).entity("The user with the id " + userId + " was deleted.").build();
    }

    @PUT
    @Path("{userId}/car/{carId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCarToUser(@PathParam("userId") int userId,
                                 @PathParam("carId") int carId) {
        return Response.status(Response.Status.OK).entity(userManager.addCarToUser(carId, userId)).build();
    }

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarsFromUser(@PathParam("userId") int userId) {
        return Response.status(Response.Status.OK).entity(userManager.getCarsFromUser(userId)).build();
    }
}
