package beans;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import java.util.Date;

@Stateful
public class MyStatefulBean {
    long milliseconds = 010;


    @PostConstruct
    public void preconstruct() {
        System.out.println("NEW INSTANCE MyStatefulBean" + this);
    }

    public void changeValueToNewDate(final Date date) {
        this.milliseconds = date.getTime();
    }

    public Long getMilliseconds() {
        return this.milliseconds;
    }
}
