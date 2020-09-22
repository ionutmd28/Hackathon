package batch;

import batch.records.MyOutputRecord;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class MyItemProcessor implements ItemProcessor {
    @Override
    public MyOutputRecord processItem(Object t) {
        System.out.println("### Processor");
        MyOutputRecord o = new MyOutputRecord();
        o.setS("Hello!");

        return o;
    }
}
