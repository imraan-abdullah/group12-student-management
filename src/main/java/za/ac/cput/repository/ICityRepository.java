package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.City;

public interface ICityRepository extends JpaRepository<City, String> {
}
