package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.service.IEmployeeService;
import za.ac.cput.service.impl.EmployeeServiceImpl;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class EmployeeControllerTest {
    @LocalServerPort
    private int port;

    @Autowired private EmployeeController controller;
    @Autowired private TestRestTemplate restTemplate;

    private EmployeeServiceImpl service;
    private Name name;
    private Employee employee;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.name = NameFactory.build("test-name", "test-mid-name", "test-las-name");
        this.employee = EmployeeFactory.build("2152142", "test@gmail.com", name);
        this.baseUrl = "http://localhost:" + this.port + "/school-management/employee/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<Employee> response = this.restTemplate.postForEntity(url, this.employee, Employee.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "read/" + this.employee.getStaffId();
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);
        System.out.println(response.toString());
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete/"+ this.employee.getStaffId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<Employee[]> response =
                this.restTemplate.getForEntity(url, Employee[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }

    @Test
    @Order(5)
    void findByEmail() {
        String url = baseUrl + "read-by-email/" + this.employee.getEmail();
        System.out.println(url);
        ResponseEntity<Employee> response =
                this.restTemplate.getForEntity(url, Employee.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );

    }
}