
package view;

/**
 * This class represents the User abstract base class for system users.
 * @author Jim
 */
public abstract class User {
        
    
    // private members
    private final int id;
    private String name;
    private String username;
    private String password;
    
    
    // base constructor
    protected User(int id, String name) {
        String un_suffix = Integer.toString(id);
        this.username = name + un_suffix;
        this.password = "password";
        this.id = id;
        this.name = name;
    }
    
    
    // User accessors
    public int getID() { return this.id; }
    public String getName() { return this.name; }
    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    
    
}