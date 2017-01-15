package algoritham.java.com.vaquar.array;

public class MatrixSpiralPrint {
	public static void main(String[] args) {
//		int[][] m = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		
//		int[][] m = {     {1,  2,  3,  4,  20},
//				          {5,  6,  7,  8,  30},
//				          {9,  10, 11, 12, 40},
//				          {13, 14, 15, 16, 50},
//				          {23, 24, 25, 26, 60}};
		
//		int[][] m = {     {1,  2,  3,  4,  20, 21, 22, 23, 24},
//		          		  {5,  6,  7,  8,  30, 31, 32, 33, 34},
//		                  {9,  10, 11, 12, 40, 41, 42, 43, 44},
//		                  {13, 14, 15, 16, 50, 51, 52, 53, 54},
//		                  {23, 24, 25, 26, 60, 61, 62, 63, 64}};
		
		int[][] m = {     {1,  2,  3,  4,  40},
                          {5,  6,  7,  8,  50},
                          {9,  10, 11, 12, 60},
                          {13, 14, 15, 16, 70},
                          {17, 18, 19, 20, 80},
                          {21, 22, 23, 24, 90},
		                  {25, 26, 27, 28, 100},
		                  {29, 30, 31, 32, 110},
		                  {33, 34, 35, 36, 120}};
                          
		
//		int[][] m = {{1,  2,  3,  4 },
//		             {5,  6,  7,  8 },
//		             {9,  10, 11, 12},
//		             {13, 14, 15, 16},
//		             {23, 24, 25, 26}};
		
//		int[][] m = {{1,  2,  3,  4 },
//	                 {5,  6,  7,  8 },
//	                 {9,  10, 11, 12},
//	                 {13, 14, 15, 16}};
	             
		

		for (int i=0; i< m.length; i++) {
			int[] row = m[i];
			for (int j=0; j<row.length; j++) {
				System.out.print(m[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println("------------------\n");
		
		printSpiralSolution2(m);
	}

	/**
	 * The first solution is cumbersome of variables and it wont solve rectangular matrix
	 * @param matrix
	 */
	private static void printSpiralSolution1(int[][] matrix) {
		int leftToRightEnd = matrix[0].length - 1;
		int topToBottomEnd = matrix.length - 1;
		int rightToLeftEnd = 0;
		int bottomToTopEnd = 0;
		int leftToRight = 0;
		int topToBottom = 1 ;
		int rightToLeft = leftToRightEnd -1 ;
		int bottomToTop = topToBottomEnd -1;
		
		for(;;) {
			
			int leftToRightStart = leftToRight;
			
			for(; leftToRight <= leftToRightEnd; leftToRight ++) {
				System.out.print("[" + matrix[bottomToTopEnd][leftToRight] + "], ");
			}
			bottomToTopEnd ++;
			leftToRightEnd --;
			leftToRight --;
			
			int topToBottomStart = topToBottom;
			for(; topToBottom <= topToBottomEnd; topToBottom ++) {
				System.out.print("[" +matrix[topToBottom][leftToRight]+ "], ");
				
			}
			
			topToBottomEnd --;
			topToBottom --;
			
			int rightToLeftStart = rightToLeft;
			for(; rightToLeft >= rightToLeftEnd; rightToLeft --) {
				System.out.print("[" + matrix[topToBottom][rightToLeft]+ "], ");
			}
			rightToLeftEnd ++;
			rightToLeft ++;
			
			int bottomToTopStart = bottomToTop;
			for(; bottomToTop >= bottomToTopEnd; bottomToTop --) {
				System.out.print("[" + matrix[bottomToTop][rightToLeft]+ "], ");
			}
			
			System.out.println();
			
			leftToRight = leftToRightStart + 1;
			topToBottom = topToBottomStart + 1;
			rightToLeft = rightToLeftStart - 1;
			bottomToTop = bottomToTopStart - 1;
			
			if( leftToRight == (( (matrix[0].length - 1)/2) + 1)) {
				break;
			}
			
		} //End for(;;) 
	}
	
	
	
	
	/**
	 * The second solution is simple and it will solve all type [RECTANGLE] or [SQUARE] of matrix.
	 * @param matrix
	 */
	private static void printSpiralSolution2(int[][] matrix) {
		int starti = 0;
		int startj = 0;
		int endi = matrix.length - 1;
		int endj = matrix[0].length - 1;

		/*
		 * This loop is enough for SQURE matrix
		 * Pass diagonal elements ordinal from start and end e.g: (1,1) (2,2) (3,3)
		 * If diagonal crosses then that is the end point for this.
		 */
		for(; starti < endi && startj < endj; starti ++, startj ++, endi --, endj --) {
			printSpiralSolution2Sub(matrix, starti, startj, endi, endj);
			System.out.println();
		}
		
		//This is corner case for matrix with columns are more than rows.
		if(starti < endj) {
			for(int l2r = startj; l2r <= endj; l2r ++ ) {
				System.out.print("[" + matrix[starti][l2r]+ "], ");
			}
		}
		
		//This is corner case for matrix with rows are more than columns.
		if(startj < endi) {
			for(int t2b = starti; t2b <= endi;  t2b ++ ) {
				System.out.print("[" + matrix[t2b][endj]+ "], ");
			}
		}
		
		//Corner case for center of element in square oddNumber*oddNumber matrix
		if(starti == endj && startj == endi) {
			System.out.println("[" +matrix[starti][starti]+ "], ");
		}
	}
	
	private static void printSpiralSolution2Sub(int[][] matrix, int starti, int startj, int endi, int endj) {
		//left 2 right
		for(int l2r = startj; l2r < endj; l2r ++ ) {
			System.out.print("[" + matrix[starti][l2r]+ "], ");
		}
		
		//top 2 bottom
		for(int t2b = starti; t2b < endi;  t2b ++ ) {
			System.out.print("[" + matrix[t2b][endj]+ "], ");
		}
		
		//right 2 left
		for(int r2l = endj; r2l > startj; r2l -- ) {
			System.out.print("[" + matrix[endi][r2l]+ "], ");
		}
		
		//bottom 2 top
		for(int b2t = endi; b2t > starti; b2t -- ) {
			System.out.print("[" + matrix[b2t][startj]+ "], ");
		}
	}
}
