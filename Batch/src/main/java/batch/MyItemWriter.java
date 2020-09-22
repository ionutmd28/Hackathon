package batch;

import batch.records.MyOutputRecord;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import java.util.List;

@Named
public class MyItemWriter extends AbstractItemWriter {

    @Override
    public void writeItems(List<Object> list) throws Exception {
        System.out.println("### Writer");
        for (Object s : list) {
            System.out.println("My String:" + ((MyOutputRecord) s).getS());

        }
    }
}
