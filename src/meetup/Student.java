

package meetup;

import java.util.*;  
public class Student extends User {
    boolean flagged;
    boolean ban;
    ArrayList<Friend> friends;
    ArrayList<Schedule> schedule;
    
    public Student(int i, String n, boolean f, boolean b, ArrayList<Friend> fs, ArrayList<Schedule> sh) {
        super(i, n);
        this.ban = b;
        this.friends = fs;
        this.schedule = sh;
    }
    

    public void addSchedule(Schedule s) {
        schedule.add(s);
    }
    

    public void addFriend(Friend f) {
        friends.add(f);
    }
}