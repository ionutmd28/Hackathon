import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.IOException;

public class MyFilter implements ClientRequestFilter, ClientResponseFilter {
    @Override
    public void filter(final ClientRequestContext clientRequestContext) throws IOException {

    }

    @Override
    public void filter(final ClientRequestContext clientRequestContext,
                       final ClientResponseContext clientResponseContext) throws IOException {

    }
}
