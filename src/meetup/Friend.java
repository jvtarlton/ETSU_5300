
package meetup;

/**
 * This class is a Student aggregate class
 * @author Jim
 */
public class Friend {
    
    // private members
    protected int id;
    protected boolean blocked;
    
    // constructor
    public Friend(int i, boolean b) {
        this.id = i;
        this.blocked = b;
    }
    
    // factory method
    static Friend make(int i, boolean b) {
        return new Friend(i, b); 
    }
    
    // functionality to let student block/unblock a friend from friends list
    public void toggleBlock() {
        this.blocked = ((this.blocked == true) ? false : true);
    }
    
    
    
    
}