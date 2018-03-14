
package presentation_layer;
import java.util.List;

/**
 * This class represents the User abstract base class for system users.
 * @author Jim
 */
public abstract class User implements UserInterface {
    
    // private members
    private final int id;
    private String name;
    private String username;
    private String password;
    
    // base constructor
    protected User(int id, String name) {
        String un_suffix = Integer.toString(id);
        this.username = name + un_suffix;
        this.password = "password";
        this.id = id;
        this.name = name;
    }
    
    // factory method for admin user
    public static User make(int id, String name) {
        return new Admin(id, name); 
    }
    
    // factory method for student user
    public static User make(
            int id, 
            String name, 
            boolean flagged, 
            boolean banned,
            List<Friend> friends, 
            List<Schedule> schedule
    ) {
        return new Student(id, name, flagged, banned, friends, schedule); 
    }
    
    @Override public int getID() { return this.id; }
    @Override public String getName() { return this.name; }
    @Override public String getUsername() { return this.username; }
    @Override public String getPassword() { return this.password; }
    
    
}