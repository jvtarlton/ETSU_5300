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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * This class is a test case for instantiating the abstract User through
 * either Admin or Student class and aggregating their corresponding 
 * subclasses into collections.
 * 
 * @author Jim Tarlton
 */
public class MeetUp {

    // prompt user for credentials
    private static String SESSION[] = { "", ""};            // user login
    private static User active_user;                             // user session instance
    private static ArrayList<User> all_users;              // app data
    
    // make connection with persistence layer
    public static Connection request = new Connection();
    
    // user interface class
    public static void main(String[] args)   throws IOException {
        //Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter username (HINT -- type \"Andy1000\" for Admin or \"Carl1002\" for Student): ");
        SESSION[0] = reader.readLine();
        System.out.println("Enter password (HINT: type \"password\"):");
        SESSION[1] = reader.readLine();
        if(login(SESSION)) {
            active_user = request.getCurrentUser();
            all_users = request.getAllUsers();
            initializeUI(all_users);
            System.out.println(active_user.toString());
            // demo specific to Student user
            if(active_user instanceof Student) {
                printFriends();
                printSuggestions();
                System.out.println("\n\t\t\t\t\t .....adding new scheduled item.....");
                buildSchedule("ART-4400", "SPRING 2018 F 05:00 PM", "Student Center");  // Carl adds schedule item
                System.out.println("\t\t\t\t\t .....creating a friend request.....");
                ((Student)active_user).addFriendRequest(1003, false);                         // Carl requests friendship of Dan
                System.out.println("\t\t\t\t\t.....accepting MeetUp suggestion.....\n");
                if(((Student)active_user).getSuggestions().size() > 0)
                    ((Student)active_user).getSuggestions().get(0).toggleSuggestion();  // student accepts suggestion
                System.out.println(active_user.toString());
            }
            if(active_user instanceof Student) {
                printFriends();
                printSuggestions();
            }
        } else {
            System.out.println("Log in failed!");
        }
    }
    
    // User functionality
    public static boolean login(String[] sesh) {
        // encrypt password
        // password = encrypt(password);
        return ((request.verify(sesh)));
    }
    
     // Student functionality
    // create new schedule item
    public static void buildSchedule(String name, String time, String location) {
        int id = ((Student)active_user).getSchedule().size() + 1;
        Schedule s = Factory.Schedule(id, name, time, location);
        ((Student)active_user).addSchedule(s);
    }
    
     // Student functionality
    // generate suggestions
    protected static ArrayList<Suggestion> buildSuggestions() {
        ArrayList<Suggestion> new_suggestions = new ArrayList<>();
        if(active_user instanceof Student) {
            if((((Student)active_user).getSchedule().size() > 0)) {
            ArrayList<Schedule> current_user_schedule = new ArrayList<>(((Student)active_user).getSchedule());
            int suggestion_id = 0;
            // loop trough students collection
            for (User us : all_users) {
                if(us.getID() != active_user.getID() && us instanceof Student) {
                    for (Schedule s : ((Student)us).getSchedule()) {
                        for(int i = 0; i < current_user_schedule.size(); i++) {
                            // find common schedules
                            if(s.getName().equals(current_user_schedule.get(i).getName()) &&
                                s.getTime().equals(current_user_schedule.get(i).getTime()) &&
                                s.getLocation().equals(current_user_schedule.get(i).getLocation())
                            ) {
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
                    // append to suggestions collection
                    if(suggestion_id > 0) {
                        ((Student)active_user).setSuggestions(new_suggestions);
                    }
                }
             }
          }
        } 
        return new_suggestions;
    }
    
    
     // Student functionality
    // render and output suggestions
        protected static void printSuggestions() {
        System.out.println("\n\nSuggestions are as follows: ");
        if(((Student)active_user).getSuggestions().size() > 0) {
            for (Suggestion item : ((Student)active_user).getSuggestions()) {
                getScheduleDetails(item.getFriendID(),item.getFriendScheduleID());
                int friend_status = getFriendStatus(all_users, active_user, FriendScheduleItem.friend_id);
                System.out.println(
                        "\t" + item.getID() + " -- " +
                        (friend_status == 1 ? "mutual friend " : (friend_status == 2 ? "blocked-friend " : "non-friend ")) +
                        FriendScheduleItem.friend_name + " with ID " + 
                        FriendScheduleItem.friend_id + " has " + 
                        FriendScheduleItem.schedule_name + " at " + 
                        FriendScheduleItem.schedule_location + "." + 
                        "\tYou have " + (item.getAccepted() ? "" :  "NOT ") + "accepted the suggestion."
                );
            }
        } else {
            System.out.println("\t1 -- You currently have no similarly scheduled items to suggest.");
        }
        System.out.println( "--------------------------------" 
                + "----------------------------------------------"
                + "----------------------------------------------");
        
    }
    
    
    public static class FriendScheduleItem {
        public static int 
                friend_id,
                schedule_id;
        public static String 
                friend_name,
                schedule_name,
                schedule_time,
                schedule_location;
    }
    
     // Student queries
    // gets details of friend's scheduled item
    public static void getScheduleDetails(int user_id, int location_id) {
        String location = "N/A";
        for(User user : all_users) {
            if(user.getID() == user_id) {
                FriendScheduleItem.friend_id = user.getID();
                FriendScheduleItem.friend_name = user.getName();
                for (Schedule item : ((Student)user).getSchedule()) {
                    if(item.getID() == location_id) {
                        FriendScheduleItem.schedule_id = item.getID();
                        FriendScheduleItem.schedule_name = item.getName();
                        FriendScheduleItem.schedule_time = item.getTime();
                        FriendScheduleItem.schedule_location = item.getLocation();
                    }
                }
            }
        }
    }
    
    // Student queries
    // gets name of a students friend
    public static void printFriends() {
        System.out.print("\nFriends list is as follows:");
        if(((Student)active_user).getFriends().size() > 0) {
            for (Friend friend : ((Student)active_user).getFriends()) {
                for(User other_user : all_users) {
                    if(friend.getID() == other_user.getID()) {
                        System.out.print("\n\t" + other_user.getID());
                        System.out.print(" -- " + other_user.getName() + " is a(n) " +
                                (!friend.getBlockStatus() ? "active friend" : "blocked friend") 
                        );
                    }
                } 
            }
        } else {
            System.out.println("\t1 -- You currently have no friends to display");
        }
    }
    
    // Student queries
    // finds if two students are friends; and if so, that friend is not blocked
    public static int getFriendStatus(ArrayList<User> all_users, User active_user, int lookup_user_id ) {
        int is_friend = 0;
        for (Friend friend : ((Student)active_user).getFriends()) {
            if(friend.getID() == lookup_user_id) {
                if(friend.getBlockStatus() == false) {
                    is_friend = 1;
                } else {
                    is_friend = 2;
                }
            }
        }
        return is_friend;
    }
    
    
    // initalize UI
    public static void initializeUI(ArrayList<User> data) {
        data.forEach((d) -> {
            // manifest UI data
            if (d instanceof Admin) {
                // synchronize admin information here
                ((Admin)d).setStudentCount(data);
            } else if (d instanceof Student) {
                // synchronize student messages, schedules, etc. here
                ((Student)d).setSuggestions(buildSuggestions());
            }
        });
    }


    // print all users
    public static void populateUI(ArrayList<User> data) {
        data.forEach((d) -> {
            System.out.println(d.toString());
        });
    }
    
    
    
    
}


