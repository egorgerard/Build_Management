package de.hfu;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {
    @Test
    public void testQueue(){
        Queue q = new Queue(2);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        assertTrue("Sollte 10 Herauswerfen", q.dequeue() == 10);
        assertTrue("Sollte die 30 auswerfen ", q.dequeue() == 30);
    }
}

