package za.ac.cput.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.domain.Name;
import za.ac.cput.repository.IEmployeeAddressRepository;
import za.ac.cput.service.IEmployeeAddressService;
import java.util.List;
import java.util.Optional;

/***
 * EmployeeAddressServiceImpl.java
 * Service implementation for EmployeeAddress
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 16 June 2022
 */

@Service
public class EmployeeAddressServiceImpl implements IEmployeeAddressService {
    private final IEmployeeAddressRepository repo;

    @Autowired
    public EmployeeAddressServiceImpl(IEmployeeAddressRepository repository){
        this.repo = repository;
    }
    @Override
    public EmployeeAddress save(EmployeeAddress address){
        return this.repo.save(address);
    }

    @Override
    public Optional<EmployeeAddress> read(String id) {
        return this.repo.findById(id);
    }

    @Override
    public void delete(EmployeeAddress EmployeeAddress) {
        repo.delete(EmployeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> findById(String staffId) {
        return this.repo.findById(staffId);
    }

    public List<EmployeeAddress> findAll() {
        return this.repo.findAll();
    }

    @Override
    public void deleteById(String staffId) {
        Optional<EmployeeAddress> EmployeeAddress = read(staffId);
        if(EmployeeAddress.isPresent()) delete(EmployeeAddress.get());
    }


}
