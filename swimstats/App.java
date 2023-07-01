package swimstats;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        String filePath = "times.csv"; 
        ArrayList<SwimTime> times = SwimTime.readSwimTimes(filePath);

        // TODO: convert from swim times to swim events with swim event times
        // ...

        for(SwimTime t: times){
            System.out.println(t.meet);
        }
    }
}
