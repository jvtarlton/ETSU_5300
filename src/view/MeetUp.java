/*
 * This package illustrates the ETSU-5300 MeetUp exercise 2 assignment UML
 * included with these java class files: 
     MeetUp Class Diagram.pdf
     MeetUp Sequence Diagram 1.pdf
     MeetUp Sequence Diagram 2.pdf
 */
package view;
import conroller.*;
import java.util.ArrayList;
import java.io.*;
/**
 * This class is a test case for instantiating the abstract User through
 * either Admin or Student class and aggregating their corresponding 
 * subclasses into collections.
 * 
 * @author Jim Tarlton
 */
public class MeetUp {

    
    // private members for application
    private static String SESSION[] = { "", ""};            // user login
    private static User active_user;                             // user session instance
    private static ArrayList<User> all_users;              // app data
    
    
    // user interface class
    public static void main(String[] args)   throws IOException {
        
        // user login process
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter username (HINT -- type \"Andy1000\" for Admin or \"Carl1002\" for Student): ");
        SESSION[0] = reader.readLine();
        System.out.println("Enter password (HINT: type \"password\"):");
        SESSION[1] = reader.readLine();
        control ctrl = new control();
        
        // condition for succesful login
        if(ctrl.login(SESSION)) {
            
            // populate application data
            active_user = ctrl.getActiveUser();
            all_users = ctrl.getAllUsers();
            ctrl.setControl(active_user, all_users);
            
            // render application
            ctrl.initializeUI(all_users);
            System.out.println(active_user.toString());
            
            // demo specific to Student user stories
            if(active_user instanceof Student) {
                ctrl.printFriends();
                ctrl.printSuggestions();
                System.out.println("\n\t\t\t\t\t .....adding new scheduled item.....");
                ctrl.buildSchedule("ART-4400", "SPRING 2018 F 05:00 PM", "Student Center");  // Carl adds schedule item
                System.out.println("\t\t\t\t\t .....creating a friend request.....");
                ((Student)active_user).addFriendRequest(1003, false);                         // Carl requests friendship of Dan
                System.out.println("\t\t\t\t\t.....accepting MeetUp suggestion.....\n");
                if(((Student)active_user).getSuggestions().size() > 0)
                    ((Student)active_user).getSuggestions().get(0).toggleSuggestion();  // student accepts suggestion
                System.out.println(active_user.toString());
            }
            if(active_user instanceof Student) {
                ctrl.printFriends();
                ctrl.printSuggestions();
            }
            
        // condition for failed login
        } else {
            System.out.println("Log in failed!");
        }
    }
    
    
}