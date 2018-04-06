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
public class Text extends Message {
    
    private String body;
    
    public Text(int id, int receiver_id, String sent_time, String body) {
        super(id, receiver_id, sent_time);
        this.body = body;
    }
    
}
