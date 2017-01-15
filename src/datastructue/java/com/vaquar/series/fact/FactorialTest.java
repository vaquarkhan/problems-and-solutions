package datastructue.java.com.vaquar.series.fact;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FactorialTest {

	Factorial fact=null;
	@Before
	public void setUp() throws Exception {
		fact=new Factorial();
	}

	@Test
	public void testFibRecur() {
		assertEquals(120, fact.factRecur(5));
		
	}

	@Test
	public void testFibIter() {
		assertEquals(120, fact.factIter(5));
	}

}
