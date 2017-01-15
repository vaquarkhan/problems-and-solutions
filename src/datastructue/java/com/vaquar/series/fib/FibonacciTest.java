package datastructue.java.com.vaquar.series.fib;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

	Fibonacci fib=null;
	@Before
	public void setUp() throws Exception {
		fib=new Fibonacci();
	}

	@Test
	public void fibRecur() {
		assertEquals(5,fib.fibRecur(5));
	}

	@Test
	public void fibIter() {
		assertEquals(5,fib.fibIter(5));
	}
}
