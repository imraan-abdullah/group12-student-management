//Mariam Gallie- 219094837
// ICountryService.java (service package)
// 13 June 2022
package za.ac.cput.service;

import za.ac.cput.domain.Country;

import java.util.List;

public interface ICountryService extends IService <Country, String>{
    List <Country> findAll();


    void deleteById(String id);
}
