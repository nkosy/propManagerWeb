/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.repository;

import com.nkosy.propertymanager.app.ConnectionConfig;
import com.nkosy.propertymanager.domain.Address;
import com.nkosy.propertymanager.domain.Building;
import com.nkosy.propertymanager.domain.BuildingManager;
import com.nkosy.propertymanager.repository.BuildingManagerRepository;
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
public class BuildingManagerRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    
    private BuildingManagerRepository repo;
    private List<Building> buildingsList = new ArrayList<Building>();
    
    public BuildingManagerRepositoryTest() {
    }
    
    @Test(enabled = true)
     public void createBuildingManager() 
     {
         repo = ctx.getBean(BuildingManagerRepository.class);
         
         Address addr1 = new Address.Builder("12233").street("Dorset").city("Cape Town")
                .Build();
         
         Address addr2 = new Address.Builder("44444").street("Luanda").city("WoodStock")
                .Build();
         
         Building building1 = new Building.Builder("CityAge")
                 .address(addr1)
                 .build();
         
         Building building2 = new Building.Builder("WoodStock")
                 .address(addr2)
                 .build();
         
         buildingsList.add(building1);
         buildingsList.add(building2);
         
         BuildingManager newManager = new BuildingManager.Builder("Nkosi")
                 .buildings(buildingsList)
                 .build();
         
         repo.save(newManager);
         id = newManager.getManagerId();
         Assert.assertNotNull(newManager);
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
