/*
 * This package illustrates the ETSU-5300 MeetUp exercise 2 assignment UML
 * included with these java class files: 
     MeetUp Class Diagram.pdf
     MeetUp Sequence Diagram 1.pdf
     MeetUp Sequence Diagram 2.pdf
 */
package meetup;
import persistence_layer.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
/**
 * This class is a test case for instantiating the abstract User through
 * either Admin or Student class and aggregating their corresponding 
 * subclasses into collections.
 * 
 * @author Jim Tarlton
 */
public class MeetUp {
    
    // make connection with persistence layer
    public static Connection con = new Connection();
    
    public static void main(String[] args) {
            
        // prompt user for credentials
          String session[] = { "Carl1002", "password" };
          User user;
          ArrayList<User> users;

        if(login(session)) {
            user = con.getCurrentUser();
            users = con.getData();
            initializeUI(users);
            System.out.println(user.toString());
            System.out.println(".....adding new schedule item.....");
            Schedule s = new Schedule(3, "ENG-4400", "2/3/18", "Sherrod Library");
            
            // error here ??
            ((Student)user).addSchedule(s);
            
            System.out.println(user.toString());
            
        } else {
            System.out.println("Log in failed!");
        }
        
    }
    
    public static boolean login(String[] sesh) {
        // encrypt password
        // password = encrypt(password);
        return ((con.authenticate(sesh)));
    }
    
    // initalize UI
    public static ArrayList<User> initializeUI(ArrayList<User> data) {
        data.forEach((d) -> {
            // manifest UI data
            if (d.getClass().getSimpleName().equals("Admin")) {
                // synchronize admin information here
                ((Admin)d).setStudentCount(data);
            } else {
                // synchronize student messages, schedules, etc. here
                ((Student)d).findScheduleMatches();
            }
        });
        return data;
    }
    
    // populate UI
    public static void populateUI(ArrayList<User> data) {
        // print UI
        data.forEach((d) -> {
            System.out.println(d.toString());
        });
    }
    
}


