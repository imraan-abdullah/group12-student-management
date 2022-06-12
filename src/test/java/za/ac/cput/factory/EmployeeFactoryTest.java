/*
    Shasta Abrahams - 217059376
    Employee.java
    11 June 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    @Test public void buildWithSuccess() {
        Employee employee = EmployeeFactory.build("456789", "no@gmail.com", null);
        System.out.println(employee);
        assertNotNull(employee);
    }

    @Test public void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            EmployeeFactory.build(null, "no@gmail.com", null));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("staffId is required", exceptionMessage);
    }
}