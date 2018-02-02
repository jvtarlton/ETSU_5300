/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetup;

/**
 *
 * @author Jim
 */
public class Schedule {
    int id;
    String name;
    String time;
    String location;

    public Schedule(int i, String n, String t, String l) {
        this.id = i;
        this.name = n;
        this.time = t;
        this.location = l;
    }

}