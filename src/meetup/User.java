
package meetup;

import java.util.List;

/**
 * This class represents the User abstract base class for system users.
 * @author Jim
 */
public abstract class User implements UserInterface {
    
    // private members
    private final int id;
    private String name;
    private String un;
    private String pw;
    
    // base constructor
    protected User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // factory method for admin user
    protected static User make(int id, String name) {
        return new Admin(id, name); 
    }
    
    // factory method for student user
    protected static User make(
            int id, 
            String name, 
            boolean flagged, 
            boolean banned,
            List<Friend> friends, 
            List<Schedule> schedule
    ) {
        return new Student(id, name, flagged, banned, friends, schedule); 
    }
    
    @Override public String getName() { return this.name; }
    @Override public int getID() { return this.id; }
    
}