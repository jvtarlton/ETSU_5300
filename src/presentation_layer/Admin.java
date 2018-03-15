
package presentation_layer;
import java.util.*;

/**
 * This class represents the Admin subclass user type
 * @author Jim
 */
public class Admin extends User {
    
    private int student_count;
    private int message_count;
    private int suggestion_count;
    private int connection_count;
    
    // constructor
    protected Admin(int id, String name) {
        super(id, name);
    }
    
    /**
     * additional administrator functionality 
     * @param data
     */
    protected void setStudentCount(ArrayList<User> data) { 
        int count = 0;
        for(int j = 0; j < data.size(); j++) {
            String user_type = data.get(j).getClass().getSimpleName();
            count += user_type.equals("Student") ? 1 : 0;
        }
        this.student_count = count;
    }
    
    protected int getStudentCount() { return this.student_count; };
    protected int getSuggestionCount() { return this.suggestion_count; };
    protected int getConnectionCount() { return this.connection_count; };
    protected int getConDelCount() { return 0; };
    protected int getConDefCount() { return 0; };
    protected int getMsgCount() { return this.message_count; };
    protected Friend getBlockedStuents() { return new Friend(9999, false); };
    protected int banStudent() { return 0; };
    
    @Override public String toString() {
        return
            "\n=====================================" +
                "=====================================" +
                "==============" +
            "\nAccount Type: Admin" +
            "\nID: " + super.getID() + 
            "\nName: " + super.getName() + 
            "\nStudent count: " + this.getStudentCount() +
            "\n";
    }
    
}