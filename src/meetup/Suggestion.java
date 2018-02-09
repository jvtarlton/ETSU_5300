
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
    protected boolean accept;
    
    // constructor
    public Suggestion(int i, int fi, int fsi, boolean a) {
        this.id = i;
        this.friend_id = fi;
        this.friend_schedule_id = fsi;
        this.accept = a;
    }
    
    // factory method
    static Suggestion make(int i, int fi, int fsi, boolean a) {
        return new Suggestion(i, fi, fsi, a); 
    }
    
    // functionality for accepting/denying schedule suggestion
    public void toggleSuggestion() {
        this.accept = ((this.accept == true) ? false : true);
    }
    
    public void printSuggestion() {
        // loop trough anonymous students collection
        // print common schedules
    }
}
