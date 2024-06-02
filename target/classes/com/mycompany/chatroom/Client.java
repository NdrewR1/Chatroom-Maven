package com.mycompany.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private boolean done;
    
    @Override
    public void run() {
        try {
            client = new Socket("127.0.0.1",5555);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            InputHandler inHandler = new InputHandler();
            Thread t = new Thread(inHandler);
            t.start();

            String inMessage;
            int idx;

   
            while((inMessage=in.readLine())!=null){
                System.out.println(inMessage);
            }

           

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void shutdown(){
        done = true;
        try {
          
            in.close();
            out.close();
            if(!client.isClosed()){
                client.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public PrintWriter getOut() {
        return out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void sendMessage(String message){
        out.println(message);
    }

    class InputHandler implements Runnable{

        @Override
        public void run() {
            try {
                BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));    
                int idx;
        
                while(!done){
                    String message = inReader.readLine();
                    out.println(message);
                }
                // out.print("Enter new message: ");
            

                
                
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        
        }
        
    }

//    public static void main(String[] args) {
//        Client client = new Client();
//        client.run();
//    }
}
