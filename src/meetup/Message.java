
package meetup;

/**
 * This class is a Student aggregate class
 * @author Jim
 */
public class Message {
    
    // protected members
    protected int id;
    protected int receiver_id;
    protected String sent_time;
    protected String body;
    
    // constructor
    public Message(int i, int r, String st, String b) {
        this.id = i;
        this.receiver_id = r;
        this.sent_time = st;
        this.body = b;
    }
    
    // factory method
    static Message make(int i, int r, String st, String b) {
        return new Message(i, r, st, b); 
    }
    
}
