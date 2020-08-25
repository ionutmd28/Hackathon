package beans;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.Date;

@Singleton
public class MyStatelessBean {
    long milliseconds = 010;

    public MyStatelessBean() {
        System.out.println("Constructor" + this.hashCode());
    }

    @PostConstruct
    public void postconstruct() {
        System.out.println("Postconstruct" + this.hashCode());
    }

    public void changeValueToNewDate(final Date date) throws InterruptedException {
        this.milliseconds = date.getTime();
        System.out.println("### CONSOLE LOG BEFORE thread sleep" +  this.hashCode());
        Thread.sleep(10000);
    }

    public Long getMilliseconds() {
        System.out.println("### CONSOLE LOG GET MILLISECONDS instance" +  this.hashCode());
        System.out.println("### CONSOLE LOG GET MILLISECONDS" +  this.milliseconds);
        return this.milliseconds;
    }
}
