package za.ac.cput.service;
//Mariam Gallie- 219094837
// CountryServiceImplTest.java (service test package)
// 13 June 2022
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CountryFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryServiceImplTest {
    private final Country country = CountryFactory.build("mmm","mei");
   @Autowired private ICountryService service;

    @Order(1)
    @Test
    void save() {
        Country saved = this.service.save(this.country);
        assertAll(
                ()->assertNotNull(saved),

                ()->assertEquals(this.country,saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Country> read = this.service.read(this.country.getId());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()->assertEquals(this.country,read.get())
        );
    }
    @Order(4)
    @Test void delete(){
        this.service.delete(this.country);
        List<Country> countryList = this.service.findAll();
        assertEquals(0, countryList.size());
    }

    @Order(3)
    @Test
    void findAll() {
        List<Country> countryList = this.service.findAll();
        assertEquals(1,countryList.size());
    }
}