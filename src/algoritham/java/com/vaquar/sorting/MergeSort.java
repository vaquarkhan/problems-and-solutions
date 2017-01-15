package algoritham.java.com.vaquar.sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = { 5, 6, 10, 3, 9, 2, 12, 1, 8, 7 };
		mergeSort(array, 0, array.length -1);
		System.out.println(Arrays.toString(array));
		
     	int[] array1 = {4, 7, 2};
		System.out.println(Arrays.toString(array1));
		mergeSort(array1, 0, array1.length -1);
		System.out.println(Arrays.toString(array1));
		System.out.println("\n\n");
		
		int[] array2 = {4, 7, 9};
		System.out.println(Arrays.toString(array2));
		mergeSort(array2, 0, array2.length -1);
		System.out.println(Arrays.toString(array2));
		System.out.println("\n\n");
		
		int[] array3 = {4, 7, 5};
		System.out.println(Arrays.toString(array3));
		mergeSort(array3, 0, array3.length -1);
		System.out.println(Arrays.toString(array3));
		System.out.println("\n\n");
		
		int[] array4 = {7, 4, 2};
		System.out.println(Arrays.toString(array4));
		mergeSort(array4, 0, array4.length -1);
		System.out.println(Arrays.toString(array4));
		System.out.println("\n\n");
		
		int[] array5 = {7, 4, 9};
		System.out.println(Arrays.toString(array5));
		mergeSort(array5, 0, array5.length -1);
		System.out.println(Arrays.toString(array5));
		System.out.println("\n\n");
		
		int[] array6 = {7, 4, 5};
		System.out.println(Arrays.toString(array6));
		mergeSort(array6, 0, array6.length -1);
		System.out.println(Arrays.toString(array6));
		System.out.println("\n\n");
		
		//Handling array of size two
		int[] array7 = {7, 4};
		System.out.println(Arrays.toString(array7));
		mergeSort(array7, 0, array7.length -1);
		System.out.println(Arrays.toString(array7));
		System.out.println("\n\n");
		
        int input1[] = {1};
        int input2[] = {4,2};
        int input3[] = {6,2,9};
        int input4[] = {6,-1,10,4,11,14,19,12,18};
		System.out.println(Arrays.toString(input1));
        mergeSort(input1, 0, input1.length-1);
		System.out.println(Arrays.toString(input1));
		System.out.println("\n\n");
		
		System.out.println(Arrays.toString(input2));
        mergeSort(input2, 0, input2.length-1);
		System.out.println(Arrays.toString(input2));
		System.out.println("\n\n");
		
		System.out.println(Arrays.toString(input3));
        mergeSort(input3, 0, input3.length-1);
		System.out.println(Arrays.toString(input3));
		System.out.println("\n\n");
		
		System.out.println(Arrays.toString(input4));
        mergeSort(input4, 0, input4.length-1);
		System.out.println(Arrays.toString(input4));
		System.out.println("\n\n");
	}

	private static void mergeSort(int[] array, int p, int r) {
		//Both below mid finding is fine.
		int mid = (r - p)/2 + p;
		int mid1 = (r + p)/2;
		if(mid != mid1) {
			System.out.println(" Mid is mismatching:" + mid + "/" + mid1+ "  for p:"+p+"  r:"+r);
		}
		
		if(p < r) {
			mergeSort(array, p, mid);
			mergeSort(array, mid+1, r);
//			merge(array, p, mid, r);
			inPlaceMerge(array, p, mid, r);
		}
	}

	private static void merge(int[] array, int p, int mid, int r) {
		int lengthOfLeftArray = mid - p + 1; // This is important to add +1.
		int lengthOfRightArray = r - mid;
		
		int[] left = new int[lengthOfLeftArray];
		int[] right = new int[lengthOfRightArray];
		
		for(int i = p, j = 0; i <= mid; ){
			left[j++] = array[i++];
		}
		
		for(int i = mid + 1, j = 0; i <= r; ){
			right[j++] = array[i++];
		}
		
		int i = 0, j = 0;
		for(; i < left.length && j < right.length; ) {
			if(left[i] < right[j]){
				array[p++] = left[i++];
			} else {
				array[p++] = right[j++];
			}
		}
		while(j < right.length){
			array[p++] = right[j++];
		} 
		while(i < left.length){
			array[p++] = left[i++];
		}
	}
	
	
	private static void inPlaceMerge(int[] array, int p, int mid, int r) {
		int secondArrayStart = mid+1;
		int prevPlaced = mid+1;
		int q = mid+1;
		while(p < mid+1 && q <= r){
			boolean swapped = false;
			if(array[p] > array[q]) {
				swap(array, p, q);
				swapped = true;
			}	
			if(q != secondArrayStart && array[p] > array[secondArrayStart]) {
				swap(array, p, secondArrayStart);
				swapped = true;
			}
			//Check swapped value is in right place of second sorted array
			if(swapped && secondArrayStart+1 <= r && array[secondArrayStart+1] < array[secondArrayStart]) {
				prevPlaced = placeInOrder(array, secondArrayStart, prevPlaced);
			}
			p++;
			if(q < r) {     //q+1 <= r) {
				q++;
			}
		}
	}
	
	private static int placeInOrder(int[] array, int secondArrayStart, int prevPlaced) {
		int i = secondArrayStart;
		for(; i < array.length; i++) {
			//Simply swap till the prevPlaced position
			if(secondArrayStart < prevPlaced) {
				swap(array, secondArrayStart, secondArrayStart+1);
				secondArrayStart++;
				continue;
			}
			if(array[i] < array[secondArrayStart]) {
				swap(array, i, secondArrayStart);
				secondArrayStart++;
			} else if(i != secondArrayStart && array[i] > array[secondArrayStart]){
				break;
			}
		}
		return secondArrayStart;
	}

	private static void swap(int[] array, int m, int n){
		int temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
}
