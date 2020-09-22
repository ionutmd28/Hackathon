package service;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Properties;

@Stateless
@Path("/batch")
public class BatchService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long jid = jobOperator.start("myJob",new Properties());
        JobExecution jobExecution = jobOperator.getJobExecution(jid);
        jobOperator.stop(jid);
        return Response.status(Response.Status.OK).entity("Works!").build();
    }
}
