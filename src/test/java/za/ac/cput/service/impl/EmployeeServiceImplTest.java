package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class EmployeeServiceImplTest {
    private final Name name = NameFactory.build("Imraan", "joe", "Abdullah");
    private final Employee employee = EmployeeFactory.build("4367283","sup@gmail.com", name);
    private final Country country = CountryFactory.build("RSA", "South Africa");
    private final City city = CityFactory.build("JHZ", "Jozi", country);
    private final Address address = AddressFactory.build("4785", "jjj", "44", "omo", 4545, city);
    private final EmployeeAddress employeeAddress = EmployeeAddressFactory.build("4367283", address);
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

    @Order(6)
    @Test void delete(){
        this.service.deleteById(this.employee.getStaffId());
        List<Employee> countryList = this.service.findAll();
        assertEquals(0, countryList.size());
    }

    @Order(3)
    @Test
    void findAll() {
        List<Employee> employeeList = this.service.findAll();
        assertEquals(1,employeeList.size());
    }

    //Question 5
    //Contributed by all
    @Test
    @Order(4)
    void findByEmail() {
       String email = this.employee.getEmail();
        Optional <Employee> read = this.service.findByEmail(employee.getEmail());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()->assertEquals(this.employee,read.get())
        );
    }

    //Question 6
    //Contributed by all
//    @Order(5)
//    @Test
//    void findAllNameByCityId() {
//        List<Name> listOfEmployeeNames = this.service.findAllEmployeeNameByCityId(this.city.getId());
//        System.out.println(listOfEmployeeNames);
//        assertEquals(1, listOfEmployeeNames.size());
//    }

}


