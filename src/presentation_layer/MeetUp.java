/*
 * This package illustrates the ETSU-5300 MeetUp exercise 2 assignment UML
 * included with these java class files: 
     MeetUp Class Diagram.pdf
     MeetUp Sequence Diagram 1.pdf
     MeetUp Sequence Diagram 2.pdf
 */
package presentation_layer;
import persistence_layer.*;
import java.util.ArrayList;
/**
 * This class is a test case for instantiating the abstract User through
 * either Admin or Student class and aggregating their corresponding 
 * subclasses into collections.
 * 
 * @author Jim Tarlton
 */
public class MeetUp {

    // prompt user for credentials
    private static final String SESSION[] = { "Carl1002", "password" };   // user login
    private static User user;                                                           // user session instance
    private static ArrayList<User> users;                                      // community data
    
    // make connection with persistence layer
    public static Connection request = new Connection();
    
    // user interface class
    public static void main(String[] args) {

        if(login(SESSION)) {
            user = request.getCurrentUser();
            users = request.getAllUsers();
            initializeUI(users);
            System.out.println(user.toString());
            System.out.println(".....adding new schedule item.....");
            makeSchedule("ENG-4400", "2/3/18", "Sherrod Library");      // student adds new schedule item
            System.out.println(user.toString());
        } else {
            System.out.println("Log in failed!");
        }
        
    }
    
    // User functionality
    public static boolean login(String[] sesh) {
        // encrypt password
        // password = encrypt(password);
        return ((request.authenticate(sesh)));
    }
    
     // Student functionality
    // make new schedule item
    public static void makeSchedule(String name, String time, String location) {
        int id = ((Student)user).getSchedule().size() + 1;
        Schedule s = Schedule.make(id, name, time, location);
        ((Student)user).addSchedule(s);
    }
    
    
    
    
    protected static ArrayList<Suggestion> findScheduleMatches() {
        ArrayList<Suggestion> new_suggestions = new ArrayList<>();
        // loop trough anonymous students collection
        for (User u : users) {
            if(u.getID() != user.getID() && u.getClass().getSimpleName().equals("Student")) {
                
                for (Schedule s : ((Student)u).getSchedule()) {
                    
                }
            }
        }
        // find common schedules
        // append to suggestions collection
        return new ArrayList<>();
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
                ((Student)d).setSuggestions(findScheduleMatches());
            }
        });
        return data;
    }
    
    
    
    
    
    // print all users
    public static void populateUI(ArrayList<User> data) {
        // print UI
        data.forEach((d) -> {
            System.out.println(d.toString());
        });
    }
    
    
    
    
}


