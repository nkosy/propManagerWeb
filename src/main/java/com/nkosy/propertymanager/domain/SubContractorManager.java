/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author nkosy
 */
@Entity
public class SubContractorManager implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNum;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private SubContractor company;
    
    private SubContractorManager (){}
    
    private SubContractorManager(Builder builder)
    {
        this.name = builder.name;
        this.phoneNum = builder.phoneNum;
        this.email = builder.email;
        this.company = builder.company;
    }
    
    public static class Builder
    {
        private String name;
        private String phoneNum;
        private String email;
        private SubContractor company;
        
        public Builder(String name)
        {
            this.name = name;
        }
        
        public Builder phoneNum(String value)
        {
            phoneNum = value;
            return this;
        }
        
        public Builder email(String value)
        {
            email = value;
            return this;
        }
        
        public Builder company(SubContractor value)
        {
            company = value;
            return this;
        }
        
        public SubContractorManager build()
        {
            return new SubContractorManager(this);
        }
    }
  
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public SubContractor getCompany() {
        return company;
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
        if (!(object instanceof SubContractorManager)) {
            return false;
        }
        SubContractorManager other = (SubContractorManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.SubContractorManager[ id=" + id + " ]";
    }
    
}
