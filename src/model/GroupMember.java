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
public class GroupMember {
    
    // private members
    private int id;
    private int boardpost_id;
    
    // constructor
    public GroupMember(int id, int boardpost_id) {
        this.id = id;
        this.boardpost_id = boardpost_id;
    }
}
