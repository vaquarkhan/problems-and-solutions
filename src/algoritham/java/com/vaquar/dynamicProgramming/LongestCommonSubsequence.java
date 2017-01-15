package algoritham.java.com.vaquar.dynamicProgramming;

import java.util.Arrays;

/**
 * 
 * Longest Common Subsequence by Tushar Roy on Youtube. Solved using DP.
 * 
 * 
 *
 */
public class LongestCommonSubsequence {
	public static void main(String[] args) {
//		String input2 = "abcdaf";
//		String input1 = "acbcf";
//		String input2 = "ABCDGHLQR";
//		String input1 = "AEDPHR";
		String input1 = "ABCDGHLQR";
		String input2 = "AEDPHR";
		
		
		String lcsseq = findLongestCommonSubsequence(input1, input2);
	}

	private static String findLongestCommonSubsequence(String input1, String input2) {
		char[] inputArray1 = input1.toCharArray();
		char[] inputArray2 = input2.toCharArray();
		int[][] matrix = new int[inputArray1.length + 1][inputArray2.length + 1];
		
		/* Making First row and first column as ZERO,
		 * But this is not required since by default the value will be set to zero
		Arrays.fill(matrix[0], 0);
//		http://stackoverflow.com/questions/7118178/arrays-fill-with-multidimensional-array-in-java
//		Arrays.fill(matrix, 0); throws ArrayStoreException
		for(int[] array : matrix) {
			array[0] = 0;
		}
		*/
		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[0].length; j++ ) {
				if(inputArray1[i-1] == inputArray2[j-1]) { //This is important, since i, j starts with one.
					matrix[i][j] = matrix[i-1][j-1] + 1;  //Diagonal value (the best common sequence before) + 1 (for current equal value)
				} else {
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]); //TOP OR LEFT
				}
			}
		}
		
		for(int[] array : matrix) {
			System.out.println(Arrays.toString(array));
		}
		
		//Sequence
		int i = matrix.length - 1;    //MINUS ONE is important,when using this value in matrix. 
		int j = matrix[0].length - 1;
		while(i !=0 && j !=0) {
			if(matrix[i-1][j] == matrix[i][j]) { //TOP propagation
				i = i-1;
			} else if (matrix[i][j-1] == matrix[i][j]) { //Left propagation
				j = j-1;
			} else { //Diagonal movement prints the common/equal char 
				i = i-1;
				j = j-1;
//				System.out.println("Found: i="+i+"  j="+j);
//				System.out.println(matrix[i][j]);
				System.out.println(inputArray1[i]);
//				System.out.println(inputArray2[j]);
			}
//			System.out.println("     : i="+i+"  j="+j);
		}
		
		
		return null;
	}
}
