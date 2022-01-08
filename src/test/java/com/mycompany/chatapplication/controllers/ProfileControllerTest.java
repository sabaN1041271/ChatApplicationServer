/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.chatapplication.controllers;

import com.mycompany.chatapplication.factories.JSONToObjectConvertorFactory;
import com.mycompany.chatapplication.helpers.ConvertedUserDetailsObjectFromJSON;
import com.mycompany.chatapplication.models.UserDetails;
import com.mycompany.chatapplication.models.UserDetailsList;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.reflection.FieldSetter;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
/**
 *
 * @author ntu-user
 */
@RunWith(PowerMockRunner.class) 
public class ProfileControllerTest {
        
    public ProfileControllerTest() {
    }

    @Before
    public void before() throws NoSuchFieldException {
          JSONToObjectConvertorFactory factory = mock(JSONToObjectConvertorFactory.class);
          ConvertedUserDetailsObjectFromJSON userDetailsMock = mock(ConvertedUserDetailsObjectFromJSON.class);
          List<Object> objList = new ArrayList<Object>();   
          UserDetailsList userList;
               
        ProfileController profileController = mock(ProfileController.class);
        UserDetails loggedInUserDetails = new UserDetails();
        loggedInUserDetails.setUserID(1);
        loggedInUserDetails.setUserName("champy");
        loggedInUserDetails.setPassword("ytwRkl0zKE7mEm3T7bHhMA==");
        
        userList = new UserDetailsList();
        userList.UserList = new ArrayList<UserDetails>();
        UserDetails user = new UserDetails();
        user.setUserID(1);
        user.setUserName("champy");
        user.setPassword("ytwRkl0zKE7mEm3T7bHhMA==");
        userList.UserList.add(user);
        
         FieldSetter.setField(profileController,profileController.getClass().getDeclaredField("txtUserName"), "champy");
         FieldSetter.setField(profileController,profileController.getClass().getDeclaredField("txtPassword"), "abcd");
         FieldSetter.setField(profileController,profileController.getClass().getDeclaredField("loggedInUserDetails"), loggedInUserDetails);

        
        when(factory.createObject("userDetails")).thenReturn(userDetailsMock);
        when(userDetailsMock.convertJSONToObject("")).thenReturn(userList);
        when(userDetailsMock.writeObjectToJSON(objList, "")).thenReturn(true);        

    }
    /**
     * Test of getLoggedInUserDetails method, of class ProfileController.
     */
    @Test
    public void testGetLoggedInUserDetails() {
        System.out.println("getLoggedInUserDetails");
        ProfileController instance = new ProfileController();
        UserDetails loggedInUserDetails = new UserDetails();
        loggedInUserDetails.setUserID(1);
        loggedInUserDetails.setUserName("charlie");
        loggedInUserDetails.setPassword("ytwRkl0zKE7mEm3T7bHhMA==");
        instance.setLoggedInUserDetails(loggedInUserDetails);            
        UserDetails result = instance.getLoggedInUserDetails();
        assertEquals(loggedInUserDetails, result);
    }
    /**
     * Test of btnSaveClick method, of class ProfileController.
     */
    
    @Test
    public void testBtnSaveClick() throws Exception {
        System.out.println("btnSaveClick");
        
        ActionEvent event = null;
        ProfileController profileController = mock(ProfileController.class);
        profileController.btnSaveClick(event);

    }
    
}
