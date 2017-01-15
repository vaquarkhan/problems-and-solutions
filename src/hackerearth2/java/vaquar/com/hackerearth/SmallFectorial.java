package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SmallFectorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String a = br.readLine();
			if (Integer.valueOf(a) > 0 && Integer.valueOf(a) <= 100) {
				int count = 0;
				BigInteger result[] = new BigInteger[Integer.valueOf(a)];
				while (count < Integer.valueOf(a)) {
					int number = Integer.parseInt(br.readLine());
					BigInteger fect = BigInteger.ONE;
					for (int i = 1; i <= number; i++) {
						fect = fect.multiply(BigInteger.valueOf(i));
					}
					result[count] = fect;
					count++;
				}
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
