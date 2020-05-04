import javax.ejb.Stateless;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Named
public class CountrySessionBean {

    public String buttonId;
    boolean check = false;

    /**
     * Method that returns a country object list
     * @return countryList list of countries.
     */
    public List<Country> getCountryList() {
        List<Country> countryList = new ArrayList<>();
        Country country = new Country();
        Country country2 = new Country();

        country2.setName("Romania");
        country.setName("Germania");

        if (check) {
            country2.setCode(10);
            country.setCode(9);
        } else {
            country2.setCode(9);
            country.setCode(10);
        }

        countryList.add(country);
        countryList.add(country2);

        return countryList;
    }

    public void getTheButtonId(ActionEvent event) {
        buttonId = event.getComponent().getClientId();
        check = !check;
    }

    public String changeCode() {
        return "Success!";
    }
//    public List<Country> changeCode() {
//        List<Country> countryList = getCountryList();
//
//        int firstCode = countryList.get(0).getCode();
//        int secondCode = countryList.get(1).getCode();
//
//        countryList.get(0).setCode(secondCode);
//        countryList.get(1).setCode(firstCode);
//
//        return countryList;
//    }
}
