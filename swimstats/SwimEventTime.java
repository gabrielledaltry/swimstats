package swimstats;
public class SwimEventTime {
    public int age;
    public String time;

    public SwimEventTime(){}

    public SwimEventTime (String age, String time){
        this.age = Integer.parseInt(age);
        this.time = time; 
    }

    public int timeInMilliseconds() {
        String[] timeParts = time.split(":");
        int minutes = 0; 
        String secondsAndMilliseconds; 
        if (timeParts.length > 1){
            minutes = Integer.parseInt(timeParts[0]);
            secondsAndMilliseconds = timeParts[1];
        }
        else {
            secondsAndMilliseconds = timeParts[0];
        }
        String[] secondsAndMillisecondsParts = secondsAndMilliseconds.split("\\.");
        int seconds = Integer.parseInt(secondsAndMillisecondsParts[0]);
        int milliseconds = Integer.parseInt(secondsAndMillisecondsParts[1]);

        // Convert the time components into a single value (milliseconds)
        int totalTimeInMilliseconds = (minutes * 60 * 1000) + (seconds * 1000) + milliseconds;
        return totalTimeInMilliseconds; 
    }
}
