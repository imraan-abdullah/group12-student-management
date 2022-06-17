/*
    Shasta Abrahams - 217059376
    EmployeeRepositoryTest.java
    11 June 2022
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {
    private Employee employee;
    private EmployeeRepository repository;

    @BeforeEach void setUp() {
        this.employee = EmployeeFactory.build("test-staffId", "test-email", null);
        this.repository = EmployeeRepository.employeeRepository();
        Employee saved = this.repository.save(this.employee);
        assertSame(this.employee, saved);
    }

    @AfterEach void tearDown() {
        this.repository.delete(this.employee);
        List<Employee> employeeList = this.repository.findAll();
        assertEquals(0,employeeList.size());
    }

    @Test
    void read() {
        Optional<Employee> read = this.repository.read(this.employee.getStaffId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(this.employee, read.get())
        );
    }

    //@Test
    //void findByStaffId() {
    //    List<Employee> employeeList = this.repository.findByStaffId();
    //    assertEquals(1, employeeList.size());
    //}

    @Test
    void findAll() {
        List<Employee> employeeList = this.repository.findAll();
        assertEquals(1, employeeList.size());
    }
}