
package meetup;

/**
 * This class is a Student aggregate class
 * @author Jim
 */
public class Message {
    
    // protected members
    private int id;
    private int receiver_id;
    private String sent_time;
    private String body;
    
    // constructor
    protected Message(int id, int receiver_id, String sent_time, String body) {
        this.id = id;
        this.receiver_id = receiver_id;
        this.sent_time = sent_time;
        this.body = body;
    }
    
    // factory method
    protected static Message make(
            int id, 
            int receiver_id, 
            String sent_time, 
            String body
    ) {
        return new Message(id, receiver_id, sent_time, body); 
    }
    
}
