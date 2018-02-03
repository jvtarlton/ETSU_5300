
package meetup;
import java.util.*;

/**
 *
 * @author Jim
 */
public class Student extends User {
    
    protected boolean flagged;
    protected boolean ban;
    protected ArrayList<Friend> friends;
    protected ArrayList<Schedule> schedule;
    protected ArrayList<Suggestion> suggestions;
    
    public Student(int i, String n, boolean f, boolean b, ArrayList<Friend> fs, ArrayList<Schedule> sh) {
        super(i, n);
        this.ban = b;
        this.friends = fs;
        this.schedule = sh;
    }
    
    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }
    
    public ArrayList<Suggestion> getSuggestions() {
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
}