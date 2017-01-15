package hackerearth2.java.vaquar.com.hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Criminals  Little Deepu and Little Kuldeep Solution
public class CriminalSmuggle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// firstApproach();
		// secondApproach();
		thirdApproach();
	}

	private static void thirdApproach() {
		int count = 0;
		// Tested - OKAY
		// int[] array = new int[] { 1, 2, 1, 3, 4, 1, 2, 5, 1, 2, 3, 4, 1, 1,
		// 2,
		// 3 };

		// Tested - OKAY
		// int[] array = new int[] { 2, 19, 2, 19};

		// Tested - OKAY
		// int[] array = new int[] { 2, 2, 2, 2 };

		// Tested - OKAY
		// int[] array = new int[] { 2, 10, 2, 2};

		// Tested - OKAY
		// int[] array = new int[] { 2, 10, 3, 2};

		// Tested - OKAY
		int[] array = new int[] { 2, 10, 2, 10, 2, 10 };

		List<Integer> r = new ArrayList<Integer>();
		List<Integer> i = new ArrayList<Integer>();
		for (Integer in : array) {
			i.add(in);
		}
		Collections.sort(i);
		while (i.size() <= array.length) {
			int max = 0;
			for (Integer a : i) {
				if (a > max) {
					max = a;
					r.add(a);
				}
			}
			for (Integer b : r) {
				i.remove(i.indexOf(b));
			}
			r = new ArrayList<Integer>();
			count++;
			if (i.size() < 2) {
				break;
			}
		}
		System.out.println(count + i.size());
	}

	private static void secondApproach() {
		int[] array = new int[] { 1, 2, 1, 3, 4, 1, 2, 5, 1, 2, 3, 4, 1, 1, 2,
				3 };
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> asList = new ArrayList<Integer>();
		for (Integer is : array) {
			asList.add(is);
		}
		Collections.sort(asList);
		while (res.size() <= array.length) {
			int max = 0;
			int count = 0;
			int numberOfPackets = array.length;
			for (int i = 0; i < array.length; i++) {
				if (array[i] > max) {
					max = array[i];
					res.add(array[i]);
					// asList.remove(Arrays.binarySearch(array, max));

					// count++;
				}
			}
			for (Integer i : res) {
				asList.remove(asList.indexOf(i));
			}
			for (Integer integer : asList) {
				System.out.println(integer);
			}
		}
	}

	private static void firstApproach() {
		// Second Approach is with array.
		int numberOfPackets = 3;
		int fst = 3;
		int scnd = 10;
		int trd = 3;

		String fstV = "empty";
		String scndV = "empty";
		String trdV = "empty";

		Map<Integer, String> drugs = new HashMap<Integer, String>();
		drugs.put(fst, fstV);
		drugs.put(scnd, scndV);
		drugs.put(trd, trdV);

		int count = 0;
		int max = fst;
		for (Map.Entry<Integer, String> entry : drugs.entrySet()) {
			if (entry.getKey() > max
					&& entry.getValue().equalsIgnoreCase("empty")) {
				max = entry.getKey();
				count++;
			}
		}
		System.out.println(numberOfPackets - count);

	}
}
