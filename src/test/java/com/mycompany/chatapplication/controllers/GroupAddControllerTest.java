/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.chatapplication.controllers;

import com.mycompany.chatapplication.models.UserDetails;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ntu-user
 */
public class GroupAddControllerTest {
    
    public GroupAddControllerTest() {
    }

    /**
     * Test of getLoggedInUserDetails method, of class GroupAddController.
     */
    @Test
    public void testGetLoggedInUserDetails() {
        System.out.println("getLoggedInUserDetails");
        GroupAddController instance = new GroupAddController();
        UserDetails expResult = null;
        UserDetails result = instance.getLoggedInUserDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoggedInUserDetails method, of class GroupAddController.
     */
    @Test
    public void testSetLoggedInUserDetails() {
        System.out.println("setLoggedInUserDetails");
        UserDetails newloggedInUserDetails = null;
        GroupAddController instance = new GroupAddController();
        instance.setLoggedInUserDetails(newloggedInUserDetails);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class GroupAddController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        GroupAddController instance = new GroupAddController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of btnCreateClick method, of class GroupAddController.
     */
    @Test
    public void testBtnCreateClick() throws Exception {
        System.out.println("btnCreateClick");
        ActionEvent event = null;
        GroupAddController instance = new GroupAddController();
        instance.btnCreateClick(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of btnCancelClick method, of class GroupAddController.
     */
    @Test
    public void testBtnCancelClick() throws Exception {
        System.out.println("btnCancelClick");
        ActionEvent event = null;
        GroupAddController instance = new GroupAddController();
        instance.btnCancelClick(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
