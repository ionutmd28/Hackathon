import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Country {
    private String name;
    private int code;

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
