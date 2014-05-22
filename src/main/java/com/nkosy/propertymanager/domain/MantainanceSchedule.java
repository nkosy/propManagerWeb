package com.nkosy.propertymanager.domain;

import java.io.Serializable;
import java.util.Objects;
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
public class MantainanceSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Building building;
    private String previousDate;
    private String nextDate;
    
    private MantainanceSchedule()
    {}
    
    private MantainanceSchedule(Builder builder)
    {
        building = builder.building;
        previousDate = builder.previousDate;
        nextDate = builder.nextDate;
    }
    
    public static class Builder
    {
        private Building building;
        private String previousDate;
        private String nextDate;
        
        public Builder(Building value)
        {
            this.building = value;
        }
        
        public Builder previousDate(String value)
        {
            this.previousDate = value;
            return this;
        }
        
        public Builder nextDate(String value)
        {
            this.nextDate = value;
            return this;
        }
        
        public MantainanceSchedule build()
        {
            return new MantainanceSchedule(this);
        }
    }

    
    public Long getId() {
        return id;
    }

    public Building getBuilding() {
        return building;
    }

    public String getPreviousDate() {
        return previousDate;
    }

    public String getNextDate() {
        return nextDate;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final MantainanceSchedule other = (MantainanceSchedule) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.nkosy.propertymanager.domain.mantainanceShcedule[ id=" + id + " ]";
    }
}
