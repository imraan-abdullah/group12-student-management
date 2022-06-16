package za.ac.cput.factory;
/***
 * CountryFactory.java
 * Factory for Country
 * Author: Imraan Abdullah (219361738)
 * Date: 12 June 2022
 */
import za.ac.cput.domain.Country;
import za.ac.cput.helper.StringHelper;

public class CountryFactory {
    public static Country build(String id, String name) {
        StringHelper.checkStringParam("id", id);
        StringHelper.checkStringParam("name", name);
        StringHelper.isEmptyOrNull(name);
        StringHelper.checkId(id);
        return new Country.Builder()
                .setId(id)
                .setName(name)
                .build();
    }
}
