/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.ArrayList;
import java.util.Arrays;

// for demo
import view.User;
import view.Factory;

/**
 * The User objects would then be instantiated in the
 * Connection.parseData() method for instantiating
 * User objects here for now.
 * @author Jim
 */
public class DBO  implements Factory {
    
    // Stream buffer for database communication
    private String buffer;

    // represents data object
    public DBO() {}
    
    // represents data stream
    public ArrayList<User> getData() {
        
        return  new ArrayList<>(
                
            Arrays.asList(
                
                // User type Admin
                Factory.User(1000, "Andy"),
                
                // User type Student
                Factory.User(
                    1001, "Bob", false, false, 
                    Arrays.asList(
                        Factory.Friend(1002, false),
                        Factory.Friend(1003, false),
                        Factory.Friend(1004, false)
                    ),
                    Arrays.asList(
                        Factory.Schedule(1, "CSC-1100", "SPRING 2018 MWF 10:00 AM", "Gilbreath Hall"),
                        Factory.Schedule(2, "CSC-1300", "SPRING 2018 TTh 12:00 PM", "Dr Nicks Hall")
                    )
                ),

                // User type Student
                Factory.User(
                    1002, "Carl", true, false,
                    Arrays.asList(
                        Factory.Friend(1001, false),
                        Factory.Friend(1003, true)
                    ),
                    Arrays.asList(
                        Factory.Schedule(1, "CSC-1100", "SPRING 2018 MWF 10:00 AM", "Gilbreath Hall"),
                        Factory.Schedule(2, "CSC-1200", "SPRING 2018 TTh  11:15 AM", "Dr Nicks Hall"),
                        Factory.Schedule(3, "CSC-1300", "SPRING 2018 TTh 12:00 PM", "Dr Nicks Hall"),
                        Factory.Schedule(4, "ENG-5400", "SPRING 2018 F 07:00 PM", "Sherrod Library")
                    )
                ),

                // User type Student
                Factory.User(
                    1003, "Dan", true, true,
                    Arrays.asList(
                        Factory.Friend(1001, false)
                    ),
                    Arrays.asList(
                        Factory.Schedule(1, "ENG-2500", "SPRING 2018 W 03:00 PM", "Gilbreath Hall"),
                        Factory.Schedule(2, "ENG-5400", "SPRING 2018 F 07:00 PM", "Sherrod Library")
                    )
                ),

                // User type Student
                Factory.User(
                    1004, "Eric", true, true,
                    Arrays.asList(
                        Factory.Friend(1002, false),
                        Factory.Friend(1003, false)
                    ),
                    Arrays.asList(
                        Factory.Schedule(1, "ENG-2500", "SPRING 2018 W 03:00 PM", "Gilbreath Hall"),
                        Factory.Schedule(2, "CSC-1300", "SPRING 2018 TTh 12:00 PM", "Lineberger Hall")
                    )
                )
                 
            )
            
        );
         
    }

}
