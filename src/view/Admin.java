
package view;
import java.util.*;

/**
 * This class represents the Admin subclass user type
 * @author Jim
 */
public class Admin extends User {
    
    
    // private members
    private int user_count;             // count of all users, including admins
    private int admin_count;        // count of all admin users
    private int student_count;      // count of all student users
    private int message_count;
    private int suggestion_count;
    private int connection_count;
    
    
    // constructor
    protected Admin(int id, String name) {
        super(id, name);
    }
    
    /**
     * additional administrator functionality for displaying user count
     * @param data
     */
    public void setUserCounts(ArrayList<User> data) { 
        data.forEach((user) -> {
            if(user instanceof Admin) {
                this.admin_count++;
            } else if (user instanceof Student) {
                this.student_count++;
            }
        });
        this.user_count = data.size();
    }
    
    
    // Admin accessors
    protected int getUserCount() { return this.user_count; };
    protected int getAdminCount() { return this.admin_count; };
    protected int getStudentCount() { return this.student_count; };
    protected int getSuggestionCount() { return this.suggestion_count; };
    protected int getConnectionCount() { return this.connection_count; };
    protected int getConDelCount() { return 0; };
    protected int getConDefCount() { return 0; };
    protected int getMsgCount() { return this.message_count; };
    protected Friend getBlockedStuents() { return new Friend(9999, false); };
    protected int banStudent() { return 0; };
    
    
    // prints object members
    @Override public String toString() {
        return
            "\n=====================================" +
                "=====================================" +
                "==============" +
            "\nAccount Type: Admin" +
            "\nID: " + super.getID() + 
            "\nName: " + super.getName() + 
            "\nUser count: " + this.getUserCount() +
            "\nAdmin count: " + this.getAdminCount() +
            "\nStudent count: " + this.getStudentCount() +
            "\n";
    }
    
}