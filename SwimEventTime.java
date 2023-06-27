public class SwimEventTime {
    public String age;
    public String time;

    public int timeInMilliseconds() {
        String[] parts = time.split(":");
        int minutes = 0; 
        if (parts.length > 1){
            minutes = Integer.parseInt(parts[0]);
        }
        String[] secondsAndMilliseconds; 
        if (parts.length == 1){
            secondsAndMilliseconds = parts[0].split("\\.");
        }
        else{
            secondsAndMilliseconds = parts[1].split("\\.");
        }
        int seconds = Integer.parseInt(secondsAndMilliseconds[0]);
        int milliseconds = Integer.parseInt(secondsAndMilliseconds[1]);

        // Convert the time components into a single value (milliseconds)
        int totalTimeInMilliseconds = (minutes * 60 * 1000) + (seconds * 1000) + milliseconds;
        return totalTimeInMilliseconds; 
    }
}
