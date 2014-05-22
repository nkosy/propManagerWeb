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
public class MantainanceInspector implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<MantainanceSchedule> schedules = new ArrayList<MantainanceSchedule>();
    
    private MantainanceInspector(){}
    
    private MantainanceInspector(Builder builder)
    {
        name = builder.name;
    }
    
    public static class Builder
    {
        private String name;
        private List<MantainanceSchedule> schedules = new ArrayList<MantainanceSchedule>();
        
        public Builder(String name)
        {
            this.name = name;
        }
        
        public Builder schedules(List<MantainanceSchedule> value)
        {
            schedules = value;
            return this;
        }
        public MantainanceInspector build()
        {
            return new MantainanceInspector(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MantainanceSchedule> getSchedules() {
        return schedules;
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
        if (!(object instanceof MantainanceInspector)) {
            return false;
        }
        MantainanceInspector other = (MantainanceInspector) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.MantainanceInspector[ id=" + id + " ]";
    }   
}
