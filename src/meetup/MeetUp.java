/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetup;
import java.util.*;
/**
 *
 * @author Jim
 */
public class MeetUp {
    
    public static void main(String[] args) {
        
        Friend friend_of_bob_1 = new Friend(1002, false);
        Friend friend_of_bob_2 = new Friend(1003, true);
        Friend friend_of_bob_3 = new Friend(1004, false);
        ArrayList<Friend> bobs_friends = new ArrayList<>();
        bobs_friends.add(friend_of_bob_1);
        bobs_friends.add(friend_of_bob_2);
        bobs_friends.add(friend_of_bob_3);
        
        Friend friend_of_carl_1 = new Friend(1001, false);
        Friend friend_of_carl_2 = new Friend(1003, false);
        ArrayList<Friend> carls_friends = new ArrayList<>();
        carls_friends.add(friend_of_carl_1);
        carls_friends.add(friend_of_carl_2);
        
        Friend friend_of_dan_1 = new Friend(1001, false);
        Friend friend_of_dan_2 = new Friend(1002, true);
        ArrayList<Friend> dans_friends = new ArrayList<>();
        dans_friends.add(friend_of_dan_1);
        dans_friends.add(friend_of_dan_2);
        
        Schedule schedule_of_bob_1 = new Schedule(1, "Study group", "2/2/18", "Sherrod Library");
        Schedule schedule_of_bob_2 = new Schedule(2, "Yoga practice", "2/3/18", "BCPA");
        ArrayList<Schedule> bobs_schedule = new ArrayList<>();
        bobs_schedule.add(schedule_of_bob_1);
        bobs_schedule.add(schedule_of_bob_2);
        
        Schedule schedule_of_carl_1 = new Schedule(1, "Study group", "2/2/18", "Sherrod Library");
        ArrayList<Schedule> carls_schedule = new ArrayList<>();
        carls_schedule.add(schedule_of_carl_1);
        
        Schedule schedule_of_dan_1 = new Schedule(1, "Study group", "2/2/18", "Sherrod Library");
        ArrayList<Schedule> dans_schedule = new ArrayList<>();
        dans_schedule.add(schedule_of_dan_1);
        
        Admin admin_andy = new Admin(1000, "Andy");
        Student student_bob = new Student(1001, "Bob", false, false, bobs_friends, bobs_schedule);
        Student student_carl = new Student(1002, "Carl", true, false, carls_friends, carls_schedule);
        Student student_dan = new Student(1003, "Dan", true, true, dans_friends, dans_schedule);
        ArrayList<User> collection = new ArrayList<>();
        collection.add(admin_andy);
        collection.add(student_bob);
        collection.add(student_carl);
        collection.add(student_dan);
        
        printMe(collection);  
    }
    
    
    
    public static void printMe(ArrayList<User> c) {
        for(int i = 0; i < c.size(); i++) {
            
            System.out.println("\n------------------");
            System.out.println("ID: " + c.get(i).id);
            System.out.println("Name: " + c.get(i).name);
            String class_name = c.get(i).getClass().getSimpleName();
            Student s;
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


