package datastructue.java.com.vaquar.lists.dbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void insertBefore() {
		
		LinkedList list=new LinkedList();
		list.insertBefore("223");
		list.insertBefore("77662");
		list.insertBefore("23");
		
		assertEquals("23:77662:223:",list.list());
		assertEquals(3,list.size());
		
		
	}
	
	@Test
	public void insertAfter() {
		
		LinkedList list=new LinkedList();
		list.insertAfter("223");
		list.insertAfter("77662");
		list.insertAfter("23");
		
		assertEquals("223:77662:23:",list.list());
		assertEquals(3,list.size());
		
		
	}

}
