package za.ac.cput.factory;
/*
 * Velenkosini Prince Jeza (218191669)
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {

        @Test
        public void buildWithSuccess() {
            StudentAddress studentAddress = StudentAddressFactory.build("test staff Id", null);
            System.out.println(studentAddress);
            assertNotNull(studentAddress);
        }

        @Test public void buildWithError() {
            Exception exception = assertThrows(IllegalArgumentException.class, () ->
                    StudentAddressFactory.build("",null));
            System.out.println(exception.getMessage());
            assertTrue(exception.getMessage().contains("staffId"));
        }

}