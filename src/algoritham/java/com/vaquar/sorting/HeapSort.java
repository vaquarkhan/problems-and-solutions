package algoritham.java.com.vaquar.sorting;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] array = { 5, 6, 10, 3, 9, 2, 12, 1, 8, 7 };
		maxHeapSort(array, array.length);
		System.out.println(Arrays.toString(array));
		System.out.println("\n\n");
	}

	private static void maxHeapSort(int[] array, int length) {
		for(int i = 1; i < length; i++ ) {
			maxHeapify(array, 1, length-i);
			swap(array, 0, length-i);
		}
		//Working on last three indexes [which is 0,1,2]
		correctNode(array, 1, 3);
		swap(array, 0, 2);
		correctNode(array, 1, 2);
		swap(array, 0, 1);
	}

	private static void maxHeapify(int[] array, int nodeIndex, int length) {
		if(nodeIndex < length) {
			correctNode(array, nodeIndex, length);
			maxHeapify(array, 2 * nodeIndex, length);
			maxHeapify(array, (2 * nodeIndex)+1, length);
			correctNode(array, nodeIndex, length);
		}
	}

	private static void correctNode(int[] array, int index, int length) {
		int rootIndex = index - 1;
		int leftIndex = (2 * index) - 1;
		int rightIndex = ((2 * index) + 1) - 1;
		if(leftIndex < length && array[rootIndex] < array[leftIndex]) {
			swap(array, rootIndex, leftIndex);
		}
		
		if(rightIndex < length && array[rootIndex] < array[rightIndex]) {
			swap(array, rootIndex, rightIndex);
		}
	}
	
	private static void swap(int[] array, int m, int n){
		int temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
}
