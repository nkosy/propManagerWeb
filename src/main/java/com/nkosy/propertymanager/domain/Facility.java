package com.nkosy.propertymanager.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author nkosy
 */
abstract class Facility {
    protected String name;
    protected String lastMantained;
    

    public String getName() {
        return name;
    }

    public String getLastMantained() {
        return lastMantained;
    }
}
