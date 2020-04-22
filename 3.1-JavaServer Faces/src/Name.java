import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Name {
    private String value = "Ionut";

    /**
     * constr.
     * @param value val.
     */
    public Name(final String value) {
        this.value = value;
    }

    public Name() {

    }

    public String getValue() {
        return value;
    }
}
