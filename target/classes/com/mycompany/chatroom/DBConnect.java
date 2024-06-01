package com.mycompany.chatroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.*;
import java.util.Scanner;


public class DBConnect implements Runnable {
    
    private String user;
    private String pass;
    private Connection conn = null;
    
    
    public DBConnect(String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try{
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            String dbURL = "jdbc:sqlserver://Acer\\SQLEXPRESS;encrypt=true;trustServerCertificate=true;databaseName=ChatRoom;IntegratedSecurity=true";
            String username = "sa";
            String password = "pass";
            
            //Connect ke sqlserver dengan menggunakan driver manager
            conn = DriverManager.getConnection(dbURL, username, password);
             
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } 
                 
    }

    public boolean register(){
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

    public boolean login(){
        String sql;
        Statement stmt;
        ResultSet rs;
        
        try {
            stmt =  conn.createStatement();
            sql = String.format("SELECT username, pass FROM UserList WHERE username LIKE '%s'",user);


            rs = stmt.executeQuery(sql);
            rs.next();
            String checkUser = rs.getString(1);
            String checkPass = rs.getString(2);
            System.out.println(checkUser);
            System.out.println(checkPass);

            if(user.equals(checkUser)&& pass.equals(checkPass)){
                System.out.println("User Found");
                return true;
            }else{
                System.out.println("User Not Found");
                return false;
            }
            

            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
