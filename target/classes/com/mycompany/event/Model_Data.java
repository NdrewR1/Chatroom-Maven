/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.event;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author User
 */
public class Model_Data {
    String username;
    String pass;
    String confPass;

    public Model_Data() {
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public String getUsername() {
        return username;
    }

    public Model_Data(String username, String pass) {
        this.username = username;
        this.pass = pass;

    }
    
    public JSONObject toJSONObject(){
        try {
            JSONObject json = new JSONObject();
            json.put("username", username);
            json.put("pass", pass);
            return json;
            
        } catch (JSONException e) {
            return null;
        }
    }
}
