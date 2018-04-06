/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author jvtar
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
