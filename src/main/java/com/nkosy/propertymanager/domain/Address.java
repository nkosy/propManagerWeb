package com.nkosy.propertymanager.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author nkosy
 */
@Embeddable
public class Address implements Serializable {
    
    private String zipCode;
    private String street;
    private String city;
    //private String buildingName;
    
    private Address() 
    {}
    
    private Address(Builder builder)
    {
        zipCode = builder.zipCode;
        street = builder.street;
        city = builder.city;
        //buildingName = builder.buildingName;
    }

    public static class Builder {

        private String zipCode;
        private String street;
        private String city;
        //private String buildingName;

        public Builder(String zipCode) {
            this.zipCode = zipCode;
        }

        public Builder street(String value) {
            street = value;
            return this;
        }
        
        public Builder city(String value){
            city = value;
            return this;
        }
        
//        public Builder buildingName(String value){
//            buildingName = value;
//            return this;
//        }
        public Address Build()
        {
            return new Address(this);
        }
    }
    

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

//    public String getBuildingName() {
//        return buildingName;
//    }
  
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.zipCode);
        hash = 31 * hash + Objects.hashCode(this.street);
        hash = 31 * hash + Objects.hashCode(this.city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }    
}
