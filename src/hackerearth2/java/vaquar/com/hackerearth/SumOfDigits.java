package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SumOfDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		firstApproach();
		finalApproach();
	}

	private static void finalApproach() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int a = Integer.parseInt(br.readLine());
			if (a > 1 && a <= 10000) {
				int count = 0;
				while (count < a) {
					new BigInteger(br.readLine());
					count++;
				}
				System.out.println("0");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void firstApproach() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int a = Integer.parseInt(br.readLine());
			if (a > 1 && a <= 10000) {
				int count = 0;
				BigInteger numberTotal = BigInteger.ZERO;
				BigInteger totalDigitSum = BigInteger.ZERO;
				BigInteger digitSumTotal = BigInteger.ZERO;
				while (count < a) {
					BigInteger number = new BigInteger(br.readLine());
					numberTotal = numberTotal.add(number);
					BigInteger digitSum = calculateDigitSum(number);
					digitSumTotal = digitSumTotal.add(digitSum);
					count++;
				}
				totalDigitSum = calculateDigitSum(numberTotal);
				BigInteger remainder1 = digitSumTotal.remainder(BigInteger.TEN
						.subtract(BigInteger.ONE));
				BigInteger remainder2 = totalDigitSum.remainder(BigInteger.TEN
						.subtract(BigInteger.ONE));
				System.out.println(remainder1.subtract(remainder2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static BigInteger calculateDigitSum(BigInteger number) {
		BigInteger sum = BigInteger.ZERO;
		while (number.compareTo(BigInteger.ZERO) == 1) {
			sum = sum.add(number.remainder(BigInteger.TEN));
			number = number.divide(BigInteger.TEN);
		}
		return sum;

	}

}
