package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
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
    public void testAddress(){
        Address address = AddressFactory.build("12", "Adderley", 8987, new City());
        System.out.println(address);
        assertNotNull(address);

    }
}
