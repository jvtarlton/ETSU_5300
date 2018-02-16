/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence_layer;
import java.util.ArrayList;
import presentation_layer.User;

/**
 * 
 * @author Jim
 */
public class Connection {
    
    private ArrayList<User> all_users;
    private User current_user;
    
    // represents instance of data object
    public Connection() {
        // request user data
        DBO data = new DBO();
        this.all_users = data.getData();
    }
    
    public boolean authenticate(String[] s) {
        // decrypt password
        // password = decrypt(password);
        boolean flag = false;
        for (User u : this.all_users) {
            if(s[0].equals(u.getUsername()) && s[1].equals(u.getPassword())) {
                flag = true;
                this.current_user = u;
            }
        }
        return flag;
    }
    
    
    // returns session user data
    public User getCurrentUser() {
        return this.current_user;
    }
    
    
    // returns session user data
    public ArrayList<User> getAllUsers() {
        return this.all_users;
    }
    
    
}
