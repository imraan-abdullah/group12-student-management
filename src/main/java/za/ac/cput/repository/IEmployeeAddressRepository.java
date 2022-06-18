package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.domain.Name;

/***
 * IEmployeeAddressRepository.java
 * Repository for Address
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 16 June 2022
 */

@Repository
public interface IEmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {

}
//Implement a service to retrieve all employee name(s) living in a particular city. The formal parameter passed is the cityId