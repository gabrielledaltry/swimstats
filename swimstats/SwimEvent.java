package swimstats;
import java.util.ArrayList;

public class SwimEvent {
    public String name;
    public ArrayList<SwimEventTime> times = new ArrayList<>();

    public SwimEventTime fastestTime() {
        // create temp variable
        SwimEventTime fastest = null;
        // compare the temp variable to the next time in the list
        for (SwimEventTime t : times) {
            if (fastest == null) {
                fastest = t;
            } 
            else {
                int tInMil = t.timeInMilliseconds(); 
                int fastestInMil = fastest.timeInMilliseconds();
                // if the event is faster (smaller) than temp, replace temp
                if (tInMil < fastestInMil) {
                    fastest = t;
                }
                else if (fastestInMil == tInMil && fastest.age > t.age){
                    fastest = t; 
                }
            }
        }
        // return temp to find the fastest time
        return fastest;
    }
}
