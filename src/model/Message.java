
package model;

/**
 * This class is a Student aggregate class
 */
public abstract class Message {
    
    // protected members
    private int id;
    private int receiver_id;
    private String sent_time;
    private String body;
    
    // constructor 
    public Message(int id, int receiver_id, String sent_time) {
        this.id = id;
        this.receiver_id = receiver_id;
        this.sent_time = sent_time;
    }
    
    // accessors
    public int getID() {
        return id;
    }
    
}
