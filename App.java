import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String filePath = "times.csv"; 
        String line;
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
