/////*
//// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//// */
////package com.mycompany.chatapplication.helpers;
////
////import com.mycompany.chatapplication.controllers.DashboardController;
////import java.io.BufferedReader;
////import java.io.BufferedWriter;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.io.OutputStreamWriter;
////import java.net.ServerSocket;
////import java.net.Socket;
////import java.text.ParseException;
////import java.util.Date;
////import java.util.HashSet;
////import java.util.Set;
////import java.util.Vector;
////import java.util.logging.Level;
////import java.util.logging.Logger;
////import javafx.scene.layout.VBox;
////
/////**
//// *
//// * @author ntu-user
//// */
////public class SimpleServer {
////     private ServerSocket serverSocket;
////    private Socket socket;
////    public BufferedReader bufferedReader;
////    public BufferedWriter bufferedWriter;
////    private ServerThread serverThread;
////   private Set<String> userNames = new HashSet<>();
////
////  static Vector<ServerThread> userThreads = new Vector<>();
////public SimpleServer(ServerSocket serverSocket, VBox ChatVBox) throws IOException{           
////        try{
////            this.serverSocket = serverSocket;
////            System.out.println("Server is listening on port " + serverSocket.getLocalPort() + " " + serverSocket.getInetAddress());
////
////
//////              if(serverSocket.getLocalPort() == 6999){
//////                  this.socket = serverSocket.accept();
//////                  System.out.println("Server is listening to address " + this.socket.getInetAddress() + " "  + this.socket.getPort());
//////                    //this.socket.setReuseAddress(true);
//////                    this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//////                    this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//////              }
//////              else{
////              while(true) {
////                System.out.println("Waiting for clients...");
////                socket = serverSocket.accept();
////                System.out.println("Connected");
////                
////                BufferedReader buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
////                BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
////                System.out.println("Creating a new handler for this client...");
////           //     ServerThread newClient = new ServerThread(socket,this,ChatVBox, buffReader, buffWriter);
////                    
////                     // Create a new Thread with this object.
////            Thread t = new Thread(newClient);
////             
////            System.out.println("Adding this client to active client list");
//// 
////            // add this client to active clients list
////           userThreads.add(newClient);
//// 
////            // start the thread.
////            t.start();
////
////                    if(userThreads.size() == 2){
////                        break;
////                    }
////                }
////             // }
////        }
////        catch(IOException e){
////            close(socket,bufferedReader, bufferedWriter);
////        }
////    }
////
//////public void sendMessageToClient(String messageToClient, int groupId, int senderUserId, int receiverUserId, Date dateOfSending) throws IOException{
//////        try{
//////            bufferedWriter.write(messageToClient);
//////            bufferedWriter.write("-" + groupId);
//////            bufferedWriter.write("-" + senderUserId);
//////            bufferedWriter.write("-" + receiverUserId);
//////            bufferedWriter.write("-" + dateOfSending.toString());
//////            bufferedWriter.newLine();
//////            bufferedWriter.flush();
//////            
//////        }
//////        catch(IOException ex){
//////            close(socket,bufferedReader, bufferedWriter);
//////        }
////////         for (ServerThread aUser : userThreads) {
////////
////////                aUser.sendMessageToClient(messageToClient, groupId, senderUserId, receiverUserId, dateOfSending);
////////            
////////        }
//////    }
////
//// public void close(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws IOException{
////        try{
////            if(bufferedReader != null){
////                bufferedReader.close();
////            }
////            if(bufferedWriter != null){
////                bufferedWriter.close();
////            }
////            if(socket != null){
////                socket.close();
////            }
////        }
////        catch(IOException ex){
////            
////        }
////    }
////    
//////    public void receiveMessageFromClient(VBox vBox){
//////        new Thread(new Runnable(){
//////            @Override
//////            public void run() {
//////                while(socket.isConnected()){
//////                    if(socket.getLocalPort() == 6999){
//////                    try {
//////                        String messageFromClient = bufferedReader.readLine();
//////                        var stringArray = messageFromClient.split("-");                  
//////                        DashboardController.addNewTitledPane(stringArray[0],Integer.parseInt(stringArray[1]),Integer.parseInt(stringArray[2]),Integer.parseInt(stringArray[3]) ,new Date(stringArray[4]) , vBox);
//////                        if(messageFromClient.equalsIgnoreCase("bye")){
//////                            break;
//////                        }
//////                    } catch (IOException ex) {
//////                        Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
//////                        try {
//////                            close(socket,bufferedReader, bufferedWriter);
//////                        } catch (IOException ex1) {
//////                            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex1);
//////                        }
//////                    } catch (ParseException ex) {
//////                        Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
//////                    }
////////                for (ServerThread aUser : userThreads) {
////////
////////                                aUser.receiveMessageFromClient(vBox);
////////
////////                        }
//////                    }
//////                    else{
//////                        for (ServerThread aUser : userThreads) {
//////                                String messageFromClient;
//////                            try {
//////                                messageFromClient = aUser.bufferedReader.readLine();
//////                                var stringArray = messageFromClient.split("-");
//////                                DashboardController.addNewTitledPane(stringArray[0],Integer.parseInt(stringArray[1]),Integer.parseInt(stringArray[2]),Integer.parseInt(stringArray[3]) ,new Date(stringArray[4]) , vBox);
//////                  
//////                            } catch (IOException ex) {
//////                                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
//////                            } catch (ParseException ex) {
//////                                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
//////                            }
//////                               
//////
//////                        }
//////                    }
//////                }
//////                
//////                try {
//////                    close(socket,bufferedReader, bufferedWriter);
//////                } catch (IOException ex) {
//////                    Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
//////                }
//////            }
//////            
//////        }).start();
//////    }
////}
