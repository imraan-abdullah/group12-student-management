package za.ac.cput.controller;
/*
 * Velenkosini Prince Jeza (218191669)
 * */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.factory.EmployeeAddressFactory;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressControllerTest {
    @LocalServerPort
    private int port;

    @Autowired private EmployeeAddressController controller;
    @Autowired private TestRestTemplate template;

    private Address address;
    private EmployeeAddress employeeAddress;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        Country country = CountryFactory.build("RSA", "South Africa");
        City city = CityFactory.build("DBN", "Durban", country);
        Address address = AddressFactory.build("1596", "deji", "8008", "Blue", 1252, city);
        this.employeeAddress = EmployeeAddressFactory.build("32645432",address);
        this.baseUrl = "http://localhost:" + this.port+ "/school-management/employee-address/";

    }

    @Test
    @Order(1)
    void save(){
        String url = baseUrl + "save";
        ResponseEntity<EmployeeAddress> response = this.template
                .postForEntity(url,this.employeeAddress, EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );

    }
    @Test
    @Order(2)
    void read(){
        String url = baseUrl + "read/" + this.employeeAddress.getStaffId();
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.template.getForEntity(url,EmployeeAddress.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete(){
        String url = baseUrl + "delete/"+ this.employeeAddress.getStaffId();
        this.template.delete(url);
    }

    @Test
    @Order(3)
    void findAll(){
        String url = baseUrl + "all";
        ResponseEntity<EmployeeAddress[]>response =
                this.template.getForEntity(url,EmployeeAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertEquals(1, response.getBody().length)
        );
    }
}