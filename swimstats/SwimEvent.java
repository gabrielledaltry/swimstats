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

    public static ArrayList<SwimEvent> swimTimesToEvents(ArrayList<SwimTime> times){
        ArrayList<SwimEvent> events = new ArrayList<SwimEvent>(); 
        // take a list of swim events and turn them into a list of swim times
        // for each time 
        for(SwimTime s: times){
            SwimEvent found = null; 
            // try to get the event
            for(SwimEvent e: events){
                if(e.name.equals(s.event))
                {
                    found = e; 
                    break; 
                }
            }
            // if no event was found
            if (found == null){
                // then create a new event with that name
                found = new SwimEvent(); 
                found.name = s.event; 
                events.add(found);
            }
            // add the time to the event
            found.times.add(new SwimEventTime(s.age, s.time));
        }
        return events;  
    }
}
