
package model;
import java.util.*;

/**
 * This class represents a concretion of the User abstract
 */
public class Student extends User {
    
    
    // private members
    private boolean flagged;
    private boolean banned;
    private List<Friend> friends;
    private List<Course> schedule;
    private List<Suggestion> suggestions;
    private List<Message> message;
    private List<FriReqProxy> friend_request_proxies;
    
    
    // constructor
    public Student(
            int id,
            String name, 
            boolean flagged,
            boolean banned, 
            List<Friend> friends, 
            List<Course> schedule
    ) {
        super(id, name);
        this.flagged = flagged;
        this.banned = banned;
        this.friends = friends;
        this.schedule = schedule;
    }
    
    
    // Student accessors
    public List<Friend> getFriends() { return this.friends;  }
    public List<Course> getSchedule() { return this.schedule; }
    public List<Suggestion> getSuggestions() { return this.suggestions; }
    
    
    // Student mutators
    public void setSuggestions(ArrayList<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }
    
    // add new friend request via proxy
    public void addFriendRequest(int id, boolean accepted) {
        FriReqProxy f = new FriReqProxy(id, accepted);
        ArrayList<FriReqProxy> tmp = new ArrayList<>();
        tmp.add(f);
        friend_request_proxies = tmp;
    }
    
    public void addSchedule(Course s) {
        ArrayList<Course> tmp = new ArrayList<>(schedule);
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
                for (Course s : this.schedule) {
                    output += "\n" + s.toString();
                };
            } else {
                output += "\n\t1 -- You do not have any items scheduled.";
            }
        return output;
    }
    
}