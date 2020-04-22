import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import java.util.List;

@Stateless
@ManagedBean
public class ListName {
    private final Name[] listName = new Name[] {
            new Name("Andrei"),
            new Name("Robert"),
            new Name("Ghita")
    };


    /**
     * This method return a list with names.
     * @return names.
     */
    public Name[] getListName() {
        return listName;
    }

}
