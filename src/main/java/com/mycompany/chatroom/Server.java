package com.mycompany.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    private ServerSocket server;
    private ArrayList<ConnectionHandler> conns;
    private ArrayList<Room> roomList;
    private ExecutorService pool;
    private boolean done;

    public Server() {
        this.conns = new ArrayList<>();
        this.done = false;
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(5555);
            pool = Executors.newCachedThreadPool();
            System.out.println("Server is Connected!");
            
            while(!done){
                Socket client = server.accept();

                ConnectionHandler handler = new ConnectionHandler(client);
                
                conns.add(handler); 
                pool.execute(handler);
                
            }
            
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public void broadcast(String message){
        for(ConnectionHandler handler : conns){
            if(handler!=null) handler.sendMessage(message);
        }
    }

    public void shutdown(){
        done = true;
        try {
            for(ConnectionHandler handler : conns){
                handler.shutdown();
            }
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class ConnectionHandler implements Runnable{

        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        private String nickname; 
        private String pass;
        private String message;   

        private boolean connected;       

        public ConnectionHandler(Socket client){
            this.client = client;
        }

        @Override
        public void run() {
            try {
                String idx;
                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                out.println("\n1.Register\n2.Login");idx= in.readLine();
                if(idx.equals("1")){
                    
                    out.println("Registration has been selected");

                    out.println("Input nickname: ");
                    nickname = in.readLine();
                    out.println("Input password: ");
                    pass = in.readLine();

                    DBConnect dbcon = new DBConnect(nickname,pass);
                    dbcon.run();

                    if(dbcon.register()) out.println("User has been registered");
                    else out.println("Registration Failed");
                    // if(register()) out.println("Registration has been done successfully");
                    
                }else if(idx.equals("2")) {
                    out.println("Login has been selected");

                    out.println("Input nickname: ");
                    nickname = in.readLine();
                    out.println("Input password: ");
                    pass = in.readLine();

                    DBConnect dbcon = new DBConnect(nickname,pass);
                    dbcon.run();

                    //Isu
                    if(dbcon.login()) out.println("Login Successed");
                    else out.println("Login Failed");
                    
                }else {
                    out.println("Option not Available...");
                    
                }

                while (!done) {
                    
                }
            
            } catch (IOException e) {
                
                e.printStackTrace();
                shutdown();
            }
        }

        public void sendMessage(String message){
            out.println(message);
        }

        public void shutdown(){
            try {
                out.println(this.nickname+ " left the chat!");
                out.close();
                in.close();
                if(!client.isClosed()){
                    client.close();
                }
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        
        public boolean register(){
            out.println("tes");
            try {
                out.println("Input nickname: ");
                nickname = in.readLine();
                out.println("Input password: ");
                pass = in.readLine();
                DBConnect dbcon = new DBConnect(nickname,pass);
                
                
                dbcon.register();

                return true;
                
                
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }

            //Buat register
        }

    }
    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

}
