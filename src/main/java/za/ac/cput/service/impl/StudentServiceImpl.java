//Ameer Samsodien
//220005060
//StudentServiceImpl.java
//16 June

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.IStudentRepository;
import za.ac.cput.service.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository repository;

    @Autowired
    public StudentServiceImpl(IStudentRepository repository){ this.repository = repository;}

    @Override
    public Student save(Student student) {return this.repository.save(student);}

    @Override
    public Optional<Student> read(String studentId) {return this.repository.findById(studentId);}

    @Override
    public void delete(Student student) {this.repository.delete(student);}

    @Override
    public List<Student> findAll() {return this.repository.findAll();}

}
