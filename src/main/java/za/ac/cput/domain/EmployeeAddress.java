package za.ac.cput.domain;
/*
* Velenkosini Prince Jeza (218191669)
* */


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class EmployeeAddress {
    @NotNull @Id
    private String staffId;
    @Embedded
    private Address address;

    protected EmployeeAddress(){}

    private EmployeeAddress(Builder builder) {
        this.staffId = builder.staffId;
        this.address = builder.address;
    }

    //Getters
    public String getStaffId() {
        return staffId;
    }

    public Address getAddress() {
        return address;
    }

    //Setters
    public static class Builder {
        private String staffId;
        private Address address;

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(EmployeeAddress employeeAddress) {
            this.staffId = employeeAddress.staffId;
            this.address = employeeAddress.address;
            return this;
        }
        public EmployeeAddress build(){
            return new EmployeeAddress (this);
        }
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeAddress employeeAddress = (EmployeeAddress) o;
        return staffId.equals(employeeAddress.staffId);
    }

    @Override
    public int hashCode() {return Objects.hash(staffId);}

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                ", address=" + address +
                '}';
    }
}
