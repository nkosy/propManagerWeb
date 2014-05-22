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
import javax.persistence.OneToMany;

/**
 *
 * @author nkosy
 */
@Entity
public class Tenant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OfficeSpace> spaceList = new ArrayList<OfficeSpace>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<MantainanceLog> logList = new ArrayList<MantainanceLog>();
    
    private Tenant() 
    {}
    
    private Tenant(Builder builder)
    {
        name = builder.name;
        logList = builder.logList;
        spaceList = builder.spaceList;
    }
    public static class Builder{
        private String name;
        private List<OfficeSpace> spaceList = new ArrayList<OfficeSpace>();
        private List<MantainanceLog> logList = new ArrayList<MantainanceLog>();
        
        public Builder(String name)
        {
            this.name = name;
        }
        
        public Builder spaceList(List<OfficeSpace> value)
        {
            spaceList = value;
            return this;
        }
        
        public Builder logList(List<MantainanceLog> value)
        {
            logList = value;
            return this;
        }
        
        public Tenant build()
        {
            return new Tenant(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public List<MantainanceLog> getLogList() {
        return logList;
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
        if (!(object instanceof Tenant)) {
            return false;
        }
        Tenant other = (Tenant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.Tenant[ id=" + id + " ]";
    }
}
