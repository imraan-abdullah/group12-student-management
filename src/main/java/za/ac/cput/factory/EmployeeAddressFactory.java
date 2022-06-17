package za.ac.cput.factory;
/*
 * Velenkosini Prince Jeza (218191669)
 * */

import za.ac.cput.domain.*;
import za.ac.cput.helper.StringHelper;

public class EmployeeAddressFactory {

    public static EmployeeAddress build(String staffId, Address address) {
        StringHelper.checkStringParam("staffId", staffId);
        StringHelper.checkId(staffId);
        return new EmployeeAddress.Builder()
                .setStaffId(staffId)
                .setAddress(address)
                .build();
    }

}
