package za.ac.cput.service;
//Mariam Gallie- 219094837
// CountryServiceImpl.java (service package)
// 13 June 2022
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Country;
import za.ac.cput.repository.ICountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService{
    private final ICountryRepository repository;

   @Autowired public CountryServiceImpl(ICountryRepository repository){

       this.repository = repository;
    }
    @Override
    public Country save (Country country){

       return this.repository.save(country);
    }
    @Override
    public Optional<Country>read(String s){

       return this.repository.findById(s);
    }
    @Override
    public void delete(Country country){

       this.repository.delete(country);
    }
    @Override
    public List<Country> findAll(){

       return this.repository.findAll();
    }

    public void deleteById(String id){
        Optional <Country> country = read(id);
        if (country.isPresent())delete(country.get());
    }
}
