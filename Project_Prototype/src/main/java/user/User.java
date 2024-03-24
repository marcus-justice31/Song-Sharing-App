/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author marcusuy
 */
public class User {
    private String username;
    
    public User(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setuserName(String username){
        this.username = username;
    }
}
