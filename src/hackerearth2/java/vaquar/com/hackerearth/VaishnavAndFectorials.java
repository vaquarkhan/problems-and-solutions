package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class VaishnavAndFectorials {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();

	}

	private static void firstApproach() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String a = br.readLine();
			if (Integer.valueOf(a) > 0 && Integer.valueOf(a) <= 100) {
				int loop = 0;
				long result[] = new long[Integer.valueOf(a)];
				while (loop < Integer.valueOf(a)) {
					int n = Integer.parseInt(br.readLine());
					String fect = fectorial(n);
					int count = 0;
					char[] charArray = fect.toCharArray();
					for (int i = 0; i < charArray.length; i++) {
						if (charArray[i] == '4' || charArray[i]=='7') {
							count++;
						}
					}
					result[loop] = count;
					loop++;
				}
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		

	}

	private static String fectorial(int n) {
		BigInteger fect = BigInteger.ONE;
		if (n == 0) {
			fect = BigInteger.ONE;
		} else {
			for (int i = 1; i <= n; i++) {
				fect = fect.multiply(BigInteger.valueOf(i));
			}
		}
		return fect.toString();
	}

}
