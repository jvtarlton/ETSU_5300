
package presentation_layer;

/**
 * This class is a Student aggregate class
 * @author Jim
 */
public class Schedule {
    
    // protected members
    private int id;
    private String name;
    private String time;
    private String location;

    // constructor
    public Schedule(int id, String name, String time, String location) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.location = location;
    }
    
    // factory method
    public static Schedule make(
            int id, 
            String name, 
            String time, 
            String location
    ) {
        return new Schedule(id, name, time, location); 
    }
    
    protected int getID() { return this.id; }
    protected String getName() { return this.name; }
    protected String getTime() { return this.time; }
    protected String getLocation() { return this.location; }
    
    // toString to print schedule item
    @Override public String toString() {
        return "\t" + 
            this.id + " -- " + 
            this.name + " on " + 
            this.time + " at " + 
            this.location;
    }
    
}