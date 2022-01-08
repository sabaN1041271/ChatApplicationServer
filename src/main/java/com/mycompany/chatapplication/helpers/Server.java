/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapplication.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.chatapplication.controllers.DashboardController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.VBox;

/**
 *
 * @author ntu-user
 */
public class Server {
    
    private static ServerSocket server = null;
    private static Socket ss = null;
    /**
           * Client Collection
     */
    private static Map<String, ServerThread> serverThreadMap = new HashMap<String, ServerThread>();


    
    public Server(VBox vBox){
        try {
            //Establish a server
            server = new ServerSocket(1234);
            System.out.println("Server is started!");
            while (true) {
                //Create a receiving interface
                ss = server.accept();
                //Start a new customer listening thread
                new ServerThread(server, ss,vBox).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
     private static class ServerThread extends Thread {
        ServerSocket server = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        String clientName = null;
        boolean alive = true;
        VBox vBox;

        public ServerThread() {
        }

        ServerThread(ServerSocket server, Socket socket, VBox vBox) {
            this.socket = socket;
            this.server = server;
            this.vBox = vBox;
        }

        @Override
        public void run() {
            //Receive data
            try {
                is = socket.getInputStream();
                //send
                os = socket.getOutputStream();
                 this.bufferedReader = new BufferedReader(new InputStreamReader(is));
                     this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
            
                byte[] b = new byte[1024];
                int length = 0;
                     while(alive){
                     length = is.read(b);
                    if (length != -1) {
                        //Text message
                        String messageText = new String(b, 0, length);
                         
                         if(!messageText.isBlank() || !messageText.isEmpty()){
                               var stringArray = messageText.split("-");
                               if(stringArray[5] == "Group"){
                                   for (ServerThread st : serverThreadMap.values()) {
                                    //Send data to other clients
                                    if (st != this) {
                                        
                                        st.os.write(new String(b, 0, length).getBytes());
                                        bufferedWriter.write(messageText);
                                    }
                                }

                               }
                               else{
                                    String to = stringArray[6];
                                   serverThreadMap.get(to).bufferedWriter.write(messageText);
                               }
                              DashboardController.addNewTitledPane(stringArray[0],Integer.parseInt(stringArray[1]),Integer.parseInt(stringArray[2]),Integer.parseInt(stringArray[3]) ,new Date(stringArray[4]) , vBox);                 
               
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Contact" + clientName + "connection, forced to turn off the monitoring thread!");
            } catch (ParseException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    serverThreadMap.remove(clientName);
                    System.out.println("Current client quantity:" + serverThreadMap.size());
                    os.close();
                    is.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
}

    }


