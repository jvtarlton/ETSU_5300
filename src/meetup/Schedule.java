
package meetup;

/**
 * This class is a Student aggregate class
 * @author Jim
 */
public class Schedule {
    
    // protected members
    protected int id;
    protected String name;
    protected String time;
    protected String location;

    // constructor
    public Schedule(int i, String n, String t, String l) {
        this.id = i;
        this.name = n;
        this.time = t;
        this.location = l;
    }
    
    // factory method
    static Schedule make(int i, String n, String t, String l) {
        return new Schedule(i, n, t, l); 
    }
    
    // toString to print schedule item
    @Override
    public String toString() {
        return "\n\t" + name + " on " + time + " at " + location + "\n";
    }
    
    
}