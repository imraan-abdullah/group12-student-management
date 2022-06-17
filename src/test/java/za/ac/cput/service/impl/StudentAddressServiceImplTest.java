package za.ac.cput.service.impl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.IStudentAddressService;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
/***
 * StudentAddressServiceImplTest.java
 * Test case for StudentAddressServiceImpl
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 16 June 2022
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressServiceImplTest {
    private Country country = CountryFactory.build("67", "South Africa");
    private City city = CityFactory.build("CPT", "Cape Town", country);
    private Address address = AddressFactory.build("20","Adderley", 9870, city);
    private final StudentAddress studentAddress = StudentAddressFactory.build("237987675", address);

    @Autowired
    private IStudentAddressService studentAddressService;
    
    @Order(1)
    @Test
    void save() {
        StudentAddress saved = this.studentAddressService.save(this.studentAddress);
        assertEquals(this.studentAddress, saved);
        System.out.println(saved);
    }

    @Order(2)
    @Test
    void read() {
        Optional<StudentAddress> read = this.studentAddressService.read(this.studentAddress.getStudentId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.studentAddress, read.get())
        );
    }

    @Order(3)
    @Test
    void delete() {
        this.studentAddressService.deleteById(this.studentAddress.getStudentId());
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        assertEquals(0, studentAddressList.size());
    }

    @Order(4)
    @Test
    void findAll() {
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        assertEquals(1, studentAddressList.size());
    }
}