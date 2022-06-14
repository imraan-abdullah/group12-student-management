package za.ac.cput.domain;
import java.util.Objects;
/***
 * Address.java
 * Entity for Address
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 11 June 2022
 */

public class Address {
    private String streetNumber;       //Required
    private String streetName;         //Required
    private int postalCode;            //Required
    private String unitNumber;         //Optional
    private String complexName;        //Optional
    private City city;                 //Required

    //Constructor
    public Address(Builder builder){
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.city = builder.city;
    }

    //Getters
    public String getStreetNumber() {

        return streetNumber;
    }

    public String getStreetName() {

        return streetName;
    }

    public int getPostalCode() {

        return postalCode;
    }

    public String getUnitNumber() {

        return unitNumber;
    }

    public String getComplexName() {

        return complexName;
    }

    public City getCity() {

        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode +
                ", unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return //postalCode.equals(address.postalCode) &&
                streetName.equals(address.streetName)
                        && unitNumber.equals(address.unitNumber)
                        && complexName.equals(address.complexName)
                        && city.equals(address.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(streetNumber, streetName, postalCode, unitNumber, complexName, city);
    }

    public static class Builder{
        private String streetNumber;
        private String streetName;
        private int postalCode;
        private String unitNumber;
        private String complexName;
        private City city;

        //Setters
        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setUnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder setComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Builder setCity(City city) {
            this.city = city;
            return this;
        }

        public Builder copy(Address address){
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.city = address.city;
            return this;
        }

        //build method that returns the instance
        public Address build(){

            return new Address(this);
        }
    }
}
