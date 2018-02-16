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
    private static User active_user;                                                           // user session instance
    private static ArrayList<User> all_users;                                           // app data
    
    // make connection with persistence layer
    public static Connection request = new Connection();
    
    // user interface class
    public static void main(String[] args) {
        if(login(SESSION)) {
            active_user = request.getCurrentUser();
            all_users = request.getAllUsers();
            initializeUI(all_users);
            System.out.println(active_user.toString());
            printSuggestions();
            System.out.println(".....adding new schedule item.....");
            buildSchedule("ART-4400", "SPRING 2018 F 05:00 PM", "Student Center");                    // student adds schedule item
            System.out.println(".....accepting a meet up suggestion.....");
            ((Student)active_user).getSuggestions().get(0).toggleSuggestion();  // student accepts suggestion
            System.out.println(active_user.toString());
            printSuggestions();
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
    // create new schedule item
    public static void buildSchedule(String name, String time, String location) {
        int id = ((Student)active_user).getSchedule().size() + 1;
        Schedule s = Schedule.make(id, name, time, location);
        ((Student)active_user).addSchedule(s);
    }
    
     // Student functionality
    // generate suggestions
    protected static ArrayList<Suggestion> buildSuggestions() {
        ArrayList<Schedule> current_user_schedule = new ArrayList<>(((Student)active_user).getSchedule());
        ArrayList<Suggestion> new_suggestions = new ArrayList<>();
        int suggestion_id = 0;
        // loop trough students collection
        for (User us : all_users) {
            if(us.getID() != active_user.getID() && us.getClass().getSimpleName().equals("Student")) {
                for (Schedule s : ((Student)us).getSchedule()) {
                    for(int i = 0; i < current_user_schedule.size(); i++) {
                        // find common schedules
                        if(s.getLocation().equals(current_user_schedule.get(i).getLocation())) {
                            suggestion_id++;
                            new_suggestions.add(
                                    new Suggestion(
                                        suggestion_id,
                                        us.getID(),
                                        s.getID(),
                                        false
                                )
                            );
                        }
                    }
                }
            }
        }
        // append to suggestions collection
        ((Student)active_user).setSuggestions(new_suggestions);
        return new ArrayList<>();
    }
    
    
     // Student functionality
    // render and output suggestions
    protected static void printSuggestions() {
        System.out.println("Suggestions are as follows: ");
        for (Suggestion item : ((Student)active_user).getSuggestions()) {
            System.out.println(
                    "\t" + item.getID() + " -- " +
                    getStudentName(item.getFriendID()) + " has similarly scheduled item at " + 
                    getScheduleLocation(item.getFriendID(),item.getFriendScheduleID()) +
                    ". You have " + (item.getAccepted() ? "" :  "NOT ") + "accepted the suggestion."
            );
        }
    }
    
    
     // Student queries
    // gets location of friend's scheduled item
    public static String getScheduleLocation(int user_id, int location_id) {
        String location = "N/A";
        for(User user : all_users) {
            if(user.getID() == user_id) {
                for (Schedule item : ((Student)user).getSchedule()) {
                    if(item.getID() == location_id) {
                        location = item.getLocation();
                    }
                }
            }
        }
        return location;
    }
    
    // Student queries
    // gets name of friend
    public static String getStudentName(int id) {
        String name = "N/A";
        for (User user : all_users) {
            if(user.getID() == id) {
                name = user.getName();
            }
        }
        return name;
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
                ((Student)d).setSuggestions(buildSuggestions());
            }
        });
        return data;
    }
    
    
    // print all users
    public static void populateUI(ArrayList<User> data) {
        data.forEach((d) -> {
            System.out.println(d.toString());
        });
    }
    
    
    
    
}


