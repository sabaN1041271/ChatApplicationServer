///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.chatapplication.helpers;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.fxml.Initializable;
//
///**
// *
// * @author ntu-user
// */
//public class ServerXYZ implements Initializable {
//    
//  public int personalContacts;
//  
//   
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//        new Thread(() -> {
//        try {
//
//
//
//        //Create a server socket for personal contact(one to one chat)
//        ServerSocket serverSocketPC = new ServerSocket(6999);
//        while (true) {
//            // Listen for a new connection request for one to one chat
//            Socket socketPC = serverSocketPC.accept();
//            personalContacts++;
//// Create and start a new thread for the connection
//            new Thread(new HandleAClient(socketPC, transcriptPC, textArea)).start();
//         }
//        } catch (IOException ex) {
//        ex.printStackTrace();
//        }
//        }).start();
//        
//        
//
//        
//         new Thread() {
//            public void run() {
//                ServerSocket server;
//                try {
//                    server = new ServerSocket(8999);
//                    while(true) {
//                    Socket groupChat = server.accept();
//                    //handle client1
//                    }
//                } catch (IOException ex) {
//                    Logger.getLogger(ServerXYZ.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//    }}.start();
//        
//        
//        
//        
//        transcript = new Transcript();
//transcriptPC=new Transcript();
//transcriptGC=new Transcript();
//new Thread(() -> {
//try {
//
//
//
////Create a server socket for personal contact(one to one chat)
//ServerSocket serverSocketPC = new ServerSocket(6500);
//while (true) {
//
//
//
//// Listen for a new connection request for one to one chat
//Socket socketPC = serverSocketPC.accept();
//
//
//
//// Increment clientNo
//personalcontacts++;
//
//
//
//Platform.runLater(() -> {
//// Display the client number
//textArea.appendText("Starting thread for personalcontacts " + personalcontacts
//+ " at " + new Date() + '\n');
//});
//
//
//
//// Create and start a new thread for the connection
//new Thread(new HandleAClient(socketPC, transcriptPC, textArea)).start();
//}
//} catch (IOException ex) {
//ex.printStackTrace();
//}
//}).start();
//
//
//new Thread(() -> {
//try {
//// Create a server socket for chat room (group chats)
//ServerSocket serverSocket = new ServerSocket(7000);
//
//while (true) {
//// Listen for a new connection request
//Socket socket = serverSocket.accept();
//
//// Increment clientNo
//clientNo++;
//
//
//
//Platform.runLater(() -> {
//// Display the client number
//textArea.appendText("Starting thread for client " + clientNo
//+ " at " + new Date() + '\n');
//});
//
//
//
//// Create and start a new thread for the connection
//new Thread(new HandleAClient(socket, transcriptGC, textArea)).start();
//
//}
//} catch (IOException ex) {
//System.err.println(ex);
//}
//}).start();
//}
//}
//    
//    
//
