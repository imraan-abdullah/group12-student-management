package za.ac.cput.service.impl;
/***
 * CityServiceImpl.java
 * Service implementation for City
 * Author: Imraan Abdullah (219361738)
 * Date: 16 June 2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.repository.ICityRepository;
import za.ac.cput.service.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {
    private final ICityRepository repository;

    @Autowired
    public CityServiceImpl(ICityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City save(City city) {
        return this.repository.save(city);
    }

    @Override
    public Optional<City> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(City city) {
        this.repository.delete(city);
    }

    @Override
    public List<City> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<City> city = read(id);
        if(city.isPresent())
            delete(city.get());
    }
}
