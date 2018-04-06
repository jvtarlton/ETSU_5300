
package model;

/**
 * This class is a Student aggregate class
 */
public class Course {
    
    // protected members
    private int id;
    private String name;
    private String time;
    private String location;
    
    // constructor
    public Course(int id, String name, String time, String location) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.location = location;
    }
    
    // Course accessors
    public int getID() { return this.id; }
    public String getName() { return this.name; }
    public String getTime() { return this.time; }
    public String getLocation() { return this.location; }
    
    // toString to print schedule item
    @Override public String toString() {
        return "\t" + 
            this.id + " -- " + 
            this.name + " on " + 
            this.time + " at " + 
            this.location;
    }
    
}