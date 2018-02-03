/*
 * This package illustrates the ETSU-5300 MeetUp exercise 1 assignment UML
 * included with these java class files: 
     MeetUp Class Diagram.pdf
     MeetUp Sequence Diagram 1.pdf
     MeetUp Sequence Diagram 2.pdf
 */
package meetup;
import java.util.*;
/**
 * This class is a test case for instantiating the abstract User through
 * either Admin or Student class and aggregating their corresponding 
 * subclasses into collections.
 * 
 * @author Jim Tarlton
 */
public class MeetUp {
    
    public static void main(String[] args) {
        
        // student 1 Friend collection
        ArrayList<Friend> bobs_friends = new ArrayList<>();
        Friend friend_of_bob_1 = new Friend(1002, false);
        Friend friend_of_bob_2 = new Friend(1003, true);
        Friend friend_of_bob_3 = new Friend(1004, false);
        bobs_friends.add(friend_of_bob_1);
        bobs_friends.add(friend_of_bob_2);
        bobs_friends.add(friend_of_bob_3);
        
        // student 2 Friend collection
        ArrayList<Friend> carls_friends = new ArrayList<>();
        Friend friend_of_carl_1 = new Friend(1001, false);
        Friend friend_of_carl_2 = new Friend(1003, false);
        carls_friends.add(friend_of_carl_1);
        carls_friends.add(friend_of_carl_2);
        
        // student 3 Friend collection
        ArrayList<Friend> dans_friends = new ArrayList<>();
        Friend friend_of_dan_1 = new Friend(1001, false);
        Friend friend_of_dan_2 = new Friend(1002, true);
        dans_friends.add(friend_of_dan_1);
        dans_friends.add(friend_of_dan_2);
        
        // student 1 Schedule collection
        ArrayList<Schedule> bobs_schedule = new ArrayList<>();
        Schedule schedule_of_bob_1 = new Schedule(1, "Study group", "2/2/18", "Sherrod Library");
        Schedule schedule_of_bob_2 = new Schedule(2, "Yoga practice", "2/3/18", "BCPA");
        bobs_schedule.add(schedule_of_bob_1);
        bobs_schedule.add(schedule_of_bob_2);
        
        // student 2 Schedule collection
        ArrayList<Schedule> carls_schedule = new ArrayList<>();
        Schedule schedule_of_carl_1 = new Schedule(1, "Study group", "2/2/18", "Sherrod Library");
        carls_schedule.add(schedule_of_carl_1);
        
        // student 3 Schedule collection
        ArrayList<Schedule> dans_schedule = new ArrayList<>();
        Schedule schedule_of_dan_1 = new Schedule(1, "Study group", "2/2/18", "Sherrod Library");
        carls_schedule.add(schedule_of_carl_1);
        dans_schedule.add(schedule_of_dan_1);
        
        // User collection
        // template array for UI, accepts Admin and Students
        ArrayList<User> collection = new ArrayList<>();
        Admin admin_andy = new Admin(1000, "Andy");
        Student student_bob = new Student(1001, "Bob", false, false, bobs_friends, bobs_schedule);
        Student student_carl = new Student(1002, "Carl", true, false, carls_friends, carls_schedule);
        Student student_dan = new Student(1003, "Dan", true, true, dans_friends, dans_schedule);
        collection.add(admin_andy);
        collection.add(student_bob);
        collection.add(student_carl);
        collection.add(student_dan);
        
        // populate UI
        printMe(collection);  
    }
    
    
    // manifest UI
    public static void printMe(ArrayList<User> c) {
        for(int i = 0; i < c.size(); i++) {
            
            // UI for User
            System.out.println("\n------------------");
            System.out.println("ID: " + c.get(i).id);
            System.out.println("Name: " + c.get(i).name);
            String class_name = c.get(i).getClass().getSimpleName();
            Student s;
            
            // specific UI for Students
            if (class_name.equals("Student")) {
                System.out.println("User type: Student");
                s = (Student) c.get(i);
                int friend_count = s.friends.size();
                System.out.println(s.name + " has " + friend_count + " friends.");
                System.out.println("Schedule is as follows: ");
                s.schedule.forEach((schedule) -> {
                    String task_name = schedule.name;
                    String task_location = schedule.location;
                    String task_date = schedule.time;
                    System.out.println("\t" + task_name + " at " + task_location + " on " + task_date);
                });
                System.out.println( "\n" );
                
            // specific UI for Admin
            } else {
                int student_count = 0;
                for(int j = 0; j < c.size(); j++) {
                    String student_obj = c.get(j).getClass().getSimpleName();
                    student_count += ((student_obj.equals("Student")) ? 1 : 0);
                }
                System.out.println("User type: Admin");
                System.out.println("Student count: " + student_count);
                System.out.println( "\n" );
            }
        }
    }
    

}


