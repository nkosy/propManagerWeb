package com.nkosy.propertymanager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author 212018183
 */
@Entity
public class BuildingManager implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long managerId;
    private String managerName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Building> buildings = new ArrayList<Building>();
    
    private BuildingManager()
    {}
    
    private BuildingManager(Builder builder){
        managerName = builder.managerName;
        buildings = builder.buildings;
    }
    
     public static class Builder {
        private String managerName;
        private List<Building> buildings = new ArrayList<Building>();
        
        public Builder(String name){
            this.managerName = name;
        }
        
       
        public Builder buildings(List<Building> value){
            buildings = value;
            return this;
        }
        
        public BuildingManager build(){
            return new BuildingManager(this);
        }
    }

    public Long getManagerId() {
        return managerId;
    }
    
    public String getManagerName() {
        return managerName;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.managerId);
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
        final BuildingManager other = (BuildingManager) obj;
        if (!Objects.equals(this.managerId, other.managerId)) {
            return false;
        }
        return true;
    }
   
    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.BuildingManager1[ managerId=" + managerId + " ]";
    }
}
