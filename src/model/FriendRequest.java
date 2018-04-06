
package model;

/**
 * This class is a Student aggregate class
 */
public class FriendRequest implements FriReqInterface {
    
    
    // private members
    private int id;
    private boolean accept;
    
    
    // constructor
    public FriendRequest(int id, boolean accept) {
        this.id = id;
        this.accept = accept;
    }
    
    @Override 
    public void log(int id) {
        // log events here
    }
    
}
