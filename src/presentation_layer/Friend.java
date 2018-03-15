
package presentation_layer;

/**
 * This class is a Student aggregate class
 * @author Jim
 */
public class Friend {
    
    // private members
    private int id;
    private boolean blocked;
    
    // constructor
    public Friend(int id, boolean blocked) {
        this.id = id;
        this.blocked = blocked;
    }
    
    // functionality to let student block/unblock a friend from friends list
    protected void toggleBlock() {
        this.blocked = ((this.blocked != true));
    }
    
}