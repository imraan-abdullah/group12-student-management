package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.AddressFactory;


import static org.junit.jupiter.api.Assertions.*;
/***
 * AddressFactoryTest.java
 * TestFactory for Address
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 12 June 2022
 */

class AddressFactoryTest {

    @Test
    public void testAddressWithSuccess(){
        Country country = CountryFactory.build("test-country-id", "test-country-name");
        City city = CityFactory.build("298776287", "Cape Town", country);
        Address address = AddressFactory.build("11251", "dave", "2142", "hills", 1000, city);
        System.out.println(address);
        assertNotNull(address);

    }

    @Test
    public void testAddressWithError(){
        Exception exception = assertThrows(IllegalArgumentException
                .class, () -> AddressFactory.build("", "", "", "", 210, null));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("unitNumber"));
    }
}
