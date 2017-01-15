package datastructue.java.com.vaquar.sorting.quick;

import static datastructue.java.com.vaquar.sorting.utils.SortUtils.addToTracer;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.cleanupArray;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.exchange;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.insertBreak;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.intArrayToString3Space;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.less;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.traceArrayToString3Space;
import datastructue.java.com.vaquar.shuffle.KnuthShuffle;

/**
 * 
 * 
 * Exchanges values which are equal to pivot. Bad Bad
 *
 */
public class QuickSortBasicTracingEnabled {

	public void sort (int[] input){
		
		KnuthShuffle.shuffle(input);
		sort (input, 0, input.length-1);
	}

	private void sort(int[] input, int lowIndex, int highIndex) {

		if (highIndex<=lowIndex){
			return;
		}
		
		int partIndex=partition (input, lowIndex, highIndex);

		sort (input, lowIndex, partIndex-1);
		sort (input, partIndex+1, highIndex);
	}

	private int partition(int[] input, int lowIndex, int highIndex) {
		
		int i=lowIndex;
		int pivotIndex=lowIndex;
		int j=highIndex+1;
		
		System.out.println("\n");
		insertBreak(input.length);
		System.out.println("\nPivot : "+input[pivotIndex]);
		
		while (true){
			
			while (less(input[++i], input[pivotIndex])){
				if (i==highIndex) break;
			}
			
			while (less (input[pivotIndex], input[--j])){
				if (j==lowIndex) break;
			}
				
			if (i>=j) {
				System.out.println("i and j crosses");
				break;
			}
			
			System.out.println(intArrayToString3Space(input));
			trace(lowIndex, highIndex, i, pivotIndex, j, input.length);
			System.out.println(input[i] + " is > pivot. Exchange with member lesser than pivot value from the " +
					"right side. Exchanging "+input[i] +" & " + input[j]);
			exchange(input, i, j);
			
			System.out.println(intArrayToString3Space(input));
			trace(lowIndex, highIndex, i, pivotIndex, j, input.length);
			
		}
		
		System.out.println(intArrayToString3Space(input));
		trace(lowIndex, highIndex, i, pivotIndex, j, input.length);
		
		System.out.println("Restoring Pivot. Exchanging "+input[pivotIndex] +" & " +input[j] +" (at position j)");
		exchange(input, pivotIndex, j);
		
		return j;
	}
	
	public static void trace(int lowIndex, int highIndex, int i, int pivotIndex, int j, int inputLength) {
		
		String[] tracer=new String[inputLength+1];
		tracer=cleanupArray(tracer);
		addToTracer(tracer,i,"i");
		addToTracer(tracer, pivotIndex,"p");
		addToTracer(tracer,lowIndex,"{");
		addToTracer(tracer,highIndex,"}");
		addToTracer(tracer,j,"j");
		
		System.out.println(traceArrayToString3Space(tracer));
		insertBreak(tracer.length);
		System.out.println();
	}

	
}
