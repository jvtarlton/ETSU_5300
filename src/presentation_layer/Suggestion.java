
package presentation_layer;

/**
 * This class is a Student aggregate class
 * @author Jim
 */
public class Suggestion {
    
    // protected members
    protected int id;
    protected int friend_id;
    protected int friend_schedule_id;
    protected boolean accepted;
    
    // constructor
    public Suggestion(
            int id, 
            int friend_id, 
            int friend_schedule_id, 
            boolean accepted
    ) {
        this.id = id;
        this.friend_id = friend_id;
        this.friend_schedule_id = friend_schedule_id;
        this.accepted = accepted;
    }
    
    // functionality for accepting/denying schedule suggestion
    public void toggleSuggestion() {
        this.accepted = ((this.accepted != true));
    }
    
    public int getID(){
        return this.id;
    }
    
    public int getFriendID(){
        return this.friend_id;
    }
    
    public int getFriendScheduleID(){
        return this.friend_schedule_id;
    }
    
    public boolean getAccepted(){
        return this.accepted;
    }
    
    // toString to print suggestion item
    @Override public String toString() {
        return "\t" + 
            this.id + " -- " + "student with ID " + 
            this.friend_id + " has a similarly scheduled item of ID " + 
            this.friend_schedule_id + ".  You have " + ((this.accepted) ? "" : "not ") +
             "accepted this suggtestion.\n";
    }
}
