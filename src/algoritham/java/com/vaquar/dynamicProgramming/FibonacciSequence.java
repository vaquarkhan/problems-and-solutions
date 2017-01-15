package algoritham.java.com.vaquar.dynamicProgramming;

/**
 * 
 * By definition, 
 * the first two numbers in the Fibonacci sequence are either 1 and 1, or 0 and 1,
 * depending on the chosen starting point of the sequence,
 * and each subsequent number is the sum of the previous two.
 *   
 * F{n} = {F{n-1} + F{n-2} if n > 1
 *        { n              if n = 0,1 
 * 
 *
 */
public class FibonacciSequence {

	private static int[] fibArray; //Recursion with memoization
	static int recurFib(int v){
    	if(v < 2){
    		return v;
    	}
    	if(fibArray[v] != 0) {
    		return fibArray[v];
    	}
    	else  
    	{
    		fibArray[v] = recurFib(v-1) + recurFib(v-2);
    	    return fibArray[v];
    	}
    }
	
	static int printFibTop2Bottom(int v) { //Memoization (Top Down)
    	if(v < 2){
    		return v;
    	}
    	if(fibArray[v] != 0) {
    		return fibArray[v];
    	}
    	else {
    		fibArray[v] = fibArray[v-1] + fibArray[v-2];
    		System.out.print(fibArray[v] + ", ");
    		return fibArray[v];
    	}
    }
	
	static int printFibBottomUp(int v) { //Tabulation (Bottom Up)
		fibArray[0] = 0;
		fibArray[1] = 1;
		for(int i = 2; i <= v; i ++) {
    		fibArray[i] = fibArray[i-1] + fibArray[i-2];
    		System.out.print(fibArray[i] + ", ");
		}
		return fibArray[v];
    }
	
	public static void main(String[] args) {
		int value = 10;
		fibArray = new int[value+1];
		System.out.print("Fibonacci Sequence for value " + value + " is : 0, 1, ");
		printFibBottomUp(value);
	}

}
