package za.ac.cput.factory;
/*
 * Velenkosini Prince Jeza (218191669)
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {

        @Test
        public void buildWithSuccess() {
            Country country = CountryFactory.build("country-id-test", "country-name-test");
            City city = CityFactory.build("city-test", "city-name.test", country);
            Address address = AddressFactory.build("1254", "Mariam", "5845", "joe", 5454, city);
            StudentAddress studentAddress = StudentAddressFactory.build("test staff Id", address);
            System.out.println(studentAddress);
            assertNotNull(studentAddress);
        }

        @Test public void buildWithError() {
            Exception exception = assertThrows(IllegalArgumentException.class, () ->
                    StudentAddressFactory.build("",null));
            System.out.println(exception.getMessage());
            assertTrue(exception.getMessage().contains("studentId"));
        }

}