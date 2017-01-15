package algoritham.java.com.vaquar.array;

/**
 * http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 * https://www.youtube.com/watch?v=NFvAD5na5oU&feature=youtu.be
 * 
 * NOT smaller than  == Can be same OR Can be greater
 * greater than its neighbors  == Must be greater.
 * 
 * Given an array of integers. Find a peak element in it. An array element is peak if it is NOT smaller than its neighbors. 
 * For corner elements, we need to consider only one neighbor. For example, for input array {5, 10, 20, 15}, 20 is the only peak element.
 * For input array {10, 20, 15, 2, 23, 90, 67}, there are two peak elements: 20 and 90. Note that we need to return any one peak element.

Following corner cases give better idea about the problem.
1) If input array is sorted in strictly increasing order, the last element is always a peak element. 
	For example, 50 is peak element in {10, 20, 30, 40, 50}.
2) If input array is sorted in strictly decreasing order, the first element is always a peak element. 
	100 is the peak element in {100, 80, 60, 50, 20}.
3) If all elements of input array are same, every element is a peak element. (NOT smaller than condition)

It is clear from above examples that there is always a peak element in input array in any input array.

A simple solution is to do a linear scan of array and as soon as we find a peak element, we return it. 
The worst case time complexity of this method would be O(n).

Can we find a peak element in worst time complexity better than O(n)?
We can use Divide and Conquer to find a peak in O(Logn) time. The idea is Binary Search based, we compare middle element with its neighbors. 
If middle element is not smaller than any of its neighbors, then we return it. 
If the middle element is smaller than the its left neighbor, then there is always a peak in left half (Why? take few examples).
If the middle element is smaller than the its right neighbor, then there is always a peak in right half (due to same reason as left half).

Consider the following modified definition of peak element. An array element is peak if it is greater than its neighbors.
Note that an array may not contain a peak element with this modified definition.

 * 
 *
 */
public class PeakElement {
	public static void main(String[] args) {
//		int[] array = {10, 4, 6, 2, 9, 8, 7, 5};
//		int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
//		int[] array = {1, 3, 20, 4, 1, 0};
		int[] array = {10, 9, 8, 7, 6, 5, 4, 3};
		System.out.println(solution1_O_LOGN(array));
	}
	
	//Linear search.
	//Find -A- peak element; not all peak element
	public static int solution1_O_N (int[] array){
		if(array[0] >= array[1]) {
			return array[0];
		}
		for(int i = 1; i < array.length-2; i++) {  //NOTE minus 2 @ array.length-2
			if(array[i-1] <= array[i] && array[i] >= array[i+1]) {
				return array[i];
			}
		}
		if(array[array.length-1] >= array[array.length-2]) {  //NOTE last element is array.length-1 not array.length-2.
			return array[array.length-1];
		}
		return -1;
	}
	
	//Binary search. 
	public static int solution1_O_LOGN (int[] array){
		int low = 1;
		int high = array.length - 2;
		int mid = -1;
		
		//Handling first two
		if(array[0] >= array[1]) {
			return array[0];
		}
		
		//Binary search
		while(low <= high) {
			mid = low + high >>> 1;
			if(array[mid-1] <= array[mid]) {
				if(array[mid] >= array[mid+1]){
					return array[mid];
				}
				low = low + 1;
			}
			else{
				high = mid - 1;
			}
		}
		//Handling last two
		if(array[array.length-1] >= array[array.length-2]) {  
			return array[array.length-1];
		}
		
		return -1;
	}
}
