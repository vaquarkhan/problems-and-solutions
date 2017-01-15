package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DarkAndString2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
		finalApproach();

	}

	private static void finalApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCase = Integer.parseInt(br.readLine());
			if (testCase > 0 && testCase<=100) {
				int loop = 0;
				while (testCase > loop) {
					String str = br.readLine();
					List<Integer> list = new ArrayList<Integer>();
					List<Character> oprators = new ArrayList<Character>();
					for (int i = 0; i < str.length(); i++) {
						String chk = str.charAt(i) + "";
						if (checkInteger(str.charAt(i))) {
							list.add(Integer.parseInt(str.charAt(i) + ""));

						} else if (chk.matches("[+\\-*\\/%]")) {
							oprators.add(str.charAt(i));
						}
					}
					int result = list.get(0);
					for (int i = 1; i < list.size(); i++) {
						char firstOpr = oprators.get(i - 1);
						if (firstOpr == '+') {
							result += list.get(i);
						}
						if (firstOpr == '-') {
							result -= list.get(i);
						}
						if (firstOpr == '*') {
							result *= list.get(i);
						}
						if (firstOpr == '/') {
							result /= list.get(i);
						}
						if (firstOpr == '%') {
							result %= list.get(i);
						}
					}
					System.out.println(result);
					
					loop++;
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void firstApproach() {
		String str = "asl4+7343/%*";
		List<Integer> list = new ArrayList<Integer>();
		List<Character> oprators = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			String chk = str.charAt(i) + "";
			if (checkInteger(str.charAt(i))) {
				list.add(Integer.parseInt(str.charAt(i) + ""));

			} else if (chk.matches("[+\\-*\\/%]")) {
				oprators.add(str.charAt(i));
			}
		}
		int result = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			char firstOpr = oprators.get(i - 1);
			if (firstOpr == '+') {
				result += list.get(i);
			}
			if (firstOpr == '-') {
				result -= list.get(i);
			}
			if (firstOpr == '*') {
				result *= list.get(i);
			}
			if (firstOpr == '/') {
				result /= list.get(i);
			}
			if (firstOpr == '%') {
				result %= list.get(i);
			}
		}
		System.out.println(result);
	}

	private static boolean checkInteger(char charAt) {
		try {
			Integer.parseInt("" + charAt);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
