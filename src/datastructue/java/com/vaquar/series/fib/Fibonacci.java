package datastructue.java.com.vaquar.series.fib;

public class Fibonacci {
	
	public int fibRecur(int value){
		if (value<2) return value;
		return fibRecur(value-1) + fibRecur(value-2);
	}
	
	public int fibIter(int value){
		
		if (value<2) return value;
		
		int fibSum=0;
		
		int previous=1;
		int prevPrevious=0;
		
		for (int i=2; i<=value; i++){
			fibSum=previous+prevPrevious;
			prevPrevious=previous;
			previous=fibSum;
		}
		
		return fibSum;
		
	}
	
}
