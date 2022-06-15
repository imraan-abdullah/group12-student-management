package za.ac.cput.schoolmanagement.domain;
// Velenkosini Prince Jeza (218191669)


import java.util.Objects;

public class StudentAddress {
    private final String studentId, address;
    private StudentAddress(StudentAddress.Builder builder) {
        this.studentId = builder.studentId;
        this.address = builder.address;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAddress() {
        return address;
    }
    public static class Builder {
        private String studentId, address;

        public StudentAddress.Builder studentId(String studentId){
            this.studentId =studentId;
            return this;
        }

        public StudentAddress.Builder address(String address){
            this.address = address;
            return this;
        }

        public StudentAddress.Builder copy(StudentAddress employeeAddress){
            this.studentId = employeeAddress.studentId;
            this.address = employeeAddress.address;
            return this;
        }

        public StudentAddress build() {
            return new StudentAddress(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass() ) return false;
        StudentAddress that = (StudentAddress) o;
        return studentId.equals(that.studentId) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, address);
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
