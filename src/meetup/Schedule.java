
package meetup;

public class Schedule {
    
    protected int id;
    protected String name;
    protected String time;
    protected String location;

    public Schedule(int i, String n, String t, String l) {
        this.id = i;
        this.name = n;
        this.time = t;
        this.location = l;
    }

}