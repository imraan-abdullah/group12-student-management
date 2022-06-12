/*
    Shasta Abrahams - 217059376
    EmployeeFactory.java
    11 June 2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.helper.StringHelper;

import javax.naming.Name;

public class EmployeeFactory {
    public static Employee build(String staffId, String email, Name name) {
        if(staffId == null || staffId.isEmpty())
            throw new IllegalArgumentException("staffId is required");
        if(email == null || email.isEmpty())
            throw new IllegalArgumentException("email is required");
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("name is required");
        return new Employee.Builder().staffId(staffId).email(email).name(name).build();
    }
}
