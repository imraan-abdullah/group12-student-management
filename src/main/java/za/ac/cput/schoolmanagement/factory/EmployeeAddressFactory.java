package za.ac.cput.schoolmanagement.factory;
// Velenkosini Prince Jeza (218191669)



import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

public class EmployeeAddressFactory {
    public static EmployeeAddress build(String staffId, String address ) {
        if( staffId == null || staffId.isEmpty())
            throw new IllegalArgumentException("staff Id is required! ");
        if ( address == null || address.isEmpty())
            throw new IllegalArgumentException("address is required! ");
        return new EmployeeAddress.Builder().staffId(staffId).address(address).build();
    }
}
