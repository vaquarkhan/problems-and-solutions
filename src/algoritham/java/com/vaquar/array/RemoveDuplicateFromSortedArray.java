package algoritham.java.com.vaquar.array;

/**
 * 
 * 
 *
 */
public class RemoveDuplicateFromSortedArray {
	static int[] arr = {1,1,2,3,3,4,5,5,6,6,6,6,8,9,9};
	public static void main(String[] args) {
		print();
		int writer = 0;
		for (int i=1; i<arr.length; i++) {
			if (arr[writer] != arr[i]) {
				arr[++writer] = arr[i];
			}
		}
		
		System.out.println(writer);
		if (writer < arr.length-1) {
			for (int i=writer; i < arr.length; i++) {
				arr[i] = 0;
			}
		}
		print();
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + " | ");
		}
		System.out.println(sb);
	}

}
