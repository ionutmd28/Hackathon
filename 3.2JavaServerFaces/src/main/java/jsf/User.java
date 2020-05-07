import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.awt.event.ActionEvent;
import java.io.Serializable;

@Named
@RequestScoped
public class User implements Serializable {
    private String name;
    private String password;
    private String status;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * login method.
     */
    public void login() {
        if (getName().equals(getPassword())) {
            setStatus("Login was successfully.");
        } else {
            setStatus("Login failed.");
        }
    }
}
