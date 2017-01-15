package algoritham.java.com.vaquar.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] integerArray = {5,16, 6, 100, 11, 2, 3, 8, 1, 10, 9, 4, 15, 12, 20, 0};
		 sortIt(integerArray);
		 Integer[] integerObjectArray = new Integer[integerArray.length];
		 int i = 0;
		 for (int value : integerArray) {
			 integerObjectArray[i++] = Integer.valueOf(value);
		 }
		 System.out.println(new ArrayList(Arrays.asList(integerObjectArray)));
	}
	
	public static void sortIt(int[] integerArray) {
		for(int i = 2; i < integerArray.length; ++i) {
			for(int j = i - 1; (j >= 0 && integerArray[j + 1] < integerArray[j]); --j) {
				    //SWAP
					int temp = integerArray[j + 1];
					integerArray[j + 1] = integerArray[j];
					integerArray[j] = temp;
			}
		}
	}
	
	public static void sortItInReverse (int[] integerArray) {
		for(int i = 2; i < integerArray.length; ++i) {
			for(int j = i - 1; (j > 0 && integerArray[j-1] < integerArray[j]); --j) {
				    //SWAP
					int temp = integerArray[j-1];
					integerArray[j-1] = integerArray[j];
					integerArray[j] = temp;
			}
		}
	}
	
	/**
	 * Points to be noted
	 * 
	 * 1. I should starts from 2
	 * 2. I should not be used at second loop since decrement is happening.
	 * 2. Below logic 
	 * 
	 * 		for(int j = i - 1; j > 0; --j,  --i) {
				if(integerArray[i] < integerArray[j]) {
					int temp = integerArray[i];
					integerArray[i] = integerArray[j];
					integerArray[j] = temp;
				} else {
					break;
				}
			}
	 * 		
	 *	Should be like 
	 *      for(int j = i - 1; (j > 0 && integerArray[i] < integerArray[j]); --j,  --i) {
					int temp = integerArray[i];
					integerArray[i] = integerArray[j];
					integerArray[j] = temp;
			}	
	 * 
	 */
}
