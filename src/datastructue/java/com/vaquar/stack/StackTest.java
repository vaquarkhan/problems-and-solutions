package datastructue.java.com.vaquar.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPush() {
		
		String first="first",second="second",third="third";
		Stack<String> stack=new Stack<String>();
		
		stack.push(first);
		stack.push(second);
		stack.push(third);

		assertEquals(3,stack.size());
		assertEquals("third:second:first:",stack.list());
	}
	
	@Test
	public void testPop() {
		
		String first="first",second="second",third="third";
		Stack<String> stack=new Stack<String>();
		
		stack.push(first);
		stack.push(second);
		stack.push(third);
		
		stack.pop();

		assertEquals(2,stack.size());
		assertEquals("second:first:",stack.list());
	}

}
