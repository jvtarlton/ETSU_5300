/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence_layer;

import java.util.ArrayList;
import java.util.Arrays;
import presentation_layer.Friend;
import presentation_layer.Schedule;
import presentation_layer.User;

/**
 * User data literals
 * Template array for UI, accepts Admin and Students
 * @author Jim
 */
public class Connection {
    
    private ArrayList<User> users;
    private User current_user;
    
    public boolean authenticate(String[] s) {
        // decrypt password
        // password = decrypt(password);
        boolean flag = false;
        for (User u : this.users) {
            if(s[0].equals(u.getUsername()) && s[1].equals(u.getPassword())) {
                flag = true;
                this.current_user = u;
            }
        }
        return flag;
    }
    
    public Connection() {
        // connect to REST API
        // request user data
        // parse into User objects
        this.users = new ArrayList<>(

            Arrays.asList(

                // User type Admin
                User.make(1000, "Andy"),

                // User type Student
                    
                User.make(
                    1001, "Bob", false, false, 
                    Arrays.asList(
                        Friend.make(1002, false),
                        Friend.make(1003, false),
                        Friend.make(1004, false)
                    ),
                    Arrays.asList(
                        Schedule.make(1, "CSCI-1100", "2/2/18 10:00 AM", "Gilbreath Hall"),
                        Schedule.make(2, "CSCI-1200", "2/3/18 11:15 AM", "Nicks Hall")
                    )
                ),

                // User type Student
                User.make(
                    1002, "Carl", true, false,
                    Arrays.asList(
                        Friend.make(1001, false),
                        Friend.make(1003, true)
                    ),
                    Arrays.asList(
                        Schedule.make(1, "CSCI-1100", "2/2/18 10:00 AM", "Gilbreath Hall"),
                        Schedule.make(2, "CSCI-1300", "2/3/18 12:00 PM", "Nicks Hall")
                    )
                ),

                // User type Student
                User.make(
                    1003, "Dan", true, true,
                    Arrays.asList(
                        Friend.make(1001, false)
                    ),
                    Arrays.asList(
                        Schedule.make(1, "ENG-4400", "2/3/18", "Sherrod Library")
                    )
                ),

                // User type Student
                User.make(
                    1004, "Eric", true, true,
                    Arrays.asList(
                        Friend.make(1002, false),
                        Friend.make(1003, false)
                    ),
                    Arrays.asList(
                        Schedule.make(1, "ENG-4400", "2/3/18", "Sherrod Library")
                    )
                )
            )
        );
        
    }
    
    public ArrayList<User> getData() {
        return this.users;
    }
    
    public User getCurrentUser() {
        return this.current_user;
    }
}
