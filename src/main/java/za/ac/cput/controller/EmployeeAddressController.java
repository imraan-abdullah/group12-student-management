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
@RequestMapping("school-management/employeeAddress")
@Slf4j
public class EmployeeAddressController {

    private final IEmployeeAddressService iEmployeeAddressService;

    @Autowired
    public EmployeeAddressController(IEmployeeAddressService iEmployeeAddressService){
        this.iEmployeeAddressService = iEmployeeAddressService;
    }


    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@Valid @RequestBody EmployeeAddress employeeAddress){
        log.info("save request:{}",employeeAddress);
        EmployeeAddress valEmployeeAddress;
        try {
            valEmployeeAddress = EmployeeAddressFactory.build(employeeAddress.getStaffId(), employeeAddress.getAddress());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        EmployeeAddress save = iEmployeeAddressService.save(valEmployeeAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable String staffId){
        log.info("Read request:{}",staffId);
        EmployeeAddress employeeAddress = this.iEmployeeAddressService.read(staffId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeAddress);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable String staffId) {
        log.info("Read request:{}", staffId);
        this.iEmployeeAddressService.deleteById(staffId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>>findAll(){
        List <EmployeeAddress> employeeAddress = this.iEmployeeAddressService.findAll();
        return ResponseEntity.ok(employeeAddress);

    }

}
