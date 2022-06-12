package za.ac.cput.factory;

import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.helper.StringHelper;

public class CityFactory {
    public static City build(String id, String name, Country country) {
        StringHelper.checkStringParam("id", id);
        StringHelper.checkStringParam("name", name);
        StringHelper.isEmptyOrNull(name);
        StringHelper.checkId(id);
        return new City.Builder()
                .setId(id)
                .setName(name)
                .setCountry(country)
                .build();
    }
}
