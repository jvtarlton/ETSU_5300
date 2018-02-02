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
        Admin admin_andy = new Admin(100, "Andy");
        Student student_bob = new Student(1001, "Bob", false, false);
        
        // error
        //Student.Friend friend_of_bob_1 = new Student.Friend(1002, false);
        
        ArrayList<Student.Friend> bobs_friends = new ArrayList<>();
        //bobs_friends.add(friend_of_bob_1);
        //bobs_friends.add(friend_of_bob_1);
        //bobs_friends.add(friend_of_bob_1);
        //bobs_friends.add(friend_of_bob_1);
        
        ArrayList<Student.Schedule> bobs_schedule = new ArrayList<>();
        
        student_bob.populateStudent(bobs_friends, bobs_schedule);
        
        ArrayList<User> collection = new ArrayList<User>();
        collection.add(admin_andy);
        collection.add(student_bob);
        printMe(collection);  
    }
    
    public static void printMe(ArrayList<User> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i).name);
        }
    }
    

}


