package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.ICityService;

import javax.validation.Valid;
import java.util.List;

/***
 * CityController.java
 * Controller for City
 * Author: Imraan Abdullah (219361738)
 * Date: 17 June 2022
 */
@RestController
@RequestMapping("school-management/city/")
@Slf4j
public class CityController {
    private final ICityService service;

    @Autowired
    public CityController(ICityService service) {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<City> save(@Valid @RequestBody City city) {
        log.info("save request:{}", city);
        Country newCountry;
        City newCity;
        try {
            newCity = CityFactory.build(city.getId(), city.getName(), city.getCountry());
        }
        catch(IllegalArgumentException iae) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        City save = service.save(newCity);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read(@PathVariable String id) {
        log.info("Read request:{}", id);
        City city = this.service.read(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Read request:{}", id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<City>> findAll() {
        List <City> city = this.service.findAll();
        return ResponseEntity.ok(city);
    }
}
