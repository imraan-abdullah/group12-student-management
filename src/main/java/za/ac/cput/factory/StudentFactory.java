//Ameer Samsodien
//220005060
//StudentFactory.java
//12 June

package za.ac.cput.factory;

import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.helper.StringHelper;

public class StudentFactory {
    public static Student build(String studentId, String email, Name name){
        StringHelper.checkStringParam("studentId", studentId);
        StringHelper.checkStringParam("email", email);
        StringHelper.checkEmailValidation(email);
        StringHelper.checkId(studentId);
        return new Student.Builder().setStudentId(studentId)
                .setEmail(email)
                .setName(name)
                .build();
    }
}
