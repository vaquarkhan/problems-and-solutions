package datastructue.java.com.vaquar.queue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEnqueue() {
		
		String first="first",second="second",third="third";
		Queue<String> queue=new Queue<String>();
		queue.enqueue(first);
		queue.enqueue(second);
		queue.enqueue(third);

		assertEquals(3,queue.size());
		assertEquals("first:second:third:",queue.list());
	}
	
	@Test
	public void testDeque() {
		String first="first",second="second",third="third";
		Queue<String> queue=new Queue<String>(); 
		queue.enqueue(first);
		queue.enqueue(second);
		queue.enqueue(third);
		
		queue.dequeue();
		
		assertEquals(2,queue.size());
		assertEquals("second:third:",queue.list());
	}

}
