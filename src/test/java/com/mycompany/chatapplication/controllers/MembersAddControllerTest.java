/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.chatapplication.controllers;

import com.mycompany.chatapplication.models.GroupDetails;
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
public class MembersAddControllerTest {
    
    public MembersAddControllerTest() {
    }

    /**
     * Test of getGroupIdAndName method, of class MembersAddController.
     */
    @Test
    public void testGetGroupIdAndName() {
        System.out.println("getGroupIdAndName");
        MembersAddController instance = new MembersAddController();
        GroupDetails expResult = null;
        GroupDetails result = instance.getGroupIdAndName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupIdAndName method, of class MembersAddController.
     */
    @Test
    public void testSetGroupIdAndName() {
        System.out.println("setGroupIdAndName");
        GroupDetails newGroup = null;
        MembersAddController instance = new MembersAddController();
        instance.setGroupIdAndName(newGroup);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoggedInUserDetails method, of class MembersAddController.
     */
    @Test
    public void testGetLoggedInUserDetails() {
        System.out.println("getLoggedInUserDetails");
        MembersAddController instance = new MembersAddController();
        UserDetails expResult = null;
        UserDetails result = instance.getLoggedInUserDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoggedInUserDetails method, of class MembersAddController.
     */
    @Test
    public void testSetLoggedInUserDetails() {
        System.out.println("setLoggedInUserDetails");
        UserDetails newloggedInUserDetails = null;
        MembersAddController instance = new MembersAddController();
        instance.setLoggedInUserDetails(newloggedInUserDetails);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class MembersAddController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        MembersAddController instance = new MembersAddController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of btnAddClick method, of class MembersAddController.
     */
    @Test
    public void testBtnAddClick() throws Exception {
        System.out.println("btnAddClick");
        ActionEvent event = null;
        MembersAddController instance = new MembersAddController();
        instance.btnAddClick(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of btnCancelClick method, of class MembersAddController.
     */
    @Test
    public void testBtnCancelClick() throws Exception {
        System.out.println("btnCancelClick");
        ActionEvent event = null;
        MembersAddController instance = new MembersAddController();
        instance.btnCancelClick(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
