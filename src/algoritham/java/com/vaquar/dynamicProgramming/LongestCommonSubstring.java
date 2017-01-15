package algoritham.java.com.vaquar.dynamicProgramming;

/**
 * http://en.wikipedia.org/wiki/Longest_common_substring_problem
 * Longest Common Substring by Tushar Roy on Youtube.
 * 
 */
public class LongestCommonSubstring {

	public static void main(String args[]){
        char str1[] = "abcdef".toCharArray();
        char str2[] = "zcdemf".toCharArray();
        int output = getLongestCommonSubstring(str1, str2);
	}

	private static int getLongestCommonSubstring(char[] str1, char[] str2) {
		int[][] matrix = new int[str1.length +1][str2.length+1];
		int max = 0;
		int maxIthIndex = 0;
		int maxJthIndex = 0;
		for(int i = 1; i < matrix.length; i++ ) {
			for(int j = 1; j < matrix[0].length; j++) {
				if(str1[i-1] == str2[j-1]) {
					matrix[i][j] = 1 + matrix[i-1] [j-1];
//					max = Math.max(max, matrix[i][j]);
					if(max < matrix[i][j]) {
						max = matrix[i][j];
						maxIthIndex = i;
						maxJthIndex = j;
					}
				} else {
					matrix[i][j] = 0;
				}
			}
		}
		System.out.println(max);
		
		
		//print the sequence; Diagonal traversal till zero
		while(matrix[maxIthIndex][maxJthIndex] != 0) {
			System.out.println(str1[maxIthIndex-1]);
//			System.out.println(str2[maxJthIndex-1]); Anyone will work fine.
			//Traverse through the diagonal
			maxIthIndex--;
			maxJthIndex--;
		}
		return max;
	}
    
}
