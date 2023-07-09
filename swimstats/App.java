package swimstats;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        String filePath = "times.csv"; 
        ArrayList<SwimTime> times = SwimTime.readSwimTimes(filePath);

        // convert from swim times to swim events 
        ArrayList<SwimEvent> events = SwimEvent.swimTimesToEvents(times);

        for(SwimEvent e: events){
            System.out.print(e.name+"\t");
            SwimEventTime fastest = e.fastestTime();
            System.out.printf("%s\t %s\t %s\t %s\n", fastest.time, fastest.age, fastest.date, fastest.meet);
        }
    }
}
