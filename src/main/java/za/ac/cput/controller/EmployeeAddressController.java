package za.ac.cput.controller;
/*
 * Velenkosini Prince Jeza (218191669)
 * */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.EmployeeAddressFactory;
import za.ac.cput.service.IEmployeeAddressService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/employee-address")
@Slf4j
public class EmployeeAddressController {
    private IEmployeeAddressService employeeAddressService;

    @Autowired
    public EmployeeAddressController(IEmployeeAddressService iEmployeeAddressService){
        this.employeeAddressService = iEmployeeAddressService;
    }


    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@Valid @RequestBody EmployeeAddress employeeAddress){
        log.info("Save request:{}", employeeAddress);
        EmployeeAddress valEmployeeAddress;
        try {
            valEmployeeAddress = EmployeeAddressFactory.build(employeeAddress.getStaffId(), employeeAddress.getAddress());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        EmployeeAddress save = employeeAddressService.save(valEmployeeAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable String staffId){
        log.info("Read request:{}", staffId);
        EmployeeAddress employeeAddress = this.employeeAddressService.read(staffId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeAddress);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable String staffId) {
        log.info("Read request:{}", staffId);
        this.employeeAddressService.deleteById(staffId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>>findAll(){
        List <EmployeeAddress> employeeAddressList = this.employeeAddressService.findAll();
        return ResponseEntity.ok(employeeAddressList);

    }

}
