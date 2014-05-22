/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.repository.test;

import com.nkosy.propertymanager.app.ConnectionConfig;
import com.nkosy.propertymanager.domain.Job;
import com.nkosy.propertymanager.domain.MantainanceInspector;
import com.nkosy.propertymanager.repository.JobRepository;
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
public class JobRepositoryTest {
    private static ApplicationContext ctx;
    private long id;
    private JobRepository repo;
    
    
    public JobRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createJob() 
    {
        repo = ctx.getBean(JobRepository.class);
        
        MantainanceInspector inspector = new MantainanceInspector.Builder("George")
                .schedules(null)
                .build();
        
        Job newJob = new Job.Builder("Paint the walls")
                .cost(500.00)
                .inspector(inspector)
                .build();
        
        repo.save(newJob);
        id = newJob.getId();
        Assert.assertNotNull(newJob);
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
