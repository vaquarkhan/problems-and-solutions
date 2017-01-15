package datastructue.java.com.vaquar.lists.single;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testInsert() {
		LinkedList list=new LinkedList();
		list.insert(223);
		list.insert(77662);
		list.insert(23);
		
		assertEquals("223:77662:23:",list.list());
		assertEquals(3,list.size());
	}
	
	@Test
	public void testSearch(){
		
		LinkedList list=new LinkedList();
		list.insert(223);
		list.insert(77662);
		list.insert(23);
		
		
		assertEquals(23,list.search(3).value);
		
	}
	
	@Test
	public void testSearchByValue(){
		
		LinkedList list=new LinkedList();
		list.insert(223);
		list.insert(77662);
		list.insert(23);
		
		
		assertEquals(23,list.searchByValue(23).value);
		
	}
	
	@Test
	public void testDelete(){
		
		LinkedList list=new LinkedList();
		list.insert(223);
		list.insert(77662);
		list.insert(23);
		
		
		list.delete(23);
		assertEquals("223:77662:",list.list());
		assertEquals(2,list.size());
		list.delete(77662);
		assertEquals("223:",list.list());
		assertEquals(1,list.size());
		list.delete(223);
		assertEquals("",list.list());
		assertEquals(0,list.size());
		
	}

}
