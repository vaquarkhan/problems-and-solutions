package datastructue.java.com.vaquar.sorting.quick;

import static datastructue.java.com.vaquar.sorting.utils.SortUtils.generateDuplicateData;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.generateRandomData;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.isSorted;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

public class QuickSortTracingEnabledTest {

	public static int[] input;
	@BeforeClass
	public static void setup(){
		input=generateRandomData(10);
		//input=generateDuplicateData(10);
	}
	 

	@Test
	public void testQuickSortBasic() {
		QuickSortBasicTracingEnabled sort = new QuickSortBasicTracingEnabled();
		int[] copiedArray=Arrays.copyOf(input, input.length);
		
		long startTime = System.nanoTime();    
		sort.sort(copiedArray);
		long timeTaken = System.nanoTime() - startTime;
		
		System.out.println("Quick Sort Basic : "+ timeTaken/1000000 +" millis");
		assertTrue(isSorted(copiedArray));
	}
	
 
	//@Test
	public void testQuickSort3Way() {
		QuickSort3WayTracingEnabled sort = new QuickSort3WayTracingEnabled();
		int[] copiedArray=Arrays.copyOf(input, input.length);
		
		long startTime = System.nanoTime();    
		sort.sort(copiedArray);
		long timeTaken = System.nanoTime() - startTime;

		System.out.println("Quick Sort 3 Way : "+timeTaken/1000000 +" millis");
		assertTrue(isSorted(copiedArray));
	}
 
	

	//@Test
	public void testQuickSortDualPivot() {
		QuickSortDualPivotTracingEnabled sort = new QuickSortDualPivotTracingEnabled();
		int[] copiedArray=Arrays.copyOf(input, input.length);
		
		long startTime = System.nanoTime();    
		sort.sort(copiedArray);
		long timeTaken = System.nanoTime() - startTime;
		
		System.out.println("Quick Sort Dual Pivot : "+ timeTaken/1000000 +" millis");
		assertTrue(isSorted(copiedArray));
 
	}
	
}
