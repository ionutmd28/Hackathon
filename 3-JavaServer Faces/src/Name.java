import javax.annotation.ManagedBean;

//
//@Named
//@RequestScoped
@ManagedBean
public class Name {
    private String value = "Ionut";

    public String getValue() {
        return value;
    }
}
