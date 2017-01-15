package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class XSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		firstApproach();
		finalApproach();
	}

	private static void finalApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			if (n > 0 && n <= 200) {
				String str = br.readLine();
				String[] split = str.split(" ");
				BigInteger x = new BigInteger("1");
				for (int i = 0; i < split.length; i++) {
					x = x.multiply(new BigInteger(split[i]));

				}
				long finalCount = 0;
				if (x.compareTo(BigInteger.ZERO) == 1) {
					for (int i = 0; i < x.longValue(); i++) {
						BigInteger i2 = new BigInteger(((long) Math.pow(i, 2))
								+ "");
						if (i2.compareTo(x) == 1) {
							break;
						}
						long count = 0;
						BigInteger diff = x.subtract(i2);
						if (perfectSquare(diff)) {
							count++;
							if (i2.equals(BigInteger.ZERO)
									|| diff.equals(BigInteger.ZERO)) {
								finalCount += count + 1;

							} else {
								finalCount += count + 3;
							}
						}

					}

				}
				System.out.println(finalCount);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void firstApproach() {

		String str = "153 723236 71278781";
		String[] split = str.split(" ");
		BigInteger x = new BigInteger("1");
		for (int i = 0; i < split.length; i++) {
			x = x.multiply(new BigInteger(split[i]));

		}
		long finalCount = 0;
		if (x.compareTo(BigInteger.ZERO) == 1) {
			for (int i = 0; i < split.length; i++) {
				BigInteger i2 = new BigInteger(((long) Math.pow(i, 2)) + "");
				if (i2.compareTo(x) == 1) {
					break;
				}
				long count = 0;
				BigInteger diff = x.subtract(i2);
				if (perfectSquare(diff)) {
					count++;
					if (i2.equals(BigInteger.ZERO)
							|| diff.equals(BigInteger.ZERO)) {
						finalCount += count + 1;

					} else {
						finalCount += count + 3;
					}
				}

			}

		}
		System.out.println(finalCount);
	}

	private static boolean perfectSquare(BigInteger diff) {
		BigInteger sqrt = new BigInteger(((long) Math.sqrt(diff.doubleValue()))
				+ "");
		if (sqrt.multiply(sqrt).equals(diff)) {
			return true;
		} else {
			return false;
		}

	}

}
