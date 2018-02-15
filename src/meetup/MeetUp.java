/*
 * This package illustrates the ETSU-5300 MeetUp exercise 1 assignment UML
 * included with these java class files: 
     MeetUp Class Diagram.pdf
     MeetUp Sequence Diagram 1.pdf
     MeetUp Sequence Diagram 2.pdf
 */
package meetup;
import java.util.*;
/**
 * This class is a test case for instantiating the abstract User through
 * either Admin or Student class and aggregating their corresponding 
 * subclasses into collections.
 * 
 * @author Jim Tarlton
 */
public class MeetUp {
    
    public static void main(String[] args) {
        
        // User data literals
        // template array for UI, accepts Admin and Students
        populateUI(
                
            initializeUI(
                    
                new ArrayList<>(

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
                                Schedule.make(1, "CSCI-1100", "2/2/18 10:00 AM", "Gilbreath Hall"),
                                Schedule.make(2, "CSCI-1200", "2/3/18 11:15 AM", "Nicks Hall")
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
                                Schedule.make(1, "CSCI-1100", "2/2/18 10:00 AM", "Gilbreath Hall"),
                                Schedule.make(2, "CSCI-1300", "2/3/18 12:00 PM", "Nicks Hall")
                            )
                        ),

                        // User type Student
                        User.make(
                            1003, "Dan", true, true,
                            Arrays.asList(
                                Friend.make(1001, false)
                            ),
                            Arrays.asList(
                                Schedule.make(1, "ENG-4400", "2/3/18", "Sherrod Library")
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
                                Schedule.make(1, "ENG-4400", "2/3/18", "Sherrod Library")
                            )
                        )
                    )
                )

            // initalize and populate UI
            )
        );
        
    }
    
    // initalize UI
    public static ArrayList<User> initializeUI(ArrayList<User> data) {
        data.forEach((d) -> {
            // manifest UI data
            if (d.getClass().getSimpleName().equals("Admin")) {
                // synchronize admin information here
                ((Admin)d).setStudentCount(data);
            } else {
                // synchronize student messages, schedules, etc. here
                ((Student)d).findScheduleMatches();
            }
        });
        return data;
    }
    
    // populate UI
    public static void populateUI(ArrayList<User> data) {
        // print UI
        data.forEach((d) -> {
            System.out.println(d.toString());
        });
    }
    
}


