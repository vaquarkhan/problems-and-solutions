package datastructue.java.com.vaquar.sorting.heap;

import static datastructue.java.com.vaquar.sorting.utils.SortUtils.arrayToString;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.generateRandomData;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.isSorted;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import datastructue.java.com.vaquar.sorting.utils.SortUtils;


public class HeapSortTest {
	
	public static int[] input;
	@BeforeClass
	public static void setup(){
		input=generateRandomData(10);
		//input=new int[]{8,6,8,2,5,4,5,1,12,4};
	}
	 

	@Test
	public void testHeapSort() {
		HeapSort sort = new HeapSort();
		int[] copiedArray=Arrays.copyOf(input, input.length);
		
		long startTime = System.nanoTime();    
		sort.sort(copiedArray);
		long timeTaken = System.nanoTime() - startTime;
		
		System.out.println("Heap Sort : "+ timeTaken/1000000 +" millis");
		System.out.println("sorted array : "+arrayToString(copiedArray));
		assertTrue(isSorted(copiedArray));
	}
	
	
	
	@Test 
	public void testIsHeapOrdered(){
		assertFalse(SortUtils.isHeap(new int[]{8,6,8,2,5,4,5,1,12,4}, 0));
		assertTrue(SortUtils.isHeap(new int[]{12,8,8,6,5,4,5,1,2,4}, 0));
	}
 

}
