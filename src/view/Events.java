
package view;
import model.Suggestion;
import model.Course;
import model.Friend;
import model.Admin;
import model.Student;
import model.User;
import controller.Connection;
import controller.Factory;

import java.util.ArrayList;
/**
* This class is intended for user interface functionality implementations
*/
public class Events {


    // private members
    private User active_user;
    private ArrayList<User> all_users;


    // Events accessors
    public User getActiveUser() { return active_user; }
    public ArrayList<User> getAllUsers() { return all_users; }

    
    // constructor
    public Events() {}
    
    
    // Events mutators
    public void setActiveUser(User active_user) {
        this.active_user = active_user;
    }
    public void setAllUsers(ArrayList<User> all_users) {
        this.all_users = all_users;
    }
    public void setControl (User active_user, ArrayList<User> all_users) {
        this.active_user = active_user;
        this.all_users = all_users;
    }

    
    // Student components
    // structure to render a schedule 
    public static class FriendScheduleItem {
        private static int 
                friend_id,
                schedule_id;
        private static String 
                friend_name,
                schedule_name,
                schedule_time,
                schedule_location;
    }
    
    
    // Student queries
   // gets details of friend's scheduled item
   public  void getScheduleDetails(int user_id, int location_id) {
       String location = "N/A";
       for(User user : all_users) {
           if(user.getID() == user_id) {
               FriendScheduleItem.friend_id = user.getID();
               FriendScheduleItem.friend_name = user.getName();
               for (Course item : ((Student)user).getSchedule()) {
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
    public  void printFriends() {
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
    
    
    // Student functionality
    // create new schedule item
    public  void buildSchedule(String name, String time, String location) {
       int id = ((Student)active_user).getSchedule().size() + 1;
       Course s = Factory.Course(id, name, time, location);
       ((Student)active_user).addSchedule(s);
    }
    
    
    // Student functionality
   // generate suggestions
   protected  ArrayList<Suggestion> buildSuggestions() {
       ArrayList<Suggestion> new_suggestions = new ArrayList<>();
       if(active_user instanceof Student) {
           if((((Student)active_user).getSchedule().size() > 0)) {
           ArrayList<Course> current_user_schedule = new ArrayList<>(((Student)active_user).getSchedule());
           int suggestion_id = 0;
           // loop trough students collection
           for (User us : all_users) {
               if(us.getID() != active_user.getID() && us instanceof Student) {
                   for (Course s : ((Student)us).getSchedule()) {
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
    public  void printSuggestions() {
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
   
   
    // Admin functionality
    // CRUD operations
    public void deleteUser(int user_id) {
        // in User list where ID = user_id
        // delete User
    }
    public void modifyUser(int user_id, User modification) {
        // in User list where ID = user_id
        // update with modification
    }


    // initalize UI
    public  void initializeUI(ArrayList<User> data) {
        data.forEach((d) -> {
            // manifest UI data
            if (d instanceof Admin) {
                // synchronize admin information here
                ((Admin)d).setUserCounts(data);
            } else if (d instanceof Student) {
                // synchronize student messages, schedules, etc. here
                ((Student)d).setSuggestions(buildSuggestions());
            }
        });
    }


    // User functionality
    public  boolean login(String[] sesh) {
        // make connection with persistence layer
         Connection request = new Connection();
        // encrypt password
        // String password = sesh[1];
        // password = encrypt(password);
        // login successful
        boolean flag = false;
        if(request.verify(sesh)) {
            flag = true;
            active_user = request.getCurrentUser();
            all_users = request.getAllUsers();
        }
        return flag;
    }


    // print all users
    public static void populateUI(ArrayList<User> data) {
       data.forEach((d) -> {
           System.out.println(d.toString());
       });
    }


}
