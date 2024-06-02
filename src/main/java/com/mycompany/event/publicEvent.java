/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.event;

/**
 *
 * @author User
 */
public class publicEvent {
    private static publicEvent instance;
    private EventLogin eLog;
    private EventChat eChat; 

    private publicEvent() {
    
    }

    public static publicEvent getInstance() {
        if(instance == null){
            instance = new publicEvent();
        }
        
        return instance;
    }

    public EventLogin getELog() {
        return eLog;
    }

    public void addELog(EventLogin eLog) {
        this.eLog = eLog;
    }
    
    
    
    
    
    
}
