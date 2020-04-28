package org.example;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/exThrow")
public class ExceptionThrow {
    /**
     * throw exception.
     * @param name info.
     */
    @Path("{name}")
    public void getName(@PathParam("name")final String name) {
        throw new NameNotFoundException(name);
    }
}
