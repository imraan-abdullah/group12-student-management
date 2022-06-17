package za.ac.cput.factory;
/*
 * Velenkosini Prince Jeza (218191669)
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.EmployeeAddress;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    @Test
    public void buildWithSuccess() {
        Country country = CountryFactory.build("country-id-test", "country-name-test");
        City city = CityFactory.build("city-test", "city-name.test", country);
        Address address = AddressFactory.build("1254", "Mariam", "5845", "joe", 5454, city);
        EmployeeAddress employeeAddress = EmployeeAddressFactory.build("73465837645", address);
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }

    @Test
    public void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> EmployeeAddressFactory.build("", null));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("staffId"));
    }

}