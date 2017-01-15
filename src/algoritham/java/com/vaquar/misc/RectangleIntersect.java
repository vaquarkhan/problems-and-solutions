package algoritham.java.com.vaquar.misc;

/**
 * http://www.geeksforgeeks.org/find-two-rectangles-overlap/
 * 
 * I think there are two possible solutions.
 * 1) Check anyone point of one rectangle is within another rectangle.
 *    HERE we have to take all 4 points of rectangle one by one and check is it within 
 *    another rectangle.
 *    
 * 2) Check if two rectangle are separated.
 * 
 * Note that this program works only when rectangle axis are parallel to graph axis (axis aligned).
 * Means rectangle not rotated by any degree.
 * http://stackoverflow.com/questions/2752725/finding-whether-a-point-lies-inside-a-rectangle-or-not
 * 
 * 
 *             .......... Y2
 *             .        . 
 *             .        .
 *        ..........Y1  .
 *        .    .   .    .
 *        .    ..........
 *        .   X2   .
 *        .        .
 *        ..........
 *      X1
 *  
 * 
 *
 */
public class RectangleIntersect {
	public static void main(String[] args) {
		Point recONEp1 = new Point(2, 2);
		Point recONEp2 = new Point(5, 5);
		Point recTWOp1 = new Point(3, 3);
		Point recTWOp2 = new Point(6, 6);
		boolean b1 = doOverlap1(recONEp1, recONEp2, recTWOp1, recTWOp2);
		boolean b2 = doOverlap2(recONEp1, recONEp2, recTWOp1, recTWOp2);
		
		System.out.println(b1 + "  == " + b2);
		
		 recONEp1 = new Point(2, 2);
		 recONEp2 = new Point(5, 5);
		 recTWOp1 = new Point(6, 6);
		 recTWOp2 = new Point(8, 8);
		 b1 = doOverlap1(recONEp1, recONEp2, recTWOp1, recTWOp2);
		 b2 = doOverlap2(recONEp1, recONEp2, recTWOp1, recTWOp2);
		 
		System.out.println(b1 + "  == " + b2);
	}
    
	//1) Check anyone point of one rectangle is within another rectangle.
	private static boolean doOverlap1(Point X1, Point Y1, Point X2, Point Y2) {
		
            if (checkGivenPointIsInsideRectangle(X1, Y1, X2)) {
				return true;
			} else if (checkGivenPointIsInsideRectangle(X1, Y1, Y2)) {
				return true;
			} else if(checkGivenPointIsInsideRectangle(X1, Y1, new Point(X2.x, Y2.y))) {
				return true;
			} else if (checkGivenPointIsInsideRectangle(X1, Y1, new Point(Y2.x, X2.y))) {
				return true;
			} 
			return false;
	}
	
	//1) Check anyone point of one rectangle is within another rectangle.
	private static boolean checkGivenPointIsInsideRectangle(Point X1, Point Y1, Point X2) { 
		if(X1.x < X2.x && X1.y < X2.y && Y1.x > X2.x && Y1.y > X2.y) {
			return true;
		}
		return false;
	}
	
	
	
	//2) Check if two rectangle are separated.
	private static boolean doOverlap2(Point X1, Point Y1, Point X2, Point Y2) {
		
		if(X1.x > Y2.x || X1.y > Y2.y) {
			return false;
		}
		
		if(X2.x > Y1.x || X2.y > Y1.y) {
			return false;
		}
		return true;
	}
}



class Point {
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	int x;
	int y;
}
