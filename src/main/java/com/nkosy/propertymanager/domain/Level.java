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
public class Level implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String levelName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OfficeSpace> spaceList = new ArrayList<OfficeSpace>();
    
    private Level() {}
    private Level(Builder builder) 
    {
        levelName = builder.levelName;
        spaceList = builder.spaceList;
    }
    
    public static class Builder{
        private String levelName;
        private List<OfficeSpace> spaceList = new ArrayList<OfficeSpace>();
        
        public Builder(String levelName)
        {
            this.levelName = levelName;
        }
        
        public Builder spaceList(List<OfficeSpace> value)
        {
            spaceList = value;
            return this;
        }
        
        public Level build()
        {
            return new Level(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getLevelName() {
        return levelName;
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
        if (!(object instanceof Level)) {
            return false;
        }
        Level other = (Level) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.Level[ id=" + id + " ]";
    }
    
}
