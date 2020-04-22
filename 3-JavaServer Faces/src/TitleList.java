import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class TitleList {

    private List<Name> nameList;

    public List<Name> getNames() {
        return nameList;
    }
}
