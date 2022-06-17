/*
    Shasta Abrahams - 217059376
    EmployeeController.java
    16 June 2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.IEmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/employee/")
@Slf4j
public class EmployeeController {
    private final IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeController(IEmployeeService iEmployeeService){
        this.iEmployeeService = iEmployeeService;
    }

    //Imraan
    @PostMapping("save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee){
        log.info("save request:{}",employee);
        Employee valEmployee;
        try {
            valEmployee = EmployeeFactory.build(employee.getStaffId(), employee.getEmail(),employee.getName());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Employee save = iEmployeeService.save(valEmployee);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Employee> read(@PathVariable String staffId){
        log.info("Read request:{}",staffId);
        Employee employee = this.iEmployeeService.read(staffId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable String staffId) {
        log.info("Read request:{}", staffId);
        this.iEmployeeService.deleteById(staffId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>>findAll(){
        List <Employee> employee = this.iEmployeeService.findAll();
        return ResponseEntity.ok(employee);

    }
}
