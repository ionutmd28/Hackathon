package batch;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import java.util.Properties;

/**
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void givenChunk_thenBatch_completesWithSuccess() {
//
//        JobOperator jobOperator = BatchRuntime.getJobOperator();
//        long jid = jobOperator.start("myJob",new Properties());
//        JobExecution jobExecution = jobOperator.getJobExecution(jid);


    }
}
