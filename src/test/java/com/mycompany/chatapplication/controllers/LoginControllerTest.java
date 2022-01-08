/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapplication.controllers;

import com.mycompany.chatapplication.models.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ntu-user
 */

public class LoginControllerTest {
    
    public LoginControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
   public void validateLoginPass() throws Exception{
       LoginController instance = new LoginController();
       List<UserDetails> UserList = new ArrayList<UserDetails>();
       UserDetails user = new UserDetails();
       user.setUserID(1);
       user.setUserName("charlie");
       user.setPassword("ytwRkl0zKE7mEm3T7bHhMA==");
       UserList.add(user);
       UserDetailsList userDetailsList = new UserDetailsList();
       userDetailsList.UserList = UserList;
       instance.userList = userDetailsList;
       Boolean success = instance.validateLoginCredential("charlie", "abcd");
       assertEquals(true,success);         
   }
   
   @Test
   public void validateLoginFail() throws Exception{
       LoginController instance = new LoginController();
       List<UserDetails> UserList = new ArrayList<UserDetails>();
       UserDetails user = new UserDetails();
       user.setUserID(1);
       user.setUserName("charlie");
       user.setPassword("ytwRkl0zKE7mEm3T7bHhMA==");
       UserList.add(user);
       UserDetailsList userDetailsList = new UserDetailsList();
       userDetailsList.UserList = UserList;
       instance.userList = userDetailsList;
       Boolean success = instance.validateLoginCredential("charlie", "defg");
       assertEquals(false,success);         
   }
}
