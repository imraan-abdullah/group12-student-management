//Ameer Samsodien
//220005060
//IStudentService.java
//16 June

package za.ac.cput.service;

import za.ac.cput.domain.Student;
import java.util.List;

public interface IStudentService extends IService <Student, String> {
    List<Student> findAll();
}
