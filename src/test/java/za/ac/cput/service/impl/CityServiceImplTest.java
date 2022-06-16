package za.ac.cput.service.impl;
/***
 * CityServiceImplTest.java
 * Test case for CityService
 * Author: Imraan Abdullah (219361738)
 * Date: 16 June 2022
 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.ICityService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceImplTest {
    private final Country country = CountryFactory.build("RSA", "South Africa");
    private final City city = CityFactory.build("CPT", "Cape Town", country);
    @Autowired private ICityService service;

    @Order(1)
    @Test
    void save() {
        City saved = this.service.save(this.city);
        System.out.println(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.city, saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<City> read = this.service.read(this.city.getId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.city, read.get())
        );
    }

    @Order(3)
    @Test
    void findAll() {
        List<City> cityList = this.service.findAll();
        System.out.println(cityList);
        assertEquals(1, cityList.size());
    }
    @Order(4)
    @Test
    void delete() {
        this.service.delete(this.city);
        List<City> cityList = this.service.findAll();
        assertEquals(0, cityList.size());
    }

}