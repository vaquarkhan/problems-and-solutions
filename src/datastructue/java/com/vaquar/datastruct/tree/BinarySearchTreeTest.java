package datastructue.java.com.vaquar.datastruct.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

	BinarySearchTree<Integer, Integer> tree=null;
	@Before
	public void setUp() throws Exception {
		tree=new BinarySearchTree<Integer,Integer>();
		populateData();
	}

	
	@Test
	public void testPut() {
		
		System.out.println(tree.toString());
		tree.put(500, 501);
		assertEquals(new Integer(501), tree.get(500));
		
	}

	@Test
	public void testGet() {
		
		assertEquals(new Integer(11), tree.get(11));
		assertNull(tree.get(121));
		
	}
	
	@Test
	public void testMax(){
		assertEquals (new Integer(14), tree.max());
		assertNull(new BinarySearchTree<Integer, Integer>().max());
	}


	@Test
	public void testMin(){
		assertEquals (new Integer(1), tree.min());
		assertNull(new BinarySearchTree<Integer, Integer>().min());
	}
	
	@Test
	public void testFloor(){
		assertEquals (new Integer(1), tree.floor(1));
		assertEquals (new Integer(12), tree.floor(13));
	}
	
	private void populateData() {
		tree.put(3, 3);
		tree.put(1, 1);
		tree.put(12, 12);
		tree.put(11, 11);
		tree.put(14, 14);
		tree.put(7, 7);
	}

	@Test 
	public void testSize(){
		BinarySearchTree<Integer, Integer> tempTree=new BinarySearchTree<Integer, Integer>();
		tempTree.put(1, 1);
		assertEquals(1, tempTree.size());
		
		assertEquals(6,tree.size());
	}
	
	@Test 
	public void testRank(){
		System.out.println(tree.rank(3));
		System.out.println(tree.rank(14));
	}
}
