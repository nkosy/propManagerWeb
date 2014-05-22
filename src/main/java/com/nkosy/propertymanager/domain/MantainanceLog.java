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
public class MantainanceLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String date;
    
    private MantainanceLog(){}
    
    private MantainanceLog(Builder builder)
    {
        this.description = builder.description;
        this.date = builder.date;
    }
    
    public static class Builder{
        private String description;
        private String date;
        
        public Builder(String desc)
        {
            this.description = desc;
        }
        
        public Builder date(String value)
        {
            date = value;
            return this;
        }
        
        public MantainanceLog build()
        {
            return new MantainanceLog(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
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
        if (!(object instanceof MantainanceLog)) {
            return false;
        }
        MantainanceLog other = (MantainanceLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.mantainanceLog[ id=" + id + " ]";
    }
}
