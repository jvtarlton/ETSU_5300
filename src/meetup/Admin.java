
package meetup;
import java.util.*;

/**
 * This class represents the Admin subclass user type
 * @author Jim
 */
public class Admin extends User {
    
    int student_count;
    int message_count;
    int suggestion_count;
    int connection_count;
    
    // constructor
    public Admin(int i, String n) {
        super(i, n);
    }
        
    /**
     * additional administrator functionality 
     */
    public void setStudentCount(ArrayList<User> data) { 
        int count = 0;
        for(int j = 0; j < data.size(); j++) {
            String user_type = data.get(j).getClass().getSimpleName();
            count += user_type.equals("Student") ? 1 : 0;
        }
        this.student_count = count;
    }
    public int getStudentCount() { return student_count; };
    public int getSuggestionCount() { return suggestion_count; };
    public int getConnectionCount() { return connection_count; };
    public int getConDelCount() { return 0; };
    public int getConDefCount() { return 0; };
    public int getMsgCount() { return message_count; };
    public Friend getBlockedStuents() { Friend f = new Friend(9999, false); return f; };
    public int banStudent() { return 0; };
    
    @Override
    public String toString() {
        return
            "\n------------------" +
            "\nAccount Type: Admin" +
            "\nID: " + super.id + 
            "\nName: " + super.name + 
            "\nStudent count: " + this.getStudentCount() +
            "\n";
    }
    
}