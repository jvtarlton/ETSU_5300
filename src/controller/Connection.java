
package controller;
import java.util.ArrayList;
import static controller.DBO.getDBO;
import model.User;

/**
 * This is a facade for server connectivity
 */
public final class Connection {
    
    
    // private members
    private User current_user;
    private final ArrayList<User> all_users;
    
    
    // prompt user for credentials
    public static class SESSION {
        static String username;
        static String password;
    }
    
    
    // represents data object
    public Connection() {
        // request user data singleton
        DBO data = getDBO();
        this.all_users = parseData(data.getData());
    }
    
    
    public  boolean verify(String[] s) {
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
    public ArrayList<User> parseData(ArrayList<User> data) {
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
