package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import swimstats.SwimEvent;
import swimstats.SwimEventTime; 

public class SwimEventTest {
    @Test
    public void testNoTimes(){
        SwimEvent event = new SwimEvent(); 
        SwimEventTime t = event.fastestTime(); 
        assertNull(t);
    }

    @Test
    public void testOneTime(){
        SwimEvent event = new SwimEvent(); 
        event.times.add(new SwimEventTime("12", "1:00.03"));
        SwimEventTime fastest = event.fastestTime(); 
        assertNotNull(fastest);
        assertEquals(event.times.get(0), fastest);
    }

    @Test
    public void testOneTimeValues(){
        SwimEvent event = new SwimEvent(); 
        event.times.add(new SwimEventTime("12", "1:00.03"));
        SwimEventTime fastest = event.fastestTime(); 
        assertNotNull(fastest);
        assertEquals("1:00.03", fastest.time);
        assertEquals("12", fastest.age); 
    }
}
