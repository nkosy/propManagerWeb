/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nkosy
 */
@Entity
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobDescription;
    private double cost;
    private MantainanceInspector inspector;
    
    private Job()
    {}
    
    public Job(Builder builder)
    {
        jobDescription = builder.jobDescription;
        cost = builder.cost;
        inspector = builder.inspector;
    }
    
    public static class Builder
    {
        private Long id;
        private String jobDescription;
        private double cost;
        private MantainanceInspector inspector;
        
        public Builder(String jobDesc)
        {
          this.jobDescription = jobDesc;   
        }
        
        public Builder cost(double value)
        {
            cost = value;
            return this;
        }
        
        public Builder inspector(MantainanceInspector value)
        {
            inspector = value;
            return this;
        }
        
        public Job build()
        {
            return new Job(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public double getCost() {
        return cost;
    }

    public MantainanceInspector getInspector() {
        return inspector;
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
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.Job[ id=" + id + " ]";
    }
    
}
