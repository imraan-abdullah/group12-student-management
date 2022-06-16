package za.ac.cput.factory;
/***
 * CityFactory.java
 * test case for CityFactory
 * Author: Imraan Abdullah (219361738)
 * Date: 12 June 2022
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    @Test
    public void buildWithSuccess() {
        Country country = CountryFactory.build("test-country-id", "test-country-name");
        City city = CityFactory.build("219361738", "Imraan", country);
        System.out.println(city);
        assertNotNull(country);
    }

    @Test
    public void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> CityFactory.build("", "", null));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }

}