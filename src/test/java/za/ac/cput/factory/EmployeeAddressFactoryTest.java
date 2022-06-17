package za.ac.cput.factory;
/*
 * Velenkosini Prince Jeza (218191669)
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.EmployeeAddress;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    @Test
    public void buildWithSuccess() {
        EmployeeAddress employeeAddress = EmployeeAddressFactory.build("73465837645", null);
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }

    @Test
    public void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> EmployeeAddressFactory.build("", null));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("staffId"));
    }

}