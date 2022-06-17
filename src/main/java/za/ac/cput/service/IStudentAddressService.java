package za.ac.cput.service;

import za.ac.cput.domain.StudentAddress;

import java.util.List;
import java.util.Optional;

/***
 * IStudentAddressService.java
 * Interface for StudentAddress
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 16 June 2022
 */
public interface IStudentAddressService extends IService<StudentAddress, String> {
    void deleteById(String studentId);
    Optional<StudentAddress> findById(String id);
    List<StudentAddress> findAll();
}
