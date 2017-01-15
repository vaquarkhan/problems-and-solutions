package datastructue.java.com.vaquar.sorting.quick;

import static datastructue.java.com.vaquar.shuffle.KnuthShuffle.shuffle;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.exchange;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.less;

public class QuickSortDualPivot {
	
	public void sort (int[] input){
		//input=shuffle(input);
		sort (input, 0, input.length-1);
		//assertTrue(isSorted(input));
	}

	private void sort(int[] input, int lowIndex, int highIndex) {

		if (highIndex<=lowIndex) return;
		
		//System.out.println("LowIndex/HighIndex :"+lowIndex+"/"+highIndex);
		int pivot1=input[lowIndex];
		int pivot2=input[highIndex];
		
		
		if (pivot1>pivot2){
			exchange(input, lowIndex, highIndex);
			pivot1=input[lowIndex];
			pivot2=input[highIndex];
			//sort(input, lowIndex, highIndex);
		}
		else if (pivot1==pivot2){
			while (pivot1==pivot2 && lowIndex<highIndex){
				lowIndex++; 
				pivot1=input[lowIndex];
			}
		}
		

		int i=lowIndex+1;
		int lt=lowIndex+1;
		int gt=highIndex-1;
		
		while (i<=gt){
			
			if (less(input[i], pivot1)){
				exchange(input, i++, lt++);
			}
			else if (less(pivot2, input[i])){
				exchange(input, i, gt--);
			}
			else{
				i++;
			}
			
		}
		
		//System.out.println(arrayToString(input));
		//System.out.println("Swapping after loop : "+lowIndex +" & "+lt);
		exchange(input, lowIndex, --lt);
		exchange(input, highIndex, ++gt);
		
		sort(input, lowIndex, lt-1);
		//if (less (input[lt], input[gt])) sort (input, lt+1, gt-1);
		sort (input, lt+1, gt-1);
		sort(input, gt+1, highIndex);
			
		//assertTrue(isSorted(input, lowIndex, highIndex));
	}

}
