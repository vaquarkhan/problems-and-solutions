package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddingReversedNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
	}

	private static void firstApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testC = Integer.parseInt(br.readLine());
			if (testC > 0 && testC <= 10000) {
				int[] resultArray = new int[testC];
				int loop = 0;
				while (testC > loop) {
					String[] split = br.readLine().split(" ");
					int a = Integer.parseInt(split[0]);
					int b = Integer.parseInt(split[1]);
					int revA = reverseNumber(a);
					int revB = reverseNumber(b);
					int result = revA + revB;
					resultArray[loop] = reverseNumber(result);
					loop++;
				}
				for (int i = 0; i < resultArray.length; i++) {
					System.out.println(resultArray[i]);
				}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static int reverseNumber(int number) {
		String numberString = number + "";
		StringBuilder sb = new StringBuilder();
		char[] charArray = numberString.toCharArray();
		char[] revArr = new char[charArray.length];
		int j = 0;
		for (int i = charArray.length - 1; i >= 0; i--) {
			revArr[j] = charArray[i];
			sb.append(revArr[j]);
			j++;
		}

		return Integer.parseInt(sb.toString());
	}

}
