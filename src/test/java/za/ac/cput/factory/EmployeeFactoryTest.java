/*
    Shasta Abrahams - 217059376
    EmployeeFactoryTest.java
    11 June 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    @Test
    public void buildWithSuccess() {
        Name name = NameFactory.build("test-name-firstName", "test-name-middleName", "test-name-lastName");
        Employee employee = EmployeeFactory.build("5679", "no@gmail.com", name);
        System.out.println(employee);
        assertNotNull(name);
    }

    @Test public void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.build("", "", null));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("staffId"));
    }
}