package za.ac.cput.service;
/***
 * ICityService.java
 * Service interface for City
 * Author: Imraan Abdullah (219361738)
 * Date: 16 June 2022
 */
import za.ac.cput.domain.City;
import za.ac.cput.domain.Name;

import java.util.List;

public interface ICityService extends IService<City, String>{
    List<City> findAll();
    void deleteById(String id);
    //Question 7
    //Contributed by all
    List<City> findAllCityByCountryId(String CountryId);

}
