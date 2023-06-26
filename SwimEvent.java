import java.util.ArrayList;

public class SwimEvent {
    public String name;
    public ArrayList<SwimEventTime> times = new ArrayList<>();

    public static ArrayList<SwimEvent> fromSwimTimes(ArrayList<SwimTime> times) {
        ArrayList<SwimEvent> eventList = new ArrayList<>();
        return eventList;
    }
}
