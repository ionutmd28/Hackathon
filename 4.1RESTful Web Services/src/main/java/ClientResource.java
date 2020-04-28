import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ClientResource {
    Client client = ClientBuilder.newClient();
    SomeResource someResource = client.target("http://localhost:8080/4_1RESTful_Web_Services_war_exploded/web/resource")
            .request()
            .get(SomeResource.class);

}
