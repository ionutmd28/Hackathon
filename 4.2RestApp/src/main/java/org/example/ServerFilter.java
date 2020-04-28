package org.example;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class ServerFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Override
    public void filter(final ContainerRequestContext containerRequestContext) throws IOException {
//        String method = containerRequestContext.getMethod();
//        URI uri = containerRequestContext.getUriInfo().getAbsolutePath();
//        for(String key : containerRequestContext.getHeaders().keySet()) {
//
//        }
        if (containerRequestContext.getLanguage() != null && "EN".equals(containerRequestContext.getLanguage()
                .getLanguage())) {
            containerRequestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
                    .entity("Ionut can't access")
                    .build());
        }
    }

    @Override
    public void filter(final ContainerRequestContext containerRequestContext, final ContainerResponseContext containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("MyNewHeader", "This is it");
    }
}
