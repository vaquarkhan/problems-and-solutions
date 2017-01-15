package datastructue.java.com.vaquar.sorting.quick;

import static datastructue.java.com.vaquar.shuffle.KnuthShuffle.shuffle;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.exchange;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.less;

public class QuickSort3Way {
	
	
	public void sort (int[] input){
		//input=shuffle(input);
		sort (input, 0, input.length-1);
	}

	public void sort(int[] input, int lowIndex, int highIndex) {
		
		
		if (highIndex<=lowIndex) return;
		
		int lt=lowIndex;
		int gt=highIndex;
		int i=lowIndex+1;
		
		int pivotIndex=lowIndex;
		int pivotValue=input[pivotIndex];
		
		
		while (i<=gt){
			
			
			if (less(input[i],pivotValue)){
				exchange(input, i++, lt++);
			}
			else if (less (pivotValue, input[i])){
				exchange(input, i, gt--);
			}
			else{
				i++;
			}
				
			
		}
		
		sort (input, lowIndex, lt-1);
		sort (input, gt+1, highIndex);
		
		
	}

}
