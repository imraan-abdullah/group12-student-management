package za.ac.cput.schoolmanagement.domain;
// Velenkosini Prince Jeza (218191669)


import java.util.Objects;

public class EmployeeAddress {
    private final String staffId, address;
    private EmployeeAddress(Builder builder) {
        this.staffId = builder.staffId;
        this.address = builder.address;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getAddress() {
        return address;
    }
    public static class Builder {
        private String staffId, address;

        public Builder staffId(String staffId){
            this.staffId =staffId;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder copy(EmployeeAddress employeeAddress){
            this.staffId = employeeAddress.staffId;
            this.address = employeeAddress.address;
            return this;
        }

        public EmployeeAddress build() {
            return new EmployeeAddress(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass() ) return false;
        EmployeeAddress that = (EmployeeAddress) o;
        return staffId.equals(that.staffId) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, address);
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
