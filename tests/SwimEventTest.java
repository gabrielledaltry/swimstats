package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Array;
import java.util.ArrayList;

import org.junit.Test;
import swimstats.SwimEvent;
import swimstats.SwimEventTime; 
import swimstats.SwimTime; 

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
        assertEquals(12, fastest.age); 
    }

    @Test
    public void testFirstFastest(){
        SwimEvent event = new SwimEvent(); 
        event.times.add(new SwimEventTime("14", "59.98"));
        event.times.add(new SwimEventTime("12", "1:00.05"));
        SwimEventTime fastest = event.fastestTime(); 
        assertNotNull(fastest); 
        assertEquals(event.times.get(0), fastest); 
    }

    @Test
    public void testLastFastest(){
        SwimEvent event = new SwimEvent(); 
        event.times.add(new SwimEventTime("14", "59.98"));
        event.times.add(new SwimEventTime("16", "56.98"));
        SwimEventTime fastest = event.fastestTime(); 
        assertNotNull(fastest); 
        assertEquals(event.times.get(1), fastest); 
    }

    @Test
    public void testMiddleFastest(){
        SwimEvent event = new SwimEvent(); 
        event.times.add(new SwimEventTime("14", "59.98"));
        event.times.add(new SwimEventTime("14", "56.00"));
        event.times.add(new SwimEventTime("13", "58.00"));
        SwimEventTime fastest = event.fastestTime(); 
        assertNotNull(fastest); 
        assertEquals(event.times.get(1), fastest); 
    }

    @Test
    public void testMultipleFastestShouldReturnYoungest(){
        SwimEvent event = new SwimEvent(); 
        event.times.add(new SwimEventTime("14", "59.98"));
        event.times.add(new SwimEventTime("12", "59.98"));
        SwimEventTime fastest = event.fastestTime(); 
        assertNotNull(fastest); 
        assertEquals(event.times.get(1), fastest); 
    }

    @Test
    public void testNoSwimTimesThenNoSwimEvents(){
        ArrayList<SwimTime> times = new ArrayList<SwimTime>(); 
        ArrayList<SwimEvent> events = SwimEvent.swimTimesToEvents(times); 
        assertEquals(events.size(), 0);
    }

    @Test
    public void testOneSwimTimeThenOneSwimEvent(){
        ArrayList<SwimTime> times = new ArrayList<SwimTime>();
        SwimTime t = new SwimTime("100 free", "57.84", "15", "Winter Meet");
        times.add(t);
        ArrayList<SwimEvent> events = SwimEvent.swimTimesToEvents(times);
        assertEquals(1, events.size()); 
    }

    @Test
    public void testTwoSwimTimesThenOneSwimEvent(){
        ArrayList<SwimTime> times = new ArrayList<SwimTime>();
        times.add(new SwimTime("50 free", "26.43", "14", "Fall Classic"));
        times.add(new SwimTime("50 free", "25.99", "15", "Spring Classic"));
        ArrayList<SwimEvent> events = SwimEvent.swimTimesToEvents(times);
        assertEquals(1, events.size()); 
        assertEquals(2, events.get(0).times.size()); 
    }

    @Test
    public void testTwoEvents(){
        ArrayList<SwimTime> times = new ArrayList<SwimTime>();
        times.add(new SwimTime("50 free", "26.43", "14", "Fall Classic"));
        times.add(new SwimTime("100 free", "55.89", "15", "Spring Classic"));
        ArrayList<SwimEvent> events = SwimEvent.swimTimesToEvents(times);
        assertEquals(2, events.size()); 
        assertEquals(1, events.get(0).times.size()); 
        assertEquals(1, events.get(1).times.size()); 
    }
}   