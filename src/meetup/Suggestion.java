
package meetup;

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
    
    // factory method
    static Suggestion make(
        int id, 
        int friend_id, 
        int friend_schedule_id, 
        boolean accepted
    ) {
        return new Suggestion(id, friend_id, friend_schedule_id, accepted); 
    }
    
    // functionality for accepting/denying schedule suggestion
    public void toggleSuggestion() {
        this.accepted = ((this.accepted != true));
    }
    
    public void printSuggestion() {
        // loop trough anonymous students collection
        // print common schedules
    }
}
