package com.nkosy.propertymanager.repository.test;

import com.nkosy.propertymanager.app.ConnectionConfig;
import com.nkosy.propertymanager.domain.Level;
import com.nkosy.propertymanager.repository.LevelRepository;
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
public class LevelRepositoryTest {
    private static ApplicationContext ctx;
    private LevelRepository repo;
    private long id;
    
    public LevelRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void addLevel() 
    {
        repo = ctx.getBean(LevelRepository.class);
        Level newLevel = new Level.Builder("Ground Floor")
                .spaceList(null)
                .build();
        repo.save(newLevel);
        id = newLevel.getId();
        Assert.assertNotNull(newLevel);
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
