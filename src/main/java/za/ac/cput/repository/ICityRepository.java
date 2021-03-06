package za.ac.cput.repository;
/***
 * ICityRepository.java
 * Repository for City
 * Author: Imraan Abdullah (219361738)
 * Date: 16 June 2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Name;

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<City, String> {
    //Question 7
    //Contributed by all
    List<City> findAllCityByCountryId(String CountryId);
}
