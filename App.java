import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;

public class App {
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

    public static void main(String[] args) {
        String filePath = "times.csv"; 
        ArrayList<SwimTime> times = ReadSwimTimes(filePath);
        for (SwimTime t: times){
                System.out.printf("%s\t\t%s\t\t%s\n", t.Event, t.Time, t.Age);
            }
    }
}
