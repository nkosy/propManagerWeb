/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
public class SubContractor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<MantainanceSchedule> scheduleList = new ArrayList<MantainanceSchedule>();
    

    private SubContractor() 
    {}
    
    private  SubContractor(Builder builder)
    {
        name = builder.name;
    }
    
    public static class Builder 
    {
        private String name;
        private List<MantainanceSchedule> scheduleList = new ArrayList<MantainanceSchedule>();
         
        public Builder(String name)
        {
            this.name = name;
        }
        
        public Builder scheduleList(List<MantainanceSchedule> value)
        {
            scheduleList = value;
            return this;
        }
        
        public SubContractor build()
        {
            return new SubContractor(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MantainanceSchedule> getScheduleList() {
        return scheduleList;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final SubContractor other = (SubContractor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
   
    @Override
    public String toString() {
    return "com.nkosy.propertymanager.domain.SubContractor[ id=" + id + " ]";
    }    
}
    


    

