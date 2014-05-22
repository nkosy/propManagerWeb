/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.repository;

import com.nkosy.propertymanager.app.ConnectionConfig;
import com.nkosy.propertymanager.domain.PrintingRoom;
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
public class PrintingRoomRepoTest {
    private static ApplicationContext ctx;
    private PrintingRoomRepo repo;
    private long id;
    
    public PrintingRoomRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void addPrintRoom() 
    {
        repo = ctx.getBean(PrintingRoomRepo.class);
        PrintingRoom room = new PrintingRoom.Builder("Printing Room")
                .itemList(null)
                .lastMantained(null)
                .build();
        
        repo.save(room);
        Assert.assertNotNull(room);
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
