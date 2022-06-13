//Mariam Gallie- 219094837
// Name.java (domain package)
// 11 June 2022

package za.ac.cput.domain;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Name {
    @NotNull
    @Id
    private String firstName;
    @NotNull
    private String middleName;
    @NotNull
    private String lastName;

    protected Name() {
    }

    private Name(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
    @Override
    public String toString() {
        return "Builder{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Name name) {
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.lastName = name.lastName;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
//
////        public static class firstname{
////            private String firstName;
////
////            public firstname(String firstName){
////                this.firstName = firstName;
////            }
//
//        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Name that = (Name) o;
            return firstName.equals(that.firstName) && middleName.equals(that.middleName) && lastName.equals(that.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, middleName, lastName);
        }


    }

}
