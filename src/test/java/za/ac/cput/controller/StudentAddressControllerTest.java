package za.ac.cput.controller;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
/***
 * StudentAddressControllerTest.java
 * ControllerTest for StudentAddress
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 16 June 2022
 */
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressControllerTest {
    @LocalServerPort
    private int port;

    private Address address;
    private StudentAddress studentAddress;
    private String baseUrl;

    @Autowired private StudentAddressController controller;
    @Autowired private TestRestTemplate template;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        Country country = CountryFactory.build("2238765654", "South Africa");
        City city = CityFactory.build("CPT", "Cape Town", country);
        this.studentAddress = StudentAddressFactory.build("298787576", address);
        this.baseUrl="http://localhost:" + this.port + "/school-management/student-address/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<StudentAddress> response = this.template.postForEntity(url, this.studentAddress, StudentAddress.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.studentAddress.getStudentId();
        ResponseEntity<StudentAddress> response = this.template.getForEntity(url, StudentAddress.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.studentAddress.getStudentId();
        this.template.delete(url);
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<StudentAddress[]> response = this.template.getForEntity(url, StudentAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}