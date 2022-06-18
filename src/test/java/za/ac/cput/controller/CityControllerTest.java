package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class CityControllerTest {
    @LocalServerPort
    private int port;

    @Autowired private CityController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Country country;
    private City city;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.country = CountryFactory.build("RSA", "South-Africa");
        this.city = CityFactory.build("DBN", "Durban", country);
        this.baseUrl = "http://localhost:" + this.port + "/school-management/city/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<City> response = this.restTemplate.postForEntity(url, this.city, City.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.city.getId();
        ResponseEntity<City> response = this.restTemplate.getForEntity(url, City.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(5)
    @Test
    void delete() {
        String url = baseUrl + "delete/"+ this.city.getId();
        this.restTemplate.delete(url);
    }

    @Order(3)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<City[]> response = this.restTemplate.getForEntity(url, City[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }

    //Question 7
    //Contributed by all
    @Test
    @Order(4)
    void findAllCityByCountryId() {
        String url = baseUrl + "read-by-countryId/" + this.city.getId();
        System.out.println(url);
        ResponseEntity<City> response =
                this.restTemplate.getForEntity(url, City.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }
}