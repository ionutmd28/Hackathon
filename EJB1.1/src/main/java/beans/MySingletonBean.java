package beans;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.Date;

@Singleton
public class MySingletonBean {

    long milliseconds = 010;

    @PostConstruct
    public void preconstruct() {
        System.out.println("NEW INSTANCE Singleton" + this);
    }

    public void changeValueToNewDate(final Date date) {
        this.milliseconds = date.getTime();
    }

    public Long getMilliseconds() {
        return this.milliseconds;
    }
}
