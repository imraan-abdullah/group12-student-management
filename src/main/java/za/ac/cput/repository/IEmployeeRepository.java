/*
    Shasta Abrahams - 217059376
    IEmployeeRepository.java
    11 June 2022
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    //Question 5
    //Contributed by all
    Optional<Employee> findByEmail(String email);
    //List<Name> findAllEmployeeNameByCityId(String cityId);
    //List<Employee> findByStaffId(String staffId);
    //List<Employee> findAll(String staffId);
}

