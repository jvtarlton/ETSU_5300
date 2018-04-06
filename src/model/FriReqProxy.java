
package model;

/**
 * This is a proxy class for the FriendRequest class
 */
public class FriReqProxy implements FriReqInterface {
    
    
    // private members
    private int id;
    private boolean accept;
    
    // proxied item
    FriendRequest fr;
    
    
    // constructor
    FriReqProxy(int id, boolean accept) {
        this.id = id;
        this.accept = accept;
        fr = new FriendRequest(this.id, this.accept);
    }
    
    @Override 
    public void log(int id) {
        // log events here
    }
}
