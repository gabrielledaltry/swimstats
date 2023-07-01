package app;
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
            } else {
                // if the event is faster (smaller) than temp, replace temp
                if (t.timeInMilliseconds() < fastest.timeInMilliseconds()) {
                    fastest = t;
                }
            }
        }
        // return temp to find the fastest time
        return fastest;
    }
}
