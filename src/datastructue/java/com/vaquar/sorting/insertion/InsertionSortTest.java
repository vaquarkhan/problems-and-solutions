package datastructue.java.com.vaquar.sorting.insertion;

import static datastructue.java.com.vaquar.sorting.utils.SortUtils.arrayToString;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InsertionSortTest {


	@Test
	public void testInsertionSort() {
		
		String arun="arun",nancy="nancy",jason="jason",daisy="daisy", dani="dani";
		InsertionSort sort=new InsertionSort();
		Comparable[] sortedArray = sort.sort(new String[]{arun,nancy,jason, dani, daisy});
		
		assertEquals("arun:daisy:dani:jason:nancy:",arrayToString(sortedArray));
	}
}
