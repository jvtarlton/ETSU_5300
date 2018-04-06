
package view;
import java.util.*;

/**
 * This class represents the Admin subclass user type
 * @author Jim
 */
public class CarPooler extends User {
    
    
    // private members
    private final boolean car;         // indicates if user has a car
    
    
    // constructor
    protected CarPooler(int id, String name, boolean car) {
        super(id, name);
        this.car = car;
    }
    
    
    // Admin accessors
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