import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String filePath = "times.csv"; 
        BufferedReader reader = null;

        try{
            ArrayList<SwimTime> times = new ArrayList<>();
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                SwimTime time = new SwimTime(); 
                time.Event = parts[0]; 
                times.add(time);
            }
            System.out.println(times.size());
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
    }
}
