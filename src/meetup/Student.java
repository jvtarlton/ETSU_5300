
package meetup;
import java.util.*;

/**
 * This class represents the Student subclass user type
 * @author Jim
 */
public class Student extends User {
    
    // protected members
    protected boolean flagged;
    protected boolean ban;
    protected List<Friend> friends;
    protected List<Schedule> schedule;
    protected List<Suggestion> suggestions;
    
    // constructor
    public Student(
            int i, String n, 
            boolean f, boolean b, 
            List<Friend> fs, 
            List<Schedule> sh
    ) {
        super(i, n);
        this.ban = b;
        this.friends = fs;
        this.schedule = sh;
    }
    
    public List<Schedule> getSchedule() {
        return schedule;
    }
    
    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void addSchedule(Schedule s) {
        schedule.add(s);
    }

    public void findScheduleMatches() {
        // loop trough anonymous students collection
        // find common schedules
        // append to suggestions collection
    }

    @Override
    public String toString() {
        String output =  
            "\n------------------" +
            "\nAccount Type: Student" +
            "\nID: " + super.id + 
            "\nName: " + super.name + 
            "\nFriend count: " + this.friends.size() +
            "\nSchedule is as follows: \n";
            for(int i = 0; i < this.schedule.size(); i++) {
                output += "\t" +
                    this.schedule.get(i).name + " on " +
                    this.schedule.get(i).time + " at " +
                    this.schedule.get(i).location + "\n"; 
            }
        return output;
    }
    
    
}