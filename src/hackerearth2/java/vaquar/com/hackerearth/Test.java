package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// splitString();
		// allSubstringOfAString();
		// hashMap();
		// testCondition();
		// addListInAnArray();
		// perfectSquare();
		// testBook();
		// hackerEarthInputOutputFormat();
		// firstNonRepeatedCharacterInAString();
		// checkPrime();
		checkRangeOfPrimitives();
	}

	private static void checkRangeOfPrimitives() {

		int a = 100000000;
		int b = 767657676;
		System.out.println(a + b);
	}

	private static void checkPrime() {
		int n = 25;
		boolean isPrime = false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			} else {
				isPrime = true;
			}
		}
		System.out.println(isPrime);

	}

	private static void firstNonRepeatedCharacterInAString() {
		String s = "stress";
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
				System.out.println(s.charAt(i));
				break;
			}
		}
	}

	private static void testBook() {

		int a = 10; // Assign a value to a
		System.out.println("a = " + a);
		int b = a;
		b = 30;
		System.out.println("a = " + a + " after change to b");
	}

	private static void perfectSquare() {
		int number = 112;
		int sqrt = (int) Math.sqrt(number);
		if (sqrt * sqrt == number) {
			System.out.println("Perfect Square");
			System.out.println(sqrt);
		} else {
			System.out.println("Not a Perfect Square");
		}
	}

	private static void addListInAnArray() {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> key = new ArrayList<Integer>();
		key.add(100);
		key.add(100);
		key.add(200);
		List<Integer> key2 = new ArrayList<Integer>();
		key2.add(3);
		key2.add(2);
		key2.add(1);
		map.put(1, key);
		map.put(2, key2);
		int i = 0;
		for (Map.Entry<Integer, List<Integer>> integer : map.entrySet()) {
			for (int j = 0; j < key2.size(); j++) {
				System.out.println(integer.getValue().get(j));
			}
		}
	}

	private static void testCondition() {
		// Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> key = new ArrayList<Integer>();
		key.add(100);
		key.add(100);
		key.add(200);
		key.add(100);
		key.add(200);
		List<Integer> values = new ArrayList<Integer>();
		values.add(1);
		values.add(2);
		values.add(5);
		values.add(6);
		values.add(10);
		Map<List<Integer>, List<Integer>> map = new HashMap<List<Integer>, List<Integer>>();
		// map.put(100, 1003);
		// map.put(100, 1002);
		// map.put(100, 1001);
		// map.put(50, 1004);
		// map.put(-50, 1005);
		// map.put(-50, 1006);
		// map.put(50, 1007);
		// map.put(100, 999);
		map.put(key, values);
		for (Map.Entry<List<Integer>, List<Integer>> entrySet : map.entrySet()) {
			System.out.println(entrySet);
		}

	}

	private static void hackerEarthInputOutputFormat() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			String[] s1 = br.readLine().split(" ");
			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(s1[i]);
			}
			int[] b = new int[n];
			String[] s2 = br.readLine().split(" ");
			for (int j = 0; j < b.length; j++) {
				b[j] = Integer.parseInt(s2[j]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void hashMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		int count = 0;
		// a=Empty
		// b=Full
		map.put(2, "a");
		map.put(1, "a");
		map.put(2, "a");
		int max = 2;
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			// System.out.println(entry.getKey());
			if (entry.getKey() > max && entry.getValue().equalsIgnoreCase("a")) {
				max = entry.getKey();
				count++;
			}
		}
		System.out.println(3 - count);
	}

	private static void splitString() {
		int count = 0;
		String a = "ankur|abhi|akriti|mahajan";
		String b = "ankur|abhishek|akritiM|mahajan|akriti";
		String[] split1 = a.split("\\|");
		String[] split2 = b.split("\\|");
		for (String string2 : split2) {
			for (String string1 : split1) {
				if (string2.equalsIgnoreCase(string1)) {

					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static void allSubstringOfAString() {
		int count = 0;
		String a = "AXBC";
		String array[] = new String[a.length() * 4];
		for (int i = 0; i < a.length(); i++) {
			for (int j = 1; j <= a.length() - i; j++) {

				array[count++] = a.substring(i, i + j);
			}
		}
		for (String string : array) {
			if (string != null) {
				if (string.matches("^[A-Ca-c]+$")) {

					System.out.println(string);
				}
			}
		}
		System.out.println(count);

	}

}
