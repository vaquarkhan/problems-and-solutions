package datastructue.java.com.vaquar.sorting.quick;

import static datastructue.java.com.vaquar.sorting.utils.SortUtils.generateDuplicateData;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.generateRandomData;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.isSorted;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

public class QuickSortTest {

	public static int[] input;
	@BeforeClass
	public static void setup(){
		//input=generateRandomData(10000000);
		input=generateDuplicateData(1000);
	}
	 

	@Test
	public void testQuickSortBasic() {
		QuickSortBasic sort = new QuickSortBasic();
		int[] copiedArray=Arrays.copyOf(input, input.length);
		
		long startTime = System.nanoTime();    
		sort.sort(copiedArray);
		long timeTaken = System.nanoTime() - startTime;
		
		System.out.println("Quick Sort Basic : "+ timeTaken/1000000 +" millis");
		assertTrue(isSorted(copiedArray));
	}
	
 
	@Test
	public void testQuickSort3Way() {
		QuickSort3Way sort = new QuickSort3Way();
		int[] copiedArray=Arrays.copyOf(input, input.length);
		
		long startTime = System.nanoTime();    
		sort.sort(copiedArray);
		long timeTaken = System.nanoTime() - startTime;

		System.out.println("Quick Sort 3 Way : "+timeTaken/1000000 +" millis");
		assertTrue(isSorted(copiedArray));
	}
 
	

	@Test
	public void testQuickSortDualPivot() {
		QuickSortDualPivot sort = new QuickSortDualPivot();
		int[] copiedArray=Arrays.copyOf(input, input.length);
		
		long startTime = System.nanoTime();    
		sort.sort(copiedArray);
		long timeTaken = System.nanoTime() - startTime;
		
		System.out.println("Quick Sort Dual Pivot : "+ timeTaken/1000000 +" millis");
		
		assertTrue(isSorted(copiedArray));
 
	}
	
}
