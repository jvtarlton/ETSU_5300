
package meetup;

/**
 *
 * @author Jim
 */
public class Admin extends User {
    
    public Admin(int i, String n) {
        super(i, n);
    }
    
    /**
     * additional administrator functionality 
     */
    public int getStudentCount() { return 0; };
    public int getSuggestionCount() { return 0; };
    public int getConnectionCount() { return 0; };
    public int getConDelCount() { return 0; };
    public int getConDefCount() { return 0; };
    public int getMsgCount() { return 0; };
    public Friend getBlockedStuents() { Friend f = new Friend(9999, false); return f; };
    public int banStudent() { return 0; };
    
}