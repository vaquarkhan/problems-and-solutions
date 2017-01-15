package algoritham.java.com.vaquar.dynamicProgramming;

import java.util.Arrays;

/**
 * 
 * Maximum Sum in Increasing Subsequence by Tushar Roy on Youtube Time complexity O(n^2) 
 * 
 *
 */
public class MaximumSumInIncreasingSubsequence {
	public static void main(String[] args) {
		int[] input = {2, 1, 4, 25, 8, 9, 7, 6};
//		int[] input = {29, 1, 4, 28, 8, 9, 7, 6};
		int maxSum = findMaximumSumInIncreasingSubsequence(input);
	}

	private static int findMaximumSumInIncreasingSubsequence(int[] input) {
		int [] sum = new int[input.length]; //Maximum sum array; stores maximum sum at each index
		System.arraycopy(input, 0, sum, 0, input.length); //initially maximum value will be at least the same value of input

		int [] sequence = new int[input.length]; 
		Arrays.fill(sequence, -1); //Zero is valid value so fill with -1
		
		for(int i = 1; i < input.length; i++) {
			for(int j = 0; j < i; j++) {
				if(input[j] < input[i]) {
					int oldSum = sum[i];
					sum[i] = Math.max(sum[i], (sum[j] + input[i]));
					if(oldSum != sum[i]) {
						//Value changed, so update sequence with where the new value get from.
						sequence[i] = j;
					}
				}
			}
		}
		
		int maxSum = 0;
		int maxSumIndex = 0;
		//Find Max Sum
		for(int i = 1; i < sum.length; i++) {
			if(maxSum < sum[i]) {
				maxSum = sum[i];
				maxSumIndex = i; //Find the starting point
			}
		}
		System.out.println("Maximu sum is :" + maxSum);
		
		//Find the sequence
		while(maxSumIndex > 0) {
			System.out.println(input[maxSumIndex]);
			maxSumIndex = sequence[maxSumIndex];
		}
		if(maxSumIndex == 0) {
			System.out.println(input[maxSumIndex]);
		}
		
		return maxSum;
	}
}
