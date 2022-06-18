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

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<City, String> {
    List<City> findAllCityByCountryId(String CountryId);
}
