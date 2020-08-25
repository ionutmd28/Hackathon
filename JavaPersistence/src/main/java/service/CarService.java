package service;

import business.CarManager;
import persistence.entities.Car;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
@Path("/cars")
public class CarService {
    @Inject
    CarManager carManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCars() {
        return Response.status(Response.Status.OK).entity(carManager.getAllCars()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewCar(Car car) {
        return Response.status(Response.Status.OK).entity(carManager.createNewCar(car)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{carId}")
    public Response deleteCar(@PathParam("carId") int carId) {
        carManager.deleteCar(carId);
        return Response.status(Response.Status.OK).entity("The car with the id " + carId + " was deleted.").build();
    }
}
