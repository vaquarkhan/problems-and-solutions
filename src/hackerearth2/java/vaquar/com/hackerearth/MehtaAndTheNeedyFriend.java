package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MehtaAndTheNeedyFriend {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// firstApproach();
		finalApproach();
	}

	private static void finalApproach() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			if (test > 0 && test <= 100) {
				int loop = 0;
				String result[] = new String[test];
				while (test > loop) {
					String str = br.readLine();
					String[] split = str.split(" ");
					long a = Long.parseLong(split[0]);
					long b = Long.parseLong(split[1]);
					int k = Integer.parseInt(split[2]);

					List<String> resultList = new ArrayList<String>();
					for (long i = a; i <= b; i++) {
						String containZero = "" + i;
						if (!containZero.contains("0")) {
							long charMultiplication = 1;
							for (int j = 0; j < containZero.length(); j++) {
								// charMultiplication *= Long
								// .parseLong(charArray[j] + "".trim());
								charMultiplication *= Long.parseLong(""
										+ containZero.charAt(j));
							}
							long sqrt = (long) Math.sqrt(charMultiplication);
							if (sqrt * sqrt == charMultiplication) {
								resultList.add(containZero);
							}
						}
					}
					if (resultList.size() >= k) {
						result[loop] = "" + resultList.get(k - 1);

					} else {
						result[loop] = "-1";
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

	private static void firstApproach() {
		String str = "8 14 2";
		String[] split = str.split(" ");
		long a = Long.parseLong(split[0]);
		long b = Long.parseLong(split[1]);
		int k = Integer.parseInt(split[2]);

		List<String> resultList = new ArrayList<String>();
		for (long i = a; i <= b; i++) {
			String containZero = "" + i;
			if (!containZero.contains("0")) {
				char[] charArray = containZero.toCharArray();
				long charMultiplication = 1;
				for (int j = 0; j < charArray.length; j++) {
					charMultiplication *= Long.parseLong(charArray[j]
							+ "".trim());
				}
				long sqrt = (long) Math.sqrt(charMultiplication);
				if (sqrt * sqrt == charMultiplication) {
					resultList.add(containZero);
				}
			}
		}
		if (resultList.size() >= k) {
			System.out.println(resultList.get(k - 1));

		} else {
			System.out.println("-1");
		}
		// for (String string : resultList) {
		// System.out.println(string);
		// }
	}

}
