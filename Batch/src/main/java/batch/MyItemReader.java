package batch;


import batch.records.MyInputRecord;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
public class MyItemReader extends AbstractItemReader {
    List<String> list;

    @Override
    public void open(Serializable c) {
        list = new ArrayList<>();
        list.add("Ionut");
        list.add("Andrei");
        list.add("Robert");
        list.add("Catalin");
    }

    @Override
    public MyInputRecord readItem() {
        System.out.println("### Reader");

        return new MyInputRecord(list.get(0));
    }

}
