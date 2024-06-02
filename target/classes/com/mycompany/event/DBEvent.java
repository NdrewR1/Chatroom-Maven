/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.event;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class DBEvent {
    public static DBEvent instance;
    private Connection conn;
    private String user;
    private String pass;
    
    private DBEvent(){
//        this.conn = DataBaseConnection.getInstance().getConnection();
    }
    
    public static DBEvent getInstance(){
        if(instance==null){
            instance= new DBEvent();
        }
        return instance;
    }
    
    public boolean register(Model_Data data){
        user = data.getUsername();
        pass = data.getPass();
        
        String sql;
        Statement stmt;
        
        try {
            stmt = conn.createStatement();
            sql = String.format("INSERT INTO UserList(username,pass,confPass) VALUES ('%s','%s','%s')",this.user,this.pass,this.pass);
        
            stmt.execute(sql);
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(Model_Data data){
        user = data.getUsername();
        pass = data.getPass();
        
        String sql;
        Statement stmt;
        ResultSet rs;
        
        try {
            stmt = conn.createStatement();
            sql = String.format("SELECT username, pass FROM UserList WHERE username LIKE '%s'",user);


            rs = stmt.executeQuery(sql);
            rs.next();
            String checkUser = rs.getString(1);
            String checkPass = rs.getString(2);
            System.out.println(checkUser);
            System.out.println(checkPass);

            if(user.equals(checkUser)&& pass.equals(checkPass)){
//                System.out.println("User Found");
                return true;
            }else{
//                System.out.println("User Not Found");
                return false;
            }
            

            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
