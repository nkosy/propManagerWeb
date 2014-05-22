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
public class BoardRoom extends Facility implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    protected List<Item> itemList = new ArrayList<Item>();
    
    private BoardRoom(){}
    
    private BoardRoom(Builder builder)
    {
        super();
        this.name = builder.name;
        this.lastMantained = builder.lastMantained;
        this.itemList = builder.itemList;
    }
    
    public static class Builder{
        private String name;
        private String lastMantained;
        protected List<Item> itemList = new ArrayList<Item>();
        
        public Builder(String name){
            this.name = name;
        }
        
        public Builder lastMantained(String value){
            lastMantained = value;
            return this;
        }
        
        public Builder itemList(List<Item> value){
           itemList = value;
           return this;
        }
        
        public BoardRoom build(){
            return new BoardRoom(this);
        }
            
    }


    public Long getId() {
        return id;
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
        if (!(object instanceof BoardRoom)) {
            return false;
        }
        BoardRoom other = (BoardRoom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.BoardRoom[ id=" + id + " ]";
    }
    
}
