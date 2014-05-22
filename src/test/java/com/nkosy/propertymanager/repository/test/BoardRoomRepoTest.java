package com.nkosy.propertymanager.repository.test;

import com.nkosy.propertymanager.app.ConnectionConfig;
import com.nkosy.propertymanager.domain.BoardRoom;
import com.nkosy.propertymanager.repository.BoardRoomRepo;
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
public class BoardRoomRepoTest {
    private static ApplicationContext ctx;
    private BoardRoomRepo repo;
    private long id;
    
    public BoardRoomRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void addBoardRoom() 
    {
        repo = ctx.getBean(BoardRoomRepo.class);
        BoardRoom room = new BoardRoom.Builder("Board room")
                .itemList(null)
                .lastMantained(null)
                .build();
        
        repo.save(room);
        id = room.getId();
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
