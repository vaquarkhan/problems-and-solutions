package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

class DecimalHelp {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int numberOfTestCases = Integer.parseInt(br.readLine());
			if (Integer.valueOf(numberOfTestCases) > 0
					&& Integer.valueOf(numberOfTestCases) <= 100) {
				int loop = 0;
				char r[] = new char[numberOfTestCases];
				while (loop < numberOfTestCases) {
					String[] s1 = br.readLine().split(" ");
					BigDecimal a, b, divide;
					a = new BigDecimal(s1[0]);
					b = new BigDecimal(s1[1]);
					int c = Integer.parseInt(s1[2]) + 1;
					divide = a.divide(b, c, RoundingMode.CEILING);
					String[] split = divide.toString().split("\\.");
					char d = split[1].charAt(c - 2);
					r[loop] = d;
					loop++;
				}
				for (int i = 0; i < r.length; i++) {
					System.out.println(r[i]);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
