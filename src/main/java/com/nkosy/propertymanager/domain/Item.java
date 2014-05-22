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
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private String lastReplaced;

    private Item() {
    }
    
    private Item(Builder builder){
        name = builder.name;
        price = builder.price;
        lastReplaced = builder.lastReplaced;
    }

    public static class Builder {

        private String name;
        private double price;
        private String lastReplaced;
        
        public Builder (String name){
            this.name = name;
        }
        
        public Builder price(double value){
            price = value;
            return this;
        }
        
        public Builder lastReplaced(String value){
            lastReplaced = value;
            return this;
        }
        
        public Item build(){
            return new Item(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getLastReplaced() {
        return lastReplaced;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.Items[ id=" + id + " ]";
    }

}
