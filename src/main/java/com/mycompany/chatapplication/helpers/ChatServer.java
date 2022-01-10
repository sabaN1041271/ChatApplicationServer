/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapplication.helpers;

import com.mycompany.chatapplication.controllers.DashboardController;
import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
 
/**
 * This is the chat server program.
 *
 * @author www.codejava.net
 */
public class ChatServer extends Thread {
    private ServerSocket serverSocket;
    private static Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private ServerThread serverThread;
    public Set<String> userNames = new HashSet<>();
   static Vector<ServerThread> userThreads = new Vector<>();
    
    public ChatServer(Boolean calledFromPrivateChat, VBox ChatVBox, String userName) throws IOException{      
        try{
           // this.serverSocket = serverSocket;
         //   System.out.println("Server is listening on port " + serverSocket.getLocalPort() + " " + serverSocket.getInetAddress());


              if(calledFromPrivateChat){
                   System.out.println("Server is listening to address 6999");
                  ServerSocket serverSocket = new ServerSocket(6999);
                  
                   
                  this.socket = serverSocket.accept();
                  //this.socket.setReuseAddress(true);
                    this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                    this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
              }
              else{
                  new Thread(new Runnable(){
                       @Override
                        public void run() {
                             try {
            // Create a server socket for chat room (group chats)
            ServerSocket serverSocketGroup = new ServerSocket(8999);

            while (true) {
                
                 System.out.println("Listening to the port 8999");
            // Listen for a new connection request
            ChatServer.socket  = serverSocketGroup.accept();
            
             String userNameClient = new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();
             userNames.add(userNameClient);
             System.out.println("New Client: \"" + userNameClient + "\"\n\t     Host:" + socket.getRemoteSocketAddress());
             
             // Added clients to be broadcasted to already existing clients
             userNames.add(userName);
             String userNameListString = "Active members are : " + String.join(",", userNames);
                System.out.println(userNameListString);
         
             

             BufferedReader buffReader = new BufferedReader(new InputStreamReader(ChatServer.socket.getInputStream()));
                            BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(ChatServer.socket.getOutputStream()));
                           

                            System.out.println("Creating a new handler for this client...");
                            ServerThread newClient = new ServerThread(ChatServer.socket,ChatVBox,userNameListString, buffReader, buffWriter);

                                 // Create a new Thread with this object.
                        Thread t = new Thread(newClient);

                        System.out.println("Adding this client to active client list");

                        // add this client to active clients list
                       userThreads.add(newClient);

                        // start the thread.
                        t.start();

           
                            }
                          }catch (IOException ex) {
                                      Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                        }
                  
                  }).start();
                  
                  
                  
                  
//                  new Thread(() -> {
//            try {
//            // Create a server socket for chat room (group chats)
//            ServerSocket serverSocketGroup = new ServerSocket(8999);
//
//            while (true) {
//            // Listen for a new connection request
//            this.socket = serverSocketGroup.accept();
//
//             BufferedReader buffReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
//                            BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
//                            System.out.println("Creating a new handler for this client...");
//                            ServerThread newClient = new ServerThread(this.socket,this,ChatVBox, buffReader, buffWriter);
//
//                                 // Create a new Thread with this object.
//                        Thread t = new Thread(newClient);
//
//                        System.out.println("Adding this client to active client list");
//
//                        // add this client to active clients list
//                       userThreads.add(newClient);
//
//                        // start the thread.
//                        t.start();
//
//            //          while(true){
//            //                this.socket = serverSocket.accept();
//            //                 // this.socket.setReuseAddress(true);
//            //                System.out.println("New client connected");
//            //               // ServerThread newClient = new ServerThread(socket,this);
//            //               // userThreads.add(newClient);
//            //
//            //               // newClient.start();
//            //               BufferedReader buffReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
//            //            BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
//            //            System.out.println("Creating a new handler for this client...");
//            //            ServerThread newClient = new ServerThread(this.socket,this,ChatVBox, buffReader, buffWriter);
//            //
//            //                 // Create a new Thread with this object.
//            //        Thread t = new Thread(newClient);
//            //
//            //        System.out.println("Adding this client to active client list");
//            //
//            //        // add this client to active clients list
//            //       userThreads.add(newClient);
//            //
//            //        // start the thread.
//            //        t.start();
//
//            //                    if(userThreads.size() == 2){
//            //                        break;
//            //                    }
//                            }
//                          }       catch (IOException ex) {
//                                      Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
//                                  }
////                this.socket = serverSocket.accept();
////                this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
////                this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            
////             while(true) {
////                System.out.println("Waiting for clients...");
////                socket = serverSocket.accept();
////                System.out.println("Connected");
////                ClientHandler clientThread = new ClientHandler(socket, clients);
////                clients.add(clientThread);
////                clientThread.start();
////            }
//            
//                  }).start();
              }
        } catch(IOException ex){
            close(socket,bufferedReader,bufferedWriter);
        }
                          
    }
    
    public void close(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws IOException{
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        }
        catch(IOException ex){
            
        }
    }
    
    public static void broadcastMessage(String messageToClient, int groupId, int senderUserId, int receiverUserId, Date dateOfSending) throws IOException{
         for (ServerThread aUser : userThreads) {
//
             aUser.bufferedWriter.write(messageToClient);
            aUser.bufferedWriter.write("-" + groupId);
            aUser.bufferedWriter.write("-" + senderUserId);
            aUser.bufferedWriter.write("-" + receiverUserId);
            aUser.bufferedWriter.write("-" + dateOfSending.toString());
            aUser.bufferedWriter.newLine();
            aUser.bufferedWriter.flush();
            
        }
    }
  
    
    public Boolean isServerConnected(int port) throws IOException{
        Boolean flag = false;
        
        if(this.socket != null && this.socket.isConnected()){
            if(this.socket.getLocalPort() == port){
               flag = true;
            }
            else{
                //this.close(socket, bufferedReader, bufferedWriter);
            }
        }
        return flag;
    }
    
    public void closeServer() throws IOException{
        close(socket,bufferedReader, bufferedWriter);
    }
    
    public void sendMessageToClient(String messageToClient, int groupId, int senderUserId, int receiverUserId, Date dateOfSending) throws IOException{
        try{
            bufferedWriter.write(messageToClient);
            bufferedWriter.write("-" + groupId);
            bufferedWriter.write("-" + senderUserId);
            bufferedWriter.write("-" + receiverUserId);
            bufferedWriter.write("-" + dateOfSending.toString());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            
        }
        catch(IOException ex){
            close(socket,bufferedReader, bufferedWriter);
        }
    }
    
    public void receiveMessageFromClient(VBox vBox){
        new Thread(new Runnable(){
            @Override
            public void run() {
                if(socket != null){
                while(socket.isConnected()){
                    if(socket.getLocalPort() == 6999){
                    try {
                        if(bufferedReader != null && bufferedReader.readLine() != null){  
                            String messageFromClient = bufferedReader.readLine();
                            var stringArray = messageFromClient.split("-");                  
                            DashboardController.addNewTitledPane(stringArray[0],Integer.parseInt(stringArray[1]),Integer.parseInt(stringArray[2]),Integer.parseInt(stringArray[3]) ,new Date(stringArray[4]) , vBox);
                            if(messageFromClient.equalsIgnoreCase("bye")){
                                break;
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                        try {
                            close(socket,bufferedReader, bufferedWriter);
                        } catch (IOException ex1) {
                            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    }
                }
                
                try {
                    close(socket,bufferedReader, bufferedWriter);
                } catch (IOException ex) {
                    Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }).start();
    }

   


    
}
