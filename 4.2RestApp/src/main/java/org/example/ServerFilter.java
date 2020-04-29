package org.example;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;


@Provider
public class ServerFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Override
    public void filter(final ContainerRequestContext containerRequestContext) throws IOException {

//        containerRequestContext.setRequestUri(URI.
//                create(containerRequestContext.getUriInfo().getAbsolutePath() + "?myParam1=Darius"));
    }

    @Override
    public void filter(final ContainerRequestContext containerRequestContext,
                       final ContainerResponseContext containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("MyNewHeader", "This is it");
        System.out.println("Response POPOPPO");

    }
}
