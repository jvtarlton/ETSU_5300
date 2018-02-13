
package meetup;

import java.util.List;

/**
 * This class represents the User abstract base class for system users.
 * @author Jim
 */
public abstract class User implements UserInterface {
    
    // private members
    int id;
    String name;
    String un;
    String pw;
    
    // base constructor
    public User(int i, String n) {
        this.id = i;
        this.name = n;
    }
    
    // factory method for admin user
    static User make(int i, String n) {
        return new Admin(i, n); 
    }
    
    // factory method for student user
    static User make(
            int i, 
            String n, 
            boolean f, 
            boolean b,
            List<Friend> fs, 
            List<Schedule> sh
    ) {
        return new Student(i, n, f, b, fs, sh); 
    }
}