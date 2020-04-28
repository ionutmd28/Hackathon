import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/resource")
public class SomeResource {
    /**
     * Get method.
     * @return elem List.
     */
    @GET
    public List<String> getElements() {
        System.out.println("Atentie ##");
        final List<String> elem = new ArrayList<>();
        elem.add("Andrei");
        elem.add("Luca");
        elem.add("George");

        return elem;
    }

//    @Path("{id}")
//    public SomeResource getResource(@PathParam("id")final int id) {
//        final SomeResource someResource = null;
//        throw new ResourceNotFoundException(id);
//    }
}