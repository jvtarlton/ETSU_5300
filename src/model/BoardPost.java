
package model;

/**
 * This class is a CarPooler composition class
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
