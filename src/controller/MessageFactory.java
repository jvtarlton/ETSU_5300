
package controller;
import model.Image;
import model.Message;
import model.Text;

/**
 * This is the factory pattern implementation interface for Message concretion
 */
public interface MessageFactory {
    
    public static Message Message(String type, String[] blob) {
        
        // condition for creating Text message
        if(type.equals("Text")) {
            int id = Integer.parseInt(blob[0]);
            int receiver_id = Integer.parseInt(blob[1]);
            String sent_time = blob[2];
            String body = blob[3];
            return new Text(id, receiver_id, sent_time, body);
            
        // condition for creating Image message
        } else {
            int id = Integer.parseInt(blob[0]);
            int receiver_id = Integer.parseInt(blob[1]);
            String sent_time = blob[2];
            String file_name = blob[3];
            String file_type = blob[4];
            String file_size = blob[5];
            String file_location = blob[6];
            return new Image(
                    id, 
                    receiver_id, 
                    sent_time, 
                    file_name,
                    file_type,
                    file_size,
                    file_location
            );
        }
        
    }
}
