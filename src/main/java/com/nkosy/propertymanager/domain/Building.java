package com.nkosy.propertymanager.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author 212018183
 */
@Entity
public class Building implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String buildingName;
    @Embedded
    private Address buildingAddress;
   
 
    private Building()
    {}
    
    private Building(Builder builder){
        
        buildingName = builder.buildingName;
        buildingAddress = builder.buildingAddress;
    }

    public static class Builder {
        private String buildingName;
        private Address buildingAddress;
        
        
        public Builder( String name ){
            this.buildingName = name;
        }
        
        public Builder address( Address value )
        {
            buildingAddress = value;
            return this;
        }
        
        public Building build(){
            return new Building(this);
            
        }
    }


    public Long getId() {
        return id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public Address getBuildingAddress() {
        return buildingAddress;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Building other = (Building) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.Building1[ id =" + id + " ]";
    }
}
