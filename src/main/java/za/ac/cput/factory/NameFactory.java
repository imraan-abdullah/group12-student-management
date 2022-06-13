//Mariam Gallie- 219094837
// NameFactory.java (factory package)
// 11 June 2022

package za.ac.cput.factory;

import za.ac.cput.domain.Name;
import za.ac.cput.helper.StringHelper;

public class NameFactory {

    public static Name build(String firstName, String middleName, String lastName) {
        StringHelper.isEmptyOrNull("firstName");
        StringHelper.isEmptyOrNull("middleName");
        StringHelper.isEmptyOrNull("lastName");

        StringHelper.checkStringParam("firstName", firstName);
        StringHelper.checkStringParam("middleName", middleName);
        StringHelper.checkStringParam("lastName", lastName);

        return new Name.Builder().firstName(firstName).middleName(middleName).lastName(lastName).build();
    }

}

