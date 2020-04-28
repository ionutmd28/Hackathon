package org.example;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

@Provider
public class MyWriterInterceptor implements WriterInterceptor {
    @Override
    public void aroundWriteTo(final WriterInterceptorContext writerInterceptorContext) throws IOException, WebApplicationException {
        writerInterceptorContext.getOutputStream().write("Hallo, Hallo, I'm a writer interceptor".getBytes());
        writerInterceptorContext.proceed();
    }
}
