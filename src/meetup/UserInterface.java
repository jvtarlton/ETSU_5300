
package meetup;

/**
 *
 * @author jvtar
 */
public interface UserInterface {
    
    public default int getID() { msg(0); return 0; }
    public default String getName() { msg(1); return ""; };
    public default String getUsername() { msg(2); return ""; }
    public default String getPassword() { msg(3); return ""; };
        
    public default void msg(int e) {
        String error_type[] = {
            "ID ",
            "Name ",
            "Username",
            "Password"
        };
        System.out.println(
            error_type[e] + "not found!"
        );
    }
    
}
