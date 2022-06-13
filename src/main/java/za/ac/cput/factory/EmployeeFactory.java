/*
    Shasta Abrahams - 217059376
    EmployeeFactory.java
    11 June 2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import za.ac.cput.helper.StringHelper;

public class EmployeeFactory {
    public static Employee build(String staffId, String email, Name name) {
        StringHelper.checkStringParam("staffId", staffId);
        StringHelper.checkStringParam("email", email);
        //StringHelper.checkStringParam("name", name);
        //StringHelper.isEmptyOrNull(name);
        StringHelper.checkId(staffId);
        return new Employee.Builder().setStaffId(staffId).setEmail(email).setName(name).build();
    }
}
