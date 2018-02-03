
package meetup;

/**
 *
 * @author Jim
 */
public abstract class User {
    int id;
    String name;
    String un;
    String pw;
    
    public User(int i, String n) {
        this.id = i;
        this.name = n;
    }
    
    public User(int id, String name, String un, String pw) {
        this.id = id;
        this.name = name;
        this.un = un;
        this.pw = pw;
    }
    
    public void setName(String n) {
        this.name = n;
    }
    
    public String getName() {
        return name;
    }
    
    
}