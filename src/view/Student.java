
package view;
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
    private List <Message> message;
    private ArrayList<FriendRequest> friend_requests;
    
    
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
    
    
    // Student accessors
    public List<Friend> getFriends() { return this.friends;  }
    public List<Schedule> getSchedule() { return this.schedule; }
    public List<Suggestion> getSuggestions() { return this.suggestions; }
    
    
    // Student mutators
    public void setSuggestions(ArrayList<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }
    
    public void addFriendRequest(int id, boolean accepted) {
        FriendRequest f = new FriendRequest(id, accepted);
    }
    
    public void addSchedule(Schedule s) {
        ArrayList<Schedule> tmp = new ArrayList<>(schedule);
        tmp.add(s);
        schedule = tmp;
    }
    
    public void deleteSchedule(int id) {
        schedule.stream().filter((item) -> (item.getID() == id)).forEachOrdered((item) -> {
            schedule.remove(item);
        });
    }
    
    public void addMessage(Message m) {
        ArrayList<Message> tmp = new ArrayList<>(message);
        tmp.add(m);
        message = tmp;
    }
    
    public void deleteMessage(int id) {
        message.stream().filter((item) -> (item.getID() == id)).forEachOrdered((item) -> {
            message.remove(item);
        });
    }
    
    
    // prints object members
    @Override public String toString() {
        String output =  
            "\n===============================" +
                "===============================" +
                "===============================" +
                "===============================" +
            "\nAccount Type: Student" +
            "\nID: " + super.getID() + 
            "\nName: " + super.getName() + 
            "\nFriend count: " + this.friends.size() +
            "\nSchedule is as follows: ";
            if(this.schedule.size() > 0) {
                for (Schedule s : this.schedule) {
                    output += "\n" + s.toString();
                };
            } else {
                output += "\n\t1 -- You do not have any items scheduled.";
            }
        return output;
    }
    
}