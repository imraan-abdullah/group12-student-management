package za.ac.cput.factory;
import za.ac.cput.domain.Address;
import za.ac.cput.helper.StringHelper;
import za.ac.cput.domain.City;

/***
 * Factory for address.java
 * Entity for Address
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 11 June 2022
 */

public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName, int postalCode, City city) {
        StringHelper.checkStringParam("unitNumber", streetNumber);
        StringHelper.checkStringParam("complexName", streetName);
        StringHelper.checkStringParam("streetNumber", streetName);
        StringHelper.checkStringParam("streetName", streetName);
        StringHelper.checkPostalCode(postalCode);
        StringHelper.setEmptyIfNull("");

        return new Address.Builder().setStreetNumber(streetNumber)
                .setUnitNumber(unitNumber)
                .setComplexName(complexName)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode)
                .setCity(city)
                .build();

    }

/*    public static void postalCode_length(int postalCode) {
        if(postalCode.length() != 4){
            new IllegalArgumentException("Invalid postalcode");
        }
    }*/

}
