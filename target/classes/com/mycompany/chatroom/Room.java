package com.mycompany.chatroom;
import java.util.ArrayList;
import java.util.Random;

class Room implements Runnable{

    private String roomCode;
    private String roomName;
    private int numberOfJoinedPeople;
    private ArrayList<Client> listOfPeople;
    private boolean[] activeStatus;

    

    public Room(String roomName){
        this.roomName = roomName;
        Random r = new Random();
        roomCode = "#"+Integer.toHexString(r.nextInt(256*16));
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
    
    public void broadcast(String message){
        for(Client cl : listOfPeople){
            cl.sendMessage(message);
        }
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void add(Client client){
        this.listOfPeople.add(client);
    }

    public void left(Client client){
        // int idx = this.listOfPeople.indexOf(name)
    }
    
}