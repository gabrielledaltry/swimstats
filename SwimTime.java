import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SwimTime {
    public String Event;
    public String Time;
    public String Age;

    public static ArrayList<SwimTime> ReadSwimTimes(String filePath){
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
                time.Event = parts[0]; 
                time.Age = parts[3]; 
                time.Time = parts[1]; 
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