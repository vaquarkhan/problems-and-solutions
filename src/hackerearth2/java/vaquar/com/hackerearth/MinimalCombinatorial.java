package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class MinimalCombinatorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfTestCases;
		try {
			numberOfTestCases = Integer.parseInt(br.readLine());
			if (numberOfTestCases > 0 && numberOfTestCases <= 100) {
				int loop = 0;
				BigInteger res[] = new BigInteger[numberOfTestCases];
				while (loop < numberOfTestCases) {
					String[] s1 = br.readLine().split(" ");
					int array[] = new int[2];
					for (int i = 0; i < array.length; i++) {
						array[i] = Integer.parseInt(s1[i]);
					}
					BigInteger top = calculateUpperFactorial(array[0], array[1]);
					BigInteger bot2 = calculateFactorial(array[0] - array[1]);
					BigInteger combinations = top.divide(bot2);
					res[loop] = combinations;
					loop++;
				}
				for (int i = 0; i < res.length; i++) {
					System.out.println(res[i]);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param n
	 * @param r
	 * @return upper
	 */
	private static BigInteger calculateUpperFactorial(int n, int r) {
		BigInteger upper = BigInteger.ONE;
		for (int i = r + 1; i <= n; i++) {
			upper = upper.multiply(BigInteger.valueOf(i));
		}
		return upper;
	}

	/**
	 * @param number
	 * @return fect
	 */
	private static BigInteger calculateFactorial(int number) {
		BigInteger fect = BigInteger.ONE;
		for (int i = 1; i <= number; i++) {
			fect = fect.multiply(BigInteger.valueOf(i));
		}
		return fect;
	}
}
