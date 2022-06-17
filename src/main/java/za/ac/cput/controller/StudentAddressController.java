package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.*;
import za.ac.cput.factory.StudentAddressFactory;
import za.ac.cput.factory.StudentFactory;
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
@RequestMapping("school-management/student-address/")
@Slf4j
public class StudentAddressController {
    private IStudentAddressService studentAddressService;

    @Autowired
    public StudentAddressController(IStudentAddressService iStudentAddressService){
        this.studentAddressService = iStudentAddressService;
    }

    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress){
        log.info("Save request:{}", studentAddress);
        StudentAddress studentAddressVal;
        try {
            studentAddressVal = StudentAddressFactory.build(studentAddress.getStudentId(), studentAddress.getAddress());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        StudentAddress save = studentAddressService.save(studentAddressVal);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{studentId}")
    public ResponseEntity<StudentAddress> read(@PathVariable String studentId){
        log.info("Read request:{}", studentId);
        StudentAddress studentAddress = this.studentAddressService.read(studentId)
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

