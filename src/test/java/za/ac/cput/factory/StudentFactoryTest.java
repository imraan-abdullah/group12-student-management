//Ameer Samsodien
//220005060
//StudentFactoryTest.java
//12 June

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    public void buildWithSuccess() {
        Name name = NameFactory.build("test first name", "test middle name", "test last name");
        Student student = StudentFactory.build("2180", "test@cput.ac.za", name);
        System.out.println(student);
        assertNotNull(student);
    }

    @Test public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                StudentFactory.build("", "", null));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("studentId"));
    }
}