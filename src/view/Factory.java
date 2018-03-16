
package view;
import java.util.List;

/**
 *
 * @author jvtar
 */
public interface Factory {
    
    // ============================================
    // Admin factories
    // -------------------------------------------------------------------------
    // Admin
    // -------------------------------------------------------------------------
    public static User User(int id, String name) {
        return new Admin(id, name);
    }
    
    // ============================================
    // Student factories
    // -------------------------------------------------------------------------
    // Student 
    // -------------------------------------------------------------------------
    public static User User(
            int id, 
            String name, 
            boolean flagged, 
            boolean banned,
            List<Friend> friends, 
            List<Schedule> schedule
    ) {
        return new Student(id, name, flagged, banned, friends, schedule); 
    }
    // -------------------------------------------------------------------------
    // Student - Friend
    // -------------------------------------------------------------------------
    public static Friend Friend(int id, boolean blocked) {
        return new Friend(id, blocked); 
    }
    // -------------------------------------------------------------------------
    // Student - Schedule
    // -------------------------------------------------------------------------
    public static Schedule Schedule(
            int id, 
            String name, 
            String time, 
            String location
    ) {
        return new Schedule(id, name, time, location); 
    }
    // -------------------------------------------------------------------------
    // Student - Suggestion
    // -------------------------------------------------------------------------
    public static Suggestion Suggestion(
        int id, 
        int friend_id, 
        int friend_schedule_id, 
        boolean accepted
    ) {
        return new Suggestion(id, friend_id, friend_schedule_id, accepted); 
    }
    
}
