package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.EmployeeAddress;
/***
 * IEmployeeAddressRepository.java
 * Repository for Address
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 16 June 2022
 */

@Repository
public interface IEmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {

}
