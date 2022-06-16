package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.helper.StringHelper;

public class StudentAddressFactory {

    public static StudentAddress build(String studentId, Address address) {
        StringHelper.checkStringParam("studentId", studentId);
        StringHelper.checkId(studentId);
        return new StudentAddress.Builder()
                .setStudentId(studentId)
                .setAddress(address)
                .build();
    }

}
