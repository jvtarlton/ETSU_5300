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
public class BoardPost {
    
    // private members
    private int id;
    private String type;
    private int group_id;
    
    // constructor
    BoardPost(int id, String type, int group_id) {
        this.id = id;
        this.type = type;
        this.group_id = group_id;
    }    
}
