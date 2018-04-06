
package model;

/**
 * This class represents a concretion of the Message abstract
 */
public class Text extends Message {
    
    private String body;
    
    public Text(int id, int receiver_id, String sent_time, String body) {
        super(id, receiver_id, sent_time);
        this.body = body;
    }
    
}
