package algoritham.java.com.vaquar.array;
public class RotateBy90 {
	public static void main(String[] args) {
//		int[][] m = {
//				{1,2,3,4,5},
//				{6,7,8,9,10},
//				{11,12,13,14,15},
//				{16,17,18,19,20},
//				{21,22,23,24,25}};
		
//		int[][] m = {
//				{1,2,3,4,5,50,51,52},
//				{6,7,8,9,10,100,101,102},
//				{11,12,13,14,15,150,151,152},
//				{16,17,18,19,20,200,201,202},
//				{21,22,23,24,25,250,251,252}};
		
		
		int[][] m = {
				{1,2,3},
				{6,7,8},
				{11,12,13},
				{16,17,18},
				{21,22,23},
				{31,32,33},
				{41,42,43}};
		
	for (int i=0; i< m.length; i++) {
		int[] row = m[i];
		for (int j=0; j<row.length; j++) {
			System.out.format("%4d", m[i][j]);
		}
		System.out.println();
	}
	System.out.println("------------------\n");
	
	printMatrixRotationBy90(m);
	
	System.out.println("\n------------------\n");	
	for (int i=0; i< m.length; i++) {
		int[] row = m[i];
		for (int j=0; j<row.length; j++) {
			System.out.format("%4d", m[i][j]);
		}
		System.out.println();
	}
}
	
	
	
	
	/**
	 * The solution is simple and it will solve all type [RECTANGLE] or [SQUARE] of matrix.
	 * @param matrix
	 */
	private static void printMatrixRotationBy90(int[][] matrix) {
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
			roatateMatrixBy90(matrix, starti, startj, endi, endj);
			System.out.println();
		}
		
		//This is corner case for matrix with columns are more than rows.
		if(starti < endj) {
			//Array row rotation code is needed.
			for(int j = starti; j < (endj); j++){
					int local = matrix[starti][j];
					 matrix[starti][j] =  matrix[starti][j+1];
					 matrix[starti][j+1] = local;
			}
			
			//just reversing it
//		    int condition = (((endj - starti) + 1)/2);
//		    for(int noOfRotation = 1, l2r = starti, r2l = endj; noOfRotation <= (condition); r2l--, l2r++, noOfRotation++ ) {
//				int temp = matrix[starti][l2r];
//				matrix[starti][l2r] = matrix[starti][r2l];
//				matrix[starti][r2l] = temp;
//			}
			for(int l2r = startj; l2r <= endj; l2r ++ ) {
				System.out.print("[" + matrix[starti][l2r]+ "], ");
			}
		}
		
		//This is corner case for matrix with rows are more than columns.
		//Currently just reversing it
		if(startj < endi) {
			//Array column rotation code is needed.
			for(int j = startj; j < (endi); j++){
					int local = matrix[j][startj];
					matrix[j][startj] =  matrix[j+1][startj];
					matrix[j + 1][startj] = local;
			}
			
			//just reversing it
//		    int condition = (((endi - startj) + 1)/2);
//		    for(int noOfRotation = 1, t2b = startj, b2t = endi; noOfRotation <= (condition); b2t--, t2b++, noOfRotation++ ) {
//				int temp = matrix[t2b][startj];
//				matrix[t2b][startj] = matrix[b2t][startj];
//				matrix[b2t][startj] = temp;
//			}
		    
			for(int t2b = starti; t2b <= endi;  t2b ++ ) {
				System.out.print("[" + matrix[t2b][endj]+ "], ");
			}
		}
		
		//Corner case for center of element in square oddNumber*oddNumber matrix
		if(starti == endj && startj == endi) {
			System.out.println("[" +matrix[starti][starti]+ "], ");
		}
	}
	
	private static void roatateMatrixBy90(int[][] matrix, int starti, int startj, int endi, int endj) {
		int[] previous = new int[(endj-starti)];//[Math.min(endi-starti, endj-startj)];
		
		int readPointer = 0;
		
		//left 2 right
		for(int l2r = startj; l2r < endj; l2r ++ ) {
			previous[readPointer++] = matrix[starti][l2r];
			System.out.print("[" + matrix[starti][l2r]+ "], ");
		}
		
		readPointer = 0;
		
		//top 2 bottom
		for(int t2b = starti; t2b < endi;  t2b ++ ) {
			if(readPointer == previous.length ){
				readPointer = 0;
			}
			int temp = matrix[t2b][endj];
			matrix[t2b][endj] = previous[readPointer];
			previous[readPointer++] = temp;
			
			System.out.print("[" + matrix[t2b][endj]+ "], ");
		}
		
		
		//right 2 left
		for(int r2l = endj; r2l > startj; r2l -- ) {
			if(readPointer == previous.length ){
				readPointer = 0;
			}
			int temp = matrix[endi][r2l];
			matrix[endi][r2l] = previous[readPointer];
			previous[readPointer++] = temp;
			
			System.out.print("[" + matrix[endi][r2l]+ "], ");
		}
		
		//bottom 2 top
		for(int b2t = endi; b2t > starti; b2t -- ) {
			if(readPointer == previous.length ){
				readPointer = 0;
			}
			int temp = matrix[b2t][startj];
			matrix[b2t][startj] = previous[readPointer];
			previous[readPointer++] = temp;
			
			System.out.print("[" + matrix[b2t][startj]+ "], ");
		}
		
		
		//left 2 right
		for(int l2r = startj; l2r < endj; l2r ++ ) {
			if(readPointer == previous.length ){
				readPointer = 0;
			}
			int temp = matrix[starti][l2r];
			matrix[starti][l2r] = previous[readPointer];
			previous[readPointer++] = temp;
			
			System.out.print("[" + matrix[starti][l2r]+ "], ");
		}
	}
}
