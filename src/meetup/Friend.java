
package meetup;

public class Friend {
    int id;
    boolean blocked;
    
    public Friend(int i, boolean b) {
        this.id = i;
        this.blocked = b;
    }
    public void toggleBlock() {
        this.blocked = !this.blocked;
        //this.blocked = this.blocked ? false : true;
    }
}