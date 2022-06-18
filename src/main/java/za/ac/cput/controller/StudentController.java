//Ameer Samsodien
//220005060
//StudentController.java
//17 June

package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.IStudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/student/")
@Slf4j
public class StudentController {
    private final IStudentService iStudentService;

    @Autowired
    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @PostMapping("save")
    public ResponseEntity<Student>save(@Valid @RequestBody Student student){
        log.info("save request:{}", student);
        Student valStudent;
        try {
            valStudent = StudentFactory.build(student.getStudentId(), student.getEmail(), student.getName());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Student save = iStudentService.save(valStudent);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{studentId}")
    public ResponseEntity<Student>read(@PathVariable String studentId){
        log.info("Read request:{}", studentId);
    Student student = this.iStudentService.read(studentId)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable String id ){
        log.info("Read request:{}", id);
        this.iStudentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("all")
    public ResponseEntity<List<Student>>findAll(){
        List <Student> student = this.iStudentService.findAll();
        return ResponseEntity.ok(student);
    }

}
