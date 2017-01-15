package hackerearth2.java.vaquar.com.hackerearth;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MozartNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
//		System.out.println(primeFactors(30));
	}

	private static void firstApproach() {
		int firstNumber = 12;
		int secondNumber = 99999;
		BigInteger y;
		BigInteger x = y = BigInteger.ONE;
		List<BigInteger> series = new ArrayList<BigInteger>();
		series.add(BigInteger.ZERO);
		for (int i = 0; i < secondNumber; i++) {
			// System.out.println("series" + x);
			series.add(x);
			BigInteger fib = x.add(y);
			x = y;
			y = fib;

		}
		for (BigInteger integer : series) {
			System.out.println(integer);
		}
		
	}

	public static List<Integer> primeFactors(long number) {
		List<Integer> primefactors = new ArrayList<Integer>();
		long copyOfInput = number;
		for (int i = 2; i <= copyOfInput; i++) {
			if (copyOfInput % i == 0) {
				primefactors.add(i); // prime factor

				copyOfInput /= i;
				i--;
			}
		}
		return primefactors;
	}

}
