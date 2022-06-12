package za.ac.cput.factory;

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
