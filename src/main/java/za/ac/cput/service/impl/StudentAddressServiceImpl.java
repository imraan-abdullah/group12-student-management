package za.ac.cput.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.repository.IStudentAddressRepository;
import za.ac.cput.service.IStudentAddressService;

import java.util.List;
import java.util.Optional;

/***
 * StudentAddressServiceImpl.java
 * Service implementation for StudentAddress
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 16 June 2022
 */

@Service
public class StudentAddressServiceImpl implements IStudentAddressService {
    private final IStudentAddressRepository repo;

    @Autowired
    public StudentAddressServiceImpl(IStudentAddressRepository repository){
        this.repo = repository;
    }

    @Override
    public StudentAddress save(StudentAddress address){
        return this.repo.save(address);
    }

    @Override
    public Optional<StudentAddress> read(String id) {
        return this.repo.findById(id);
    }

    public void delete(StudentAddress StudentAddress) {
        repo.delete(StudentAddress);
    }

    @Override
    public Optional<StudentAddress> findById(String studentId) {
        return this.repo.findById(studentId);
    }

    @Override
    public List<StudentAddress> findAll() {
        return this.repo.findAll();
    }

    @Override
    public void deleteById(String studentId) {
        Optional<StudentAddress> StudentAddress = read(studentId);
        if(StudentAddress.isPresent()) delete(StudentAddress.get());
    }
}
