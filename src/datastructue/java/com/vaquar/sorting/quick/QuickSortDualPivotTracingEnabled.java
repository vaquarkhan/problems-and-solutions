package datastructue.java.com.vaquar.sorting.quick;

import static datastructue.java.com.vaquar.shuffle.KnuthShuffle.shuffle;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.addToTracer;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.cleanupArray;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.exchange;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.insertBreak;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.intArrayToString3Space;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.isSorted;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.less;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.traceArrayToString3Space;
import static org.junit.Assert.assertTrue;

public class QuickSortDualPivotTracingEnabled {
	
	public void sort (int[] input){
		input=shuffle(input);
		sort (input, 0, input.length-1);
		//assertTrue(isSorted(input));
	}

	private void sort(int[] input, int lowIndex, int highIndex) {

		if (highIndex<=lowIndex) return;
		
		//System.out.println("LowIndex/HighIndex :"+lowIndex+"/"+highIndex);
		int pivot1=input[lowIndex];
		int pivot2=input[highIndex];
		
		System.out.println("\n");
		insertBreak(input.length);
		System.out.println("\nPivot 1 ="+pivot1 +"  &  Pivot 2 ="+pivot2);
		
		System.out.println("Input : " +intArrayToString3Space(input));
		System.out.println("\n");
		insertBreak(input.length);
		System.out.println();
		
		
		if (pivot1>pivot2){
			exchange(input, lowIndex, highIndex);
			pivot1=input[lowIndex];
			pivot2=input[highIndex];
			//sort(input, lowIndex, highIndex);
			System.out.println("Pivot 1 is > Pivot 2. Swapping...");
			System.out.println("\n");
			insertBreak(input.length);
			System.out.println("\nPivot 1 ="+pivot1 +"  &  Pivot 2 ="+pivot2);
		}
		else if (pivot1==pivot2){
			
			while (pivot1==pivot2 && lowIndex<highIndex){
				lowIndex++; 
				pivot1=input[lowIndex];
			}
			
			System.out.println("Pivot 1 and 2 are the same. Fastwarding lowIndex until pivots are different. Low Index is now -  "+lowIndex);
		}
		

		int i=lowIndex+1;
		int lt=lowIndex+1;
		int gt=highIndex-1;
		
		System.out.println(intArrayToString3Space(input));
		trace(lowIndex, highIndex, i, lt, gt, input.length);
		
		while (i<=gt){
			
			if (less(input[i], pivot1)){
				
				System.out.println(input[i] + " is < Pivot 1 ("+ pivot1 +"). Exchange "+input[i] +" with " + input[lt] + " and increment both markers ");
				exchange(input, i++, lt++);
				
				System.out.println(intArrayToString3Space(input));
				trace(lowIndex, highIndex, i, lt, gt, input.length);
			}
			else if (less(pivot2, input[i])){
				
				System.out.println("Pivot 2 (" +pivot2 +") is < "+input[i]+". Exchange "+input[i] +" with " + input[gt] + " and decrement gt");
				exchange(input, i, gt--);
				
				System.out.println(intArrayToString3Space(input));
				trace(lowIndex, highIndex, i, lt, gt, input.length);
			}
			else{
				System.out.println(input[i] + " is between Pivot 1 and 2 ("+ pivot1+ " & " + pivot2 + "). Just increment i");
				i++;
				
				System.out.println(intArrayToString3Space(input));
				trace(lowIndex, highIndex, i, lt, gt, input.length);
			}
			
		}
		
		//System.out.println(arrayToString(input));
		//System.out.println("Swapping after loop : "+lowIndex +" & "+lt);
		System.out.println("Restoring Pivot 1 and 2 to their positions (lt-1 and gt +1)");
		exchange(input, lowIndex, --lt);
		exchange(input, highIndex, ++gt);
		
		System.out.println(intArrayToString3Space(input));
		trace(lowIndex, highIndex, i, lt, gt, input.length);
		
		
		sort(input, lowIndex, lt-1);
		//if (less (input[lt], input[gt])) sort (input, lt+1, gt-1);
		sort (input, lt+1, gt-1);
		sort(input, gt+1, highIndex);
			
		assertTrue(isSorted(input, lowIndex, highIndex));
	}
	
	
	public static void trace(int lowIndex, int highIndex, int i, int lt, int gt, int length) {
		
		String[] tracer=new String[length+1];
		tracer=cleanupArray(tracer);
		addToTracer(tracer,i,"i");
		addToTracer(tracer, lowIndex,"1");
		addToTracer(tracer, highIndex,"2");
		addToTracer(tracer,lowIndex,"{");
		addToTracer(tracer,highIndex,"}");
		addToTracer(tracer,lt,"<");
		addToTracer(tracer,gt,">");
		
		System.out.println(traceArrayToString3Space(tracer));
		insertBreak(tracer.length);
		System.out.println();
	}

}
