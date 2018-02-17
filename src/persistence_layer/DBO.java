/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence_layer;
import java.util.ArrayList;
import java.util.Arrays;

// for demo
import presentation_layer.Friend;
import presentation_layer.Schedule;
import presentation_layer.User;

/**
 * If actual, live REST endpoint was established, getData() would
 * return a JSON blob as a string; thus, no presentation_layer imports
 * would be needed. The User objects would then be instantiated in the
 * Connection.parseData() method. I've simplified the demo by instantiating
 * User objects here for now.
 * @author Jim
 */
public class DBO {
    
    private String buffer;

    // represents data object
    public DBO() {}
    
    public ArrayList<User> getData() {
        
        return  new ArrayList<>(
                
            Arrays.asList(
                
                // User type Admin
                User.make(1000, "Andy"),
                
                // User type Student
                User.make(
                    1001, "Bob", false, false, 
                    Arrays.asList(
                        Friend.make(1002, false),
                        Friend.make(1003, false),
                        Friend.make(1004, false)
                    ),
                    Arrays.asList(
                        Schedule.make(1, "CSCI-1100", "SPRING 2018 MWF 10:00 AM", "Gilbreath Hall"),
                        Schedule.make(2, "CSCI-1300", "SPRING 2018 TTh 12:00 PM", "Nicks Hall")
                    )
                ),

                // User type Student
                User.make(
                    1002, "Carl", true, false,
                    Arrays.asList(
                        Friend.make(1001, false),
                        Friend.make(1003, true)
                    ),
                    Arrays.asList(
                        Schedule.make(1, "CSCI-1100", "SPRING 10:00 AM", "Gilbreath"),
                        Schedule.make(2, "CSCI-1200", "SPRING 2018 TTh  11:15 AM", "Nicks Hall"),
                        Schedule.make(3, "CSCI-1300", "SPRING 2018 TTh 12:00 PM", "Nicks Hall"),
                        Schedule.make(4, "ENG-5400", "SPRING 2018 F 07:00 PM", "Sherrod")
                    )
                ),

                // User type Student
                User.make(
                    1003, "Dan", true, true,
                    Arrays.asList(
                        Friend.make(1001, false)
                    ),
                    Arrays.asList(
                        Schedule.make(1, "ENG-2500", "SPRING 2018 W 03:00 PM", "Gilbreath"),
                        Schedule.make(2, "ENG-5400", "SPRING 2018 F 07:00 PM", "Sherrod")
                    )
                ),

                // User type Student
                User.make(
                    1004, "Eric", true, true,
                    Arrays.asList(
                        Friend.make(1002, false),
                        Friend.make(1003, false)
                    ),
                    Arrays.asList(
                        Schedule.make(1, "ENG-2500", "SPRING 2018 W 03:00 PM", "Gilbreath"),
                        Schedule.make(2, "CSCI-1300", "SPRING 2018 TTh 12:00 PM", "Lineberger")
                    )
                )
                 
            )
            
        );
         
    }

}
