
import static org.junit.Assert.*;
import org.junit.Test;


public class SwimEventTimeTest {
    @Test
    public void testNoTime(){
        SwimEventTime t = new SwimEventTime(); 
        t.time = "0:00.00";
        int actual = t.timeInMilliseconds(); 
        assertEquals(0, actual);  
    }
    @Test
    public void testSubMinute(){
        SwimEventTime t = new SwimEventTime(); 
        t.time = "25.14";
        int actual = t.timeInMilliseconds(); 
        assertEquals(25014, actual); 

    }
}
