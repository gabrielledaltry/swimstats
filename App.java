import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        String filePath = "times.csv"; 
        ArrayList<SwimTime> times = SwimTime.ReadSwimTimes(filePath);
        for (SwimTime t: times){
                System.out.printf("%s\t\t%s\t\t%s\n", t.Event, t.Time, t.Age);
        }
    }
}
