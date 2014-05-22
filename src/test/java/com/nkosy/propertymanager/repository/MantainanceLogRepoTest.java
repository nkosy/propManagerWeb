/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.repository;

import com.nkosy.propertymanager.app.ConnectionConfig;
import com.nkosy.propertymanager.domain.MantainanceLog;
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
public class MantainanceLogRepoTest {
    private static ApplicationContext ctx;
    private MantainanceLogRepo repo;
    private long id;
    
    public MantainanceLogRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void addLog() 
    {
        repo = ctx.getBean(MantainanceLogRepo.class);
        
        MantainanceLog newLog = new MantainanceLog.Builder("leak")
                .date("22/05/2014")
                .build();
        
        repo.save(newLog);
        id = newLog.getId();
        Assert.assertNotNull(newLog);
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
