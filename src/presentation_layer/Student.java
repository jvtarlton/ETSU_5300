
package presentation_layer;
import java.util.*;

/**
 * This class represents the Student subclass user type
 * @author Jim
 */
public class Student extends User {
    
    // private members
    private boolean flagged;
    private boolean banned;
    private List<Friend> friends;
    private List<Schedule> schedule;
    private List<Suggestion> suggestions;
    
    // constructor
    protected Student(
            int id,
            String name, 
            boolean flagged,
            boolean banned, 
            List<Friend> friends, 
            List<Schedule> schedule
    ) {
        super(id, name);
        this.flagged = flagged;
        this.banned = banned;
        this.friends = friends;
        this.schedule = schedule;
    }
    
    protected List<Schedule> getSchedule() {
        return this.schedule;
    }
    
    protected List<Suggestion> getSuggestions() {
        return this.suggestions;
    }
    
    protected void setSuggestions(ArrayList<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    protected void addSchedule(Schedule s) {
        ArrayList<Schedule> tmp = new ArrayList<>(schedule);
        tmp.add(s);
        schedule = tmp;
    }
    
    @Override public String toString() {
        String output =  
            "\n------------------" +
            "\nAccount Type: Student" +
            "\nID: " + super.getID() + 
            "\nName: " + super.getName() + 
            "\nFriend count: " + this.friends.size() +
            "\nSchedule is as follows: \n";
            for (Schedule s : this.schedule) {
                output += s.toString();
            }
        return output;
    }
    
}