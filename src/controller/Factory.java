
package controller;
import java.util.List;
import model.Admin;
import model.CarPooler;
import model.Friend;
import model.Course;
import model.Student;
import model.Suggestion;
import model.User;

/**
 * This is the factory pattern implementation interface for User concretion
 */
public interface Factory {
    
    // ============================================
    // CarPooler factories
    // -------------------------------------------------------------------------
    // Admin
    // -------------------------------------------------------------------------
    public static User User(int id, String name, boolean car) {
        return new CarPooler(id, name, car);
    }
    
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
            List<Course> schedule
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
    // Student - Course
    // -------------------------------------------------------------------------
    public static Course Course(
            int id, 
            String name, 
            String time, 
            String location
    ) {
        return new Course(id, name, time, location); 
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
