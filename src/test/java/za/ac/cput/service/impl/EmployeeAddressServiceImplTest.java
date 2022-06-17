package za.ac.cput.service.impl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.IEmployeeAddressService;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
/***
 * EmployeeAddressServiceImplTest.java
 * Test case for EmployeeAddressServiceImpl
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 16 June 2022
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressServiceImplTest {
    private Country country = CountryFactory.build("07", "South Africa");
    private City city = CityFactory.build("DBN", "Durban", country);
    private Address address = AddressFactory.build("10","Thekwini", 7890, city);
    private final EmployeeAddress employeeAddress = EmployeeAddressFactory.build("219887675", address);

    @Autowired
    private IEmployeeAddressService employeeAddressService;

    @Order(1)
    @Test
    void save() {
        EmployeeAddress saved = this.employeeAddressService.save(this.employeeAddress);
        assertEquals(this.employeeAddress, saved);
        System.out.println(saved);
    }

    @Order(2)
    @Test
    void read() {
        Optional<EmployeeAddress> read = this.employeeAddressService.read(this.employeeAddress.getStaffId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.employeeAddress, read.get())
        );
    }

    @Order(3)
    @Test
    void delete() {
        this.employeeAddressService.deleteById(this.employeeAddress.getStaffId());
        List<EmployeeAddress> employeeAddressList = this.employeeAddressService.findAll();
        assertEquals(0, employeeAddressList.size());
    }

    @Order(4)
    @Test
    void findAll(){
        List<EmployeeAddress> employeeAddressList = this.employeeAddressService.findAll();
        assertEquals(1, employeeAddressList.size());
    }
}