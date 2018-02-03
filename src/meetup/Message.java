
package meetup;

/**
 *
 * @author Jim
 */
public class Message {
    
    int id;
    int receiver_id;
    String sent_time;
    String body;
    
    public Message(int i, int r, String st, String b) {
        this.id = i;
        this.receiver_id = r;
        this.sent_time = st;
        this.body = b;
    }
    
}
