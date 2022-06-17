package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.*;
import za.ac.cput.service.IStudentAddressService;

import javax.validation.Valid;
import java.util.List;

/***
 * StudentAddressController.java
 * Controller for StudentAddress
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 16 June 2022
 */

@RestController
@RequestMapping("school-management/studentaddress/")
@Slf4j
public class StudentAddressController {
    private IStudentAddressService studentAddressService;

    @Autowired
    public StudentAddressController(IStudentAddressService studAddress){
        this.studentAddressService = studAddress;
    }

    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress){
        log.info("Save request as: {}", studentAddress);
        StudentAddress save = studentAddressService.save(studentAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<StudentAddress> read(@PathVariable String id){
        log.info("Read request: {}", id);
        StudentAddress studentAddress = this.studentAddressService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentAddress);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.studentAddressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<StudentAddress>> findAll(){
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        return ResponseEntity.ok(studentAddressList);
    }

}

