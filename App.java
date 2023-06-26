import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        String filePath = "times.csv"; 
        ArrayList<SwimTime> times = SwimTime.ReadSwimTimes(filePath);
        ArrayList<SwimEvent> events = SwimEvent.FromSwimTimes(times); 
    }
}
