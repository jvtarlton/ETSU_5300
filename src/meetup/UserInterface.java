/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetup;

/**
 *
 * @author jvtar
 */
public interface UserInterface {
    
    public default int getID() { msg(0); return 0; }
    public default String getName() { msg(1); return ""; };
    
    public default void msg(int e) {
        String error_type[] = {
            " id ",
            " name "
        };
        System.out.println("No" + error_type[e] + "found!");
    }
    
}
