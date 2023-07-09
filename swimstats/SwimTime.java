package swimstats;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SwimTime {
    public String event;
    public String time;
    public String age;
    public String meet; 

    public SwimTime(){}

    public SwimTime(String event, String time, String age, String meet){
        this.event = event; 
        this.time = time;
        this.age = age;
        this.meet = meet; 
    }

    public static ArrayList<SwimTime> readSwimTimes(String filePath){
        ArrayList<SwimTime> times = new ArrayList<>();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            // Read and discard the header line
            reader.readLine();
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                SwimTime time = new SwimTime(); 
                time.event = parts[0]; 
                time.age = parts[3]; 
                time.time = parts[1]; 
                time.meet = parts[6]; 
                times.add(time);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        finally{
            if (reader != null){
                try{
                    reader.close();
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return times; 
    }
}