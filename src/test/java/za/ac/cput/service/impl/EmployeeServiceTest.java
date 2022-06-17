package za.ac.cput.service.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private final Employee employee = EmployeeFactory.build("4367283","sup@gmail.com,", null);
    @Autowired
    private IEmployeeService service;

    @Order(1)
    @Test
    void save() {
        Employee saved = this.service.save(this.employee);
        assertAll(
                ()->assertNotNull(saved),

                ()->assertEquals(this.employee,saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Employee> read = this.service.read(this.employee.getStaffId());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()->assertEquals(this.employee,read.get())
        );
    }

    @Order(4)
    @Test void delete(){
        this.service.delete(this.employee);
        List<Employee> countryList = this.service.findAll();
        assertEquals(0, countryList.size());
    }

    @Order(3)
    @Test
    void findAll() {
        List<Employee> employeeList = this.service.findAll();
        assertEquals(1,employeeList.size());
    }
}