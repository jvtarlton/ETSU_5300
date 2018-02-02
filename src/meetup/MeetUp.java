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
        Schedule schedule_of_bob_1 = new Schedule(1, "Study group", "2/2/18", "Sherrod Library");
        Schedule schedule_of_bob_2 = new Schedule(2, "Yoga practice", "2/3/18", "BCPA");
        ArrayList<Friend> bobs_friends = new ArrayList<>();
        bobs_friends.add(friend_of_bob_1);
        bobs_friends.add(friend_of_bob_2);
        bobs_friends.add(friend_of_bob_3);
        ArrayList<Schedule> bobs_schedule = new ArrayList<>();
        Admin admin_andy = new Admin(100, "Andy");
        Student student_bob = new Student(1001, "Bob", false, false, bobs_friends, bobs_schedule);
        ArrayList<User> collection = new ArrayList<User>();
        collection.add(admin_andy);
        collection.add(student_bob);
        printMe(collection);  
    }
    
    
    
    public static void printMe(ArrayList<User> c) {
        for(int i = 0; i < c.size(); i++) {
            
            // This works, superclass (abstract) member found
            String name = c.get(i).name;
            System.out.println("Name: " + c.get(i).name);
            
            // ERROR - subclass member not found
            String ban = c.get(i).getBan();
            System.out.println("Banned : " + c.get(i).getBan()); 

        }
    }
    

}


