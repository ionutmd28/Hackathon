package pack;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/some")
public class SomeClass {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getElements() {
        System.out.println("Atentie ##");
        final List<String> elem = new ArrayList<>();
        elem.add("Andrei");
        elem.add("Luca");
        elem.add("George");

        return Response.status(Response.Status.OK).entity(elem)
                .build();
    }
}
