package algoritham.java.com.vaquar.search;

/**
 * Have a look at Arrays.binarySearch(int[] a, int fromIndex, int toIndex,
                                   int key)
 * 
 * 1. This is a static method
 * 2. Implementation is done using private api (binarySearch0);
 * 		 so that method with/without rangeCheck can call this common private api. 
 * 3. They do have     private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
 * 
 * 
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] input = { 10, 25, 33, 41, 77, 503}; // EVEN inputs
		// int[] input = { 10, 25, 33, 41, 77}; //ODD inputs
		System.out.println(binarySearch(input, 0, input.length, 25));
	}

	public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {

		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) { 
			int mid = (low + high) >>> 1; //Left shift will double the value, right shit divides by 2
			long midVal = a[mid];

			if (midVal < key)
				low = mid + 1;     //NOTE remember this
			else if (midVal > key)
				high = mid - 1;     //NOTE remember this
			else
				return mid; // key found
		}
		return -(low + 1); // key not found; till which direction with index
	}
}
