/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapplication.helpers;

import com.mycompany.chatapplication.controllers.DashboardController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.VBox;

/**
 *
 * @author ntu-user
 */
public class ServerThread implements Runnable {
    public Socket socket;
    final BufferedReader bufferedReader;
    final  BufferedWriter bufferedWriter;

    public ChatServer server;
    public VBox ChatVBox;
 
    public ServerThread(Socket socket, VBox ChatVBox,String userNameListString, BufferedReader buffReader,  BufferedWriter buffWriter) throws IOException {
        this.socket = socket;
        this.ChatVBox = ChatVBox;
        this.bufferedReader = buffReader;
        this.bufferedWriter = buffWriter;
        System.out.println(userNameListString);
           buffWriter.write(userNameListString);
            buffWriter.newLine();
            buffWriter.flush();
        
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

    public void run() {   
          String messageFromClient="", serverMessage="";
          while(true){
              try {
                  if(this.bufferedReader != null){
                  messageFromClient = this.bufferedReader.readLine();
//                  if(messageFromClient.startsWith("The username")){
//                      ChatServer.userNames.add(messageFromClient.split(":")[1]);
//                  }else{
                   var stringArray = messageFromClient.split("-");
                   if(stringArray[0].equals("logout")){
                    this.socket.close();
                    break;
                    }
                    ChatServer.broadcastMessage(stringArray[0],Integer.parseInt(stringArray[1]),Integer.parseInt(stringArray[2]),Integer.parseInt(stringArray[3]) ,new Date(stringArray[4]));

                     DashboardController.addNewTitledPane(stringArray[0],Integer.parseInt(stringArray[1]),Integer.parseInt(stringArray[2]),Integer.parseInt(stringArray[3]) ,new Date(stringArray[4]) , ChatVBox);
              }
          //    }
          }catch (IOException ex) {
                  Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ParseException ex) {
                  Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          
          try{
                this.bufferedReader.close();
                this.bufferedWriter.close();
          } catch(IOException e){
              
          }
    }
          
 }
    
