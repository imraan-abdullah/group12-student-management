//Ameer Samsodien
//220005060
//IStudentRepository.java
//16 June

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, String> {
}
