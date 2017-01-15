package algoritham.java.com.vaquar.dynamicProgramming;

import java.util.Arrays;

/**
 * Longest Palindrome Subsequence by Tushar Roy on Youtube
 * 
 * INPUT is single row but computation need 2D array.
 * 
 * 
 *
 */
public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		String input = "agbdba";
		int output = findLongestPalindromicSubsequence(input);
	}

	private static int findLongestPalindromicSubsequence(String input) {
		char[] inputArray = input.toCharArray();
		//Note there is no extra row required like input.length()+1
		int[][] matrix = new int[input.length()][input.length()];
		for(int i = 0; i < input.length(); i++) {
			matrix[i][i] = 1;
		}
		for(int i = 1; i <= input.length(); i++) {
			int subStringLength = i;
			int start = 0;
			int end = start + subStringLength;
			while((start + subStringLength) < input.length()) {
				if(inputArray[start] != inputArray[end]) { //matrix[start][start] != matrix[end][end] IMPORTANT comparison should be done on input
					matrix[start][end] = Math.max(matrix[start][end-1], matrix[start+1][end]); //Should be very careful that what index we are comparing.
				} else {
					matrix[start][end] = 2 +   Math.max(matrix[start][end-1], matrix[start+1][end]);
				}
				start++;
				end = start + subStringLength;
			}
		}
		
		
		int maxIthIndex = 0;
		int maxJthIndex = input.length() - 1;
		
		char[] palindrome = new char[matrix[0][input.length()-1]];
		int palindromeIndex = 0;
		
		
		//Finding the sequence
		while(matrix[maxIthIndex][maxJthIndex] != 0) {
			if(matrix[maxIthIndex + 1][maxJthIndex] == matrix[maxIthIndex][maxJthIndex]) {
				maxIthIndex = maxIthIndex + 1;
			} else if (matrix[maxIthIndex][maxJthIndex -1] == matrix[maxIthIndex][maxJthIndex]) {
				maxJthIndex = maxJthIndex - 1;
			} else {
				//found the valid
				System.out.println(inputArray[maxIthIndex]);
				palindrome[palindromeIndex] = inputArray[maxIthIndex];
				palindrome[palindrome.length-1-palindromeIndex] = inputArray[maxJthIndex];
			    // It is very important that maxIthIndex is incrementing and maxJthIndex is decrementing	
				maxIthIndex = maxIthIndex + 1;
				maxJthIndex = maxJthIndex - 1;
				palindromeIndex++;
			}
		}
		System.out.println(Arrays.toString(palindrome));
		return matrix[0][input.length()-1];
	}
}
