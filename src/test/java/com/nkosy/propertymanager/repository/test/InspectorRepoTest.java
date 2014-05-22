/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.repository.test;

import com.nkosy.propertymanager.app.ConnectionConfig;
import com.nkosy.propertymanager.domain.Address;
import com.nkosy.propertymanager.domain.Building;
import com.nkosy.propertymanager.domain.MantainanceInspector;
import com.nkosy.propertymanager.domain.MantainanceSchedule;
import com.nkosy.propertymanager.repository.InspectorRepository;
import java.util.ArrayList;
import java.util.List;
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
public class InspectorRepoTest {
    private static ApplicationContext ctx;
    private long id;
    private InspectorRepository repo;
    
    public InspectorRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void AddInspector() 
    {
        repo = ctx.getBean(InspectorRepository.class);
        
        List<MantainanceSchedule> scheduleList = new ArrayList<MantainanceSchedule>(); 
        
        Address myAdd1 = new Address.Builder("12233").street("Cape Town").city("Western cape")
                .Build();
         
        Building newBuilding1= new Building.Builder("CityAge").address(myAdd1)
                 .build();
         
        MantainanceSchedule newSchedule1 = new  MantainanceSchedule.Builder(newBuilding1)
                 .previousDate("13/01/2014")
                 .nextDate("13/06/2014")
                 .build();
       
        scheduleList.add(newSchedule1);
        
        Address myAdd2 = new Address.Builder("838383").street("Dorset").city("Cape Town")
                .Build();
        
        Building newBuilding2= new Building.Builder("NMJ").address(myAdd2)
                 .build();
        
        MantainanceSchedule newSchedule2 = new  MantainanceSchedule.Builder(newBuilding2)
                 .previousDate("13/02/2014")
                 .nextDate("13/07/2014")
                 .build();
        
        scheduleList.add(newSchedule2);
        
        MantainanceInspector inspector = new MantainanceInspector.Builder("George")
                .schedules(scheduleList)
                .build();
        
        repo.save(inspector);
        id = inspector.getId();
        Assert.assertNotNull(inspector);
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
