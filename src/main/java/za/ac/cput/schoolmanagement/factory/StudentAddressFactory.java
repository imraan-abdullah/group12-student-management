package za.ac.cput.schoolmanagement.factory;
// Velenkosini Prince Jeza (218191669)


import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

public class StudentAddressFactory {
        public static StudentAddress build(String studentId, String address ) {
            if( studentId == null || studentId.isEmpty())
                throw new IllegalArgumentException("student Id is required! ");
            if ( address == null || address.isEmpty())
                throw new IllegalArgumentException("address is required! ");
            return new StudentAddress.Builder().studentId(studentId).address(address).build();
        }
}
