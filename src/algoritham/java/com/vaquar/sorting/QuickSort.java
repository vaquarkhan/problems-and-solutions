package algoritham.java.com.vaquar.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] array = { 5, 6, 10, 3, 9, 2, 12, 1, 8, 7 };
		quickSort(array, 0, array.length -1);
		System.out.println(Arrays.toString(array));
		
		
		/*
		 * There are 6 possibilities on
		 * sorting the three number where 
		 * the last one is pivot.
		 */
		
//	    case 1:  i -pointsTo-> 4  j -pointsTo-> 7  and pivot -pointsTo-> 2  
//		=then==>    i & j -pointsTo-> 4 and replace 4 by 2
		int[] array1 = {4, 7, 2};
		System.out.println(Arrays.toString(array1));
		quickSort(array1, 0, array1.length -1);
		System.out.println(Arrays.toString(array1));
		System.out.println("\n\n");
		
		int[] array2 = {4, 7, 9};
		System.out.println(Arrays.toString(array2));
		quickSort(array2, 0, array2.length -1);
		System.out.println(Arrays.toString(array2));
		System.out.println("\n\n");
		
		int[] array3 = {4, 7, 5};
		System.out.println(Arrays.toString(array3));
		quickSort(array3, 0, array3.length -1);
		System.out.println(Arrays.toString(array3));
		System.out.println("\n\n");
		
		int[] array4 = {7, 4, 2};
		System.out.println(Arrays.toString(array4));
		quickSort(array4, 0, array4.length -1);
		System.out.println(Arrays.toString(array4));
		System.out.println("\n\n");
		
		int[] array5 = {7, 4, 9};
		System.out.println(Arrays.toString(array5));
		quickSort(array5, 0, array5.length -1);
		System.out.println(Arrays.toString(array5));
		System.out.println("\n\n");
		
		int[] array6 = {7, 4, 5};
		System.out.println(Arrays.toString(array6));
		quickSort(array6, 0, array6.length -1);
		System.out.println(Arrays.toString(array6));
		System.out.println("\n\n");
		
		//Handling array of size two
		int[] array7 = {7, 4};
		System.out.println(Arrays.toString(array7));
		quickSort(array7, 0, array7.length -1);
		System.out.println(Arrays.toString(array7));
		System.out.println("\n\n");
		
	}

	private static void quickSort(int[] array, int p, int r) {
		//Handling array of size two
		if( p == r-1) {
			if (array[p] > array[r]) {
				swap(array, p, r);
			}
			return;
		}
		
		if(p < r) {
			int q = partition(array, p, r);	
//			System.out.println(Arrays.toString(array));
			quickSort(array, p, q-1);
//			System.out.println(Arrays.toString(array));
			quickSort(array, q+1, r);
//			System.out.println(Arrays.toString(array));
		}
	}

	private static int partition(int[] array, int p, int r) {
		int pivot = array[r];
		for (int i = p, j = r - 1; i < j ;) {
			//Sorting the last three number
			if(i == (j-1)) {
				//Sorting the three number
				if (array[i] > array[j]) { 
					swap(array, i, j);
				}
				
				if (array[j] > array[r]) {
					swap(array, j, r);
					r = j; //PIVOT position changed
				}
				if (array[i] > array[j]) {
					swap(array, i, j);
					r = i; //PIVOT position changed
				}
				break;
			}
			if(array[i] < pivot) {
				i++;
			} else {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				j--;
			}
		}
		return r;
	}
	
	
	private static void swap(int[] array, int m, int n){
		int temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
	/**
	 *     
	 *    case 2:  i=4  j=7  - pivot=9  =>    i & j = 7 and replace (i + 1) by 9
	 *    case 3:  i=4  j=7  - pivot=5  =>    i & j = 7 and replace 7 by 5
	 *    
	 *       
	 */
	
	
////	System.out.println(" i = " + i + "  j = " + j);
//	if(array[i] > array[r]) {
//		if(array[i+1] > array[i]) {
//			int temp = array[i+1];
//			array[i+1] = array[i];
//			array[i] = temp;
//		}
//		int temp = array[r];
//		array[r] = array[i];
//		array[i] = temp;
//	} else {
////		if(array[i-1] < array[i]) {
////			int temp = array[i-1];
////			array[i-1] = array[i];
////			array[i] = temp;
////		}
//		int temp = array[r];
//		array[r] = array[i+1];
//		array[i+1] = temp;
//	}
	
}
