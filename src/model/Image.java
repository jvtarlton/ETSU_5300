/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jvtar
 */
public class Image extends Message {
    
    private String file_name;
    private String file_type;
    private String file_size;
    private String file_location;
    
    public Image(
            int id, 
            int receiver_id, 
            String sent_time, 
            String file_name,
            String file_type,
            String file_size,
            String file_location
    ) {
        super(id, receiver_id, sent_time);
        this.file_name = file_name;
        this.file_type = file_type;
        this.file_size = file_size;
        this.file_location = file_location;
    }
    
}
