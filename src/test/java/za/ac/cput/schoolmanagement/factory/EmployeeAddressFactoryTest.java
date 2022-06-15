package za.ac.cput.schoolmanagement.factory;
// Velenkosini Prince Jeza (218191669)


import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    @Test public void build() {
        EmployeeAddress employeeAddress = EmployeeAddressFactory.build("", "");
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }
}