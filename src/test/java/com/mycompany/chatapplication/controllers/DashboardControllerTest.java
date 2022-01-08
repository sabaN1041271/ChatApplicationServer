/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.chatapplication.controllers;

import com.mycompany.chatapplication.models.UserDetails;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ntu-user
 */
public class DashboardControllerTest {
    
    public DashboardControllerTest() {
    }

    /**
     * Test of getLoggedInUserDetails method, of class DashboardController.
     */
    @Test
    public void testGetLoggedInUserDetails() {
        System.out.println("getLoggedInUserDetails");
        DashboardController instance = new DashboardController();
        UserDetails expResult = null;
        UserDetails result = instance.getLoggedInUserDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoggedInUserDetails method, of class DashboardController.
     */
    @Test
    public void testSetLoggedInUserDetails() {
        System.out.println("setLoggedInUserDetails");
        UserDetails newloggedInUserDetails = null;
        DashboardController instance = new DashboardController();
        instance.setLoggedInUserDetails(newloggedInUserDetails);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class DashboardController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        DashboardController instance = new DashboardController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openProfilePage method, of class DashboardController.
     */
    @Test
    public void testOpenProfilePage() throws Exception {
        System.out.println("openProfilePage");
        ActionEvent event = null;
        DashboardController instance = new DashboardController();
        instance.openProfilePage(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewTitledPane method, of class DashboardController.
     */
    @Test
    public void testAddNewTitledPane() throws Exception {
        System.out.println("addNewTitledPane");
        String messageFromServer = "";
        int groupId = 0;
        int senderUserId = 0;
        int receiverUserId = 0;
        Date dateOfMessageSent = null;
        VBox vBox = null;
        DashboardController.addNewTitledPane(messageFromServer, groupId, senderUserId, receiverUserId, dateOfMessageSent, vBox);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
