//Ameer Samsodien
//220005060
//StudentServiceImplTest.java
//16 June

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.IStudentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceImplTest {

    private final Name name = NameFactory.build("", "", "");
    private final Student student = StudentFactory.build("", "", name);

    @Autowired private IStudentService service;

    @Order(1)
    @Test
    void save(){
        Student saved = this.service.save(this.student);
        System.out.println(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.student,saved)
        );
    }

    @Order(2)
    @Test
    void read(){
        Optional<Student> read = this.service.read((this.student.getStudentId()));
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.student, read.get())
        );
    }

    @Order(3)
    @Test
    void findAll(){
        List<Student> studentList = this.service.findAll();
        System.out.println(studentList);
        assertEquals(1, studentList.size());
    }

    @Order(4)
    @Test
    void delete(){
        this.service.delete(this.student);
        List<Student> studentList = this.service.findAll();
        assertEquals(0, studentList.size());
    }

}