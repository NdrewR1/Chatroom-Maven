/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;
import io.netty.util.NetUtil;
import io.socket.client.IO;
import io.socket.client.Socket;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author User
 */
public class Service {
    private static Service instance;
    private Socket client;
    private static final int PORT_NUMBER = 5556;
    private final String ip = "127.0.0.1";
    private JTextArea txtArea;
    
    public static Service getInstance() {
        if(instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {
    
    }
     
    public void startServer(){
        try {
            client  = IO.socket("http://"+ip+":"+PORT_NUMBER);
            client.open();
            
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }

    public Socket getClient() {
        return client;
    }
    
    
}
