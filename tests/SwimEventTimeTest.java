package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import swimstats.SwimEventTime;

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
    @Test
    public void testMinute(){
        SwimEventTime t = new SwimEventTime(); 
        t.time = "1:00.00"; 
        int actual = t.timeInMilliseconds(); 
        assertEquals(60000, actual);
    }
    @Test
    public void testOverMinute(){
        SwimEventTime t = new SwimEventTime(); 
        t.time = "1:01.35"; 
        int actual = t.timeInMilliseconds(); 
        assertEquals(61035, actual);
    }
}
