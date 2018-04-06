
package view;
import java.util.*;

/**
 * This class represents the Admin subclass user type
 * @author Jim
 */
public class CarPooler extends User {
    
    
    // private members
    private final boolean car;         // indicates if user has a car
    private List<BoardPost> board_posts;
    private List<GroupMember> group_members;
    
    
    
    // constructor
    protected CarPooler(int id, String name, boolean car) {
        super(id, name);
        this.car = car;
    }
    
    
    // CarPooler mutators
    protected void addBoardPost(BoardPost new_post) {
        ArrayList<BoardPost> tmp = new ArrayList<>(board_posts);
        tmp.add(new_post);
        board_posts = tmp;
    }
    protected void addGroupMember(GroupMember new_member) {
        ArrayList<GroupMember> tmp = new ArrayList<>(group_members);
        tmp.add(new_member);
        group_members = tmp;
    }
    
    
    // CarPooler accessors
    protected boolean getCarStatus() {
        return this.car;
    }
    
    
    
    // prints object members
    @Override public String toString() {
        return
            "\n=====================================" +
                "=====================================" +
                "==============" +
            "\nAccount Type: Admin" +
            "\nID: " + super.getID() + 
            "\nName: " + super.getName() + 
            "\nHas a car: " + ((this.getCarStatus()) ? "YES" : "NO") +
            "\n";
    }
    
}