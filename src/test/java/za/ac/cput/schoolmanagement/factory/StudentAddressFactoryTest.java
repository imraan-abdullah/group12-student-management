package za.ac.cput.schoolmanagement.factory;
// Velenkosini Prince Jeza (218191669)

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {

    @Test public void build() {
        StudentAddress studentAddress = StudentAddressFactory.build("", "");
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }
}