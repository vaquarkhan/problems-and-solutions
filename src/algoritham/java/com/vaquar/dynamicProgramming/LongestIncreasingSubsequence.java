package algoritham.java.com.vaquar.dynamicProgramming;

import java.util.Arrays;

/**
 * 
 * Longest Increasing Subsequence by Tushar Roy on Youtube Time complexity
 * o(n^2) and o(n) (Extra space other than given input)Space Complexity
 * 
 * Tushar Roy gave one more solution using o(nlogn) but not captured here
 * 
 *   3  4  -1  0  6  2  3
 *   1  2   1  2  3  3  4
 *   
 * 
 *
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] input = {1, -2, 3, 10, 6, 4, 5, 12, 15};
		int longestIS = findLongestIncreasingSubsequence(input);
		System.out.println(longestIS);
	}

	private static int findLongestIncreasingSubsequence(int[] input) {
		int[] counter = new int[input.length];
		Arrays.fill(counter, 1); //Important to note
		for(int i = 1; i < input.length; i++) {
			for(int j = 0; j < i; j++ ) {
				if(input[j] < input[i]) {
					counter[i] = Math.max(counter[i], (counter[j] + 1));
				}
			}
		}
		return counter[input.length-1];
	}
}
