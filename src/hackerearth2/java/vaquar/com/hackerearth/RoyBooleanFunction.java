package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RoyBooleanFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		finalApproach();

	}

	private static void finalApproach() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			if (test > 0 && test <= 10) {
				int loop = 0;
				String[] result = new String[test];
				while (test > loop) {
					int number = Integer.parseInt(br.readLine());
					int count = 0;
					for (int i = 1; i < number; i++) {
						if (gcd(number, i) == 1) {
							count++;
						}
					}
					if (checkPrime(count)) {
						result[loop] = "TRUE";
					} else {
						result[loop] = "FALSE";
					}
					loop++;
				}
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean checkPrime(int n) {
		boolean isPrime = false;
		if (n == 2) {
			isPrime = true;
		} else {
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					isPrime = false;
					break;
				} else {
					isPrime = true;
				}
			}
		}
		return isPrime;
	}

	private static int gcd(int x, int y) {
		int r = 0, a, b;
		a = (x > y) ? x : y; // a is greater number
		b = (x < y) ? x : y; // b is smaller number

		r = b;
		while (a % b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return r;
	}

}
