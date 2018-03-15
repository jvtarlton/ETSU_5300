/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence_layer;
import java.util.ArrayList;
import presentation_layer.User;

/**
 * If 
 * @author Jim
 */
public final class Connection {
    
    private final ArrayList<User> all_users;
    private User current_user;
    
    // represents data object
    public Connection() {
        // request user data
        DBO data = new DBO();
        this.all_users = parseDataa(data.getData());
    }
    
    public boolean verify(String[] s) {
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
    
    
    // intended to accept JSON blob used to instantiate User objects 
    public ArrayList<User> parseDataa(ArrayList<User> data) {
        // initialize new User array
        // loop blob
        // add blob[i] to User array
        return data;
    }
    
    // returns session user data
    public ArrayList<User> getAllUsers() {
        return this.all_users;
    }
    
    
}
