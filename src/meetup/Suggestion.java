
package meetup;

/**
 *
 * @author Jim
 */
public class Suggestion {
    
    int id;
    int friend_id;
    int friend_schedule_id;
    boolean accept;
    
    public Suggestion(int i, int fi, int fsi, boolean a) {
        this.id = i;
        this.friend_id = fi;
        this.friend_schedule_id = fsi;
        this.accept = a;
    }
    
    public void toggleSuggestion() {
        this.accept = !this.accept;
    }
    
    public void printSuggestion() {
        // loop trough anonymous students collection
        // print common schedules
    }
}
