import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        String filePath = "times.csv"; 
        ArrayList<SwimTime> times = SwimTime.readSwimTimes(filePath);
        for(SwimTime t: times){
            System.out.println(t.meet);
        }
    }
}
