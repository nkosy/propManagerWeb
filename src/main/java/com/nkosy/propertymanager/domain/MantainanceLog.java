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
public class MantainanceLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String date;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<Item>();
    
    private MantainanceLog(){}
    
    private MantainanceLog(Builder builder)
    {
        this.description = builder.description;
        this.date = builder.date;
        itemList = builder.itemList;
    }
    
    public static class Builder{
        private String description;
        private String date;
        private List<Item> itemList = new ArrayList<Item>();
        
        public Builder(String desc)
        {
            this.description = desc;
        }
        
        public Builder date(String value)
        {
            date = value;
            return this;
        }
        
        public Builder itemList(List<Item> value)
        {
            itemList = value;
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

    public List<Item> getItemList() {
        return itemList;
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
