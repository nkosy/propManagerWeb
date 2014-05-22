/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author nkosy
 */
@Entity
public class OfficeSpace implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String size;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Kitchen officeKitchen;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Bathroom> toilets = new ArrayList<Bathroom>();
    
    private OfficeSpace() {}
    
    private OfficeSpace(Builder builder) 
    {
        size = builder.size;
        officeKitchen = builder.officeKitchen;
    }
    
    public static class Builder {
        private String size;
        private Kitchen officeKitchen;
        private List<Bathroom> toilets = new ArrayList<Bathroom>();
        
        public Builder(String size)
        {
            this.size = size;
        }
        
        public Builder officeKitchen(Kitchen value){
            
            officeKitchen = value;
            return this;
        }
        public OfficeSpace build(){
            return new OfficeSpace(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public Kitchen getOfficeKitchen() {
        return officeKitchen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfficeSpace)) {
            return false;
        }
        OfficeSpace other = (OfficeSpace) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.officeSpace[ id=" + id + " ]";
    }
    
}
