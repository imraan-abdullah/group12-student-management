package za.ac.cput.service;

import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.domain.Name;

import java.util.List;
import java.util.Optional;

/***
 * IEmployeeAddressServiceImpl.java
 * Interface for EmployeeAddress
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 16 June 2022
 */

public interface IEmployeeAddressService extends IService<EmployeeAddress, String>{
    Optional<EmployeeAddress> findById(String id);
    void deleteById(String staffId);
    List<EmployeeAddress> findAll();
}
