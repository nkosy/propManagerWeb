package com.nkosy.propertymanager.repository;

import com.nkosy.propertymanager.app.ConnectionConfig;
import com.nkosy.propertymanager.domain.Address;
import com.nkosy.propertymanager.domain.Building;
import com.nkosy.propertymanager.repository.BuildingRepository;
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
public class BuildingRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;

    private BuildingRepository repo;
    
    public BuildingRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void CreateBuilding() {
        repo = ctx.getBean(BuildingRepository.class);
      
        Address myAdd = new Address.Builder("12233").street("Cape Town").city("Western cape")
                .Build();
               
        Building newBuilding = new Building.Builder("CityAge").address(myAdd).build();
        
        repo.save(newBuilding);
         id = newBuilding.getId();
         Assert.assertNotNull(newBuilding);
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
