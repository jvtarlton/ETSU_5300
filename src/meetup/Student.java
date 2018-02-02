

package meetup;

import java.util.*;  
public class Student extends User {
    boolean flagged;
    boolean ban;
    ArrayList<Friend> friends;
    ArrayList<Schedule> schedule;
    
    public Student(int i, String n, boolean f, boolean b) {
        super(i, n);
        this.ban = b;
    }
    public void populateStudent(ArrayList<Friend> fs, ArrayList<Schedule> sh) {
        this.friends = fs;
        this.schedule = sh;
    }
    
    // schedule inner-object
    // schedule inner-object
    public class Schedule {
        int id;
        String name;
        String time;
        String location;
        
        public Schedule(int i, String n, String t, String l) {
            this.id = i;
            this.name = n;
            this.time = t;
            this.location = l;
        }
        
    }
    public void addSchedule(Schedule s) {
        schedule.add(s);
    }
    
    // friend inner-object
    // friend inner-object
    public class Friend {
        int id;
        boolean blocked;
        public Friend(int i, boolean b) {
            this.id = i;
            this.blocked = b;
        }
        public void toggleBlock() {
            this.blocked = !this.blocked;
            //this.blocked = this.blocked ? false : true;
        }
    }
    public void addFriend(Friend f) {
        friends.add(f);
    }
}