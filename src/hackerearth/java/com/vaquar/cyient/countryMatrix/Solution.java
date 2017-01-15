package hackerearth.java.com.vaquar.cyient.countryMatrix;

public class Solution {

    public static void main(String[] args) {
	int[][] A = { { 5, 4, 4 }, { 4, 3, 4 }, { 3, 2, 4 }, { 2, 2, 2 }, { 3, 3, 4 }, { 1, 4, 4 }, { 4, 1, 1 } };
	Solution sol = new Solution();
	System.out.println(sol.solution(A));

    }

    public int solution(int[][] A) {

	int rowSize = A.length;
	int colSize = A[0].length;
	int count = 0;
	for (int i = 0; i < rowSize; i++) {
	    for (int j = 0; j < colSize; j++) {
		if (A[i][j] != -1) {
		    int color = A[i][j];
		    A[i][j] = -1;
		    count++;
		    checkAdjacentCountry(A, color, i, j, rowSize, colSize);
		    A[i][j] = -1;
		}

	    }
	}

	return count;
    }

    private void checkAdjacentCountry(int[][] A, int color, int i, int j, int N, int M) {

	if (i + 1 < N)
	    if (A[i + 1][j] == color) {
		A[i + 1][j] = -1;
		checkAdjacentCountry(A, color, i + 1, j, N, M);

	    }
	if (i - 1 >= 0)
	    if (A[i - 1][j] == color) {
		A[i - 1][j] = -1;
		checkAdjacentCountry(A, color, i - 1, j, N, M);

	    }
	if (j + 1 < M) {
	    if (A[i][j + 1] == color) {
		A[i][j + 1] = -1;
		checkAdjacentCountry(A, color, i, j + 1, N, M);

	    }
	}
	if (j - 1 >= 0) {
	    if (A[i][j - 1] == color) {
		A[i][j - 1] = -1;
		checkAdjacentCountry(A, color, i, j - 1, N, M);
	    }
	}
    }

}
