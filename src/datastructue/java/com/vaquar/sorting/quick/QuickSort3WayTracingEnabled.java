package datastructue.java.com.vaquar.sorting.quick;

import static datastructue.java.com.vaquar.shuffle.KnuthShuffle.shuffle;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.addToTracer;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.cleanupArray;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.exchange;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.insertBreak;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.intArrayToString3Space;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.less;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.traceArrayToString3Space;

public class QuickSort3WayTracingEnabled {
	
	
	public void sort (int[] input){
		input=shuffle(input);
		sort (input, 0, input.length-1);
	}

	public void sort(int[] input, int lowIndex, int highIndex) {
		
		
		if (highIndex<=lowIndex) return;
		
		int lt=lowIndex;
		int gt=highIndex;
		int i=lowIndex+1;
		
		int pivotIndex=lowIndex;
		int pivotValue=input[pivotIndex];
		
		System.out.println("\n");
		insertBreak(input.length);
		System.out.println("\nPivot : "+pivotValue);
		
		System.out.println(intArrayToString3Space(input));
		trace(lowIndex, highIndex, i, pivotIndex, lt, gt, input.length);
		
		while (i<=gt){
			
			
			if (less(input[i],pivotValue)){
				System.out.println(input[i] + " is < pivot. Exchange "+input[i] +" with " + input[lt] + " and increment both markers ");
				
				exchange(input, i++, lt++);
				
				System.out.println(intArrayToString3Space(input));
				trace(lowIndex, highIndex, i, pivotIndex, lt, gt, input.length);
			}
			else if (less (pivotValue, input[i])){
				
				System.out.println(pivotValue + " is < "+input[i]+". Exchange "+input[i] +" with " + input[gt] + " and decrement gt");
				exchange(input, i, gt--);
				
				System.out.println(intArrayToString3Space(input));
				trace(lowIndex, highIndex, i, pivotIndex, lt, gt, input.length);
			}
			else{
				
				System.out.println(input[i] + " is = pivotValue. Just increment i");
				i++;
				
				System.out.println(intArrayToString3Space(input));
				trace(lowIndex, highIndex, i, pivotIndex, lt, gt, input.length);
			}
				
			
		}
		
		System.out.println("< and > crossed.  Sorting the left and right of the pivot");
		
		sort (input, lowIndex, lt-1);
		sort (input, gt+1, highIndex);
		
	}
	
	
	public static void trace(int lowIndex, int highIndex, int i, int pivotIndex, int lt, int gt, int length) {
		
		String[] tracer=new String[length+1];
		tracer=cleanupArray(tracer);
		addToTracer(tracer,i,"i");
		addToTracer(tracer, pivotIndex,"p");
		addToTracer(tracer,lowIndex,"{");
		addToTracer(tracer,highIndex,"}");
		addToTracer(tracer,lt,"<");
		addToTracer(tracer,gt,">");
		
		System.out.println(traceArrayToString3Space(tracer));
		insertBreak(tracer.length);
		System.out.println();
	}


}
