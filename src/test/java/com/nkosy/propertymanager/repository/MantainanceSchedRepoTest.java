/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.repository;

import com.nkosy.propertymanager.app.ConnectionConfig;
import com.nkosy.propertymanager.domain.Address;
import com.nkosy.propertymanager.domain.Building;
import com.nkosy.propertymanager.domain.MantainanceSchedule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author nkosy
 */
public class MantainanceSchedRepoTest {
    private static ApplicationContext ctx;
    private long id;
    private MantainanceScheduleRepository repo;
    
    public MantainanceSchedRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test(enabled = true)
     public void createSchedule() 
     {
         repo = ctx.getBean(MantainanceScheduleRepository.class);
         Address myAdd = new Address.Builder("12233").street("Cape Town").city("Western cape")
                .Build();
               
         Building newBuilding = new Building.Builder("CityAge").address(myAdd)
                 .build();
         
         MantainanceSchedule newSchedule = new  MantainanceSchedule.Builder(newBuilding)
                 .previousDate("13/01/2014")
                 .nextDate("13/06/2014")
                 .build();
         
         repo.save(newSchedule);
         id = newSchedule.getId();
         Assert.assertNotNull(newSchedule);

     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
