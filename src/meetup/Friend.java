
package meetup;

/**
 *
 * @author Jim
 */
public class Friend {
    
    protected int id;
    protected boolean blocked;
    
    public Friend(int i, boolean b) {
        this.id = i;
        this.blocked = b;
    }
    public void toggleBlock() {
        this.blocked = !this.blocked;
    }
    
}