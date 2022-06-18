/*
    Shasta Abrahams - 217059376
    IEmployeeService.java
    16 June 2022
 */
package za.ac.cput.service;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService extends IService<Employee, String> {
    List<Employee> findAll();
    void deleteById (String id);
    //Question 5
    //Contributed by all
    Optional<Employee> findByEmail(String email);
    //List<Name> findAllEmployeeNameByCityId(String cityId);
}
