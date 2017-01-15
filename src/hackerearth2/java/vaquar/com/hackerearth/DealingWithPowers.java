package hackerearth2.java.vaquar.com.hackerearth;

public class DealingWithPowers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 5;
		int c = 3;
		int n = 4;
		int m = 3;
		int M = 5;
		
		int b = calculateCombinations(n , m);
		long pow = (long) Math.pow(b, c);
		long result = (long) Math.pow(a, pow);
		long res = result % M;
		System.out.println((long) res);
	}

	private static int calculateCombinations(int n, int m) {
		int o = n -m;
		int top = calculateFactorial(n);
		int bot1 = calculateFactorial(m);
		int bot2 = calculateFactorial(o);
		int combinations = top/(bot1*bot2);
		return combinations;
	}

	private static int calculateFactorial(int number) {
		int fect = 1;
		for (int i = 1; i <= number; i++) {
			fect *= i;
		}
		return fect;
	}

}
