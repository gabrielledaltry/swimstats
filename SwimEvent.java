import java.sql.Array;
import java.util.ArrayList;

public class SwimEvent {
    public String Name;
    public ArrayList<SwimEventTime> Times = new ArrayList<>();

    public static ArrayList<SwimEvent> FromSwimTimes(ArrayList<SwimTime> times) {
        ArrayList<SwimEvent> EventList = new ArrayList<>();
        return EventList;
    }
}
