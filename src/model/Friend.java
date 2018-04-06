
package model;

/**
 * This class is a Student aggregate class
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
    
    // gets user id of friend
    public int getID() {
        return this.id;
    }
    
    // gets block status of friend
    public boolean getBlockStatus() {
        return this.blocked;
    }
    
    // functionality to let student block/unblock a friend from friends list
    protected void toggleBlock() {
        this.blocked = ((this.blocked != true));
    }
    
    // toString to print friend item
    @Override public String toString() {
        return "\t" + 
            this.id + " -- ";
    }
    
}