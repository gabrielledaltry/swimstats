import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String line;
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader("times.csv"));
            line = reader.readLine();
            while (line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
