package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleTask {

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
			int testC = Integer.parseInt(br.readLine());
			if (testC > 0 && testC <= 5) {
				int[] result = new int[testC];
				int loop = 0;
				while (testC > loop) {
					int arrL = Integer.parseInt(br.readLine());
					String[] arr = br.readLine().split(" ");
					List<Integer> rd = new ArrayList<Integer>();
					List<Integer> sortedList = new ArrayList<Integer>();
					int upperDiff = 0;
					for (int i = 1; i < arrL - 1; i++) {
						upperDiff = Math.abs(Integer.parseInt(arr[i])
								- Integer.parseInt(arr[i + 1]));
						rd.add(upperDiff);
						sortedList.add(upperDiff);
						i += 1;
					}
					Collections.sort(sortedList);
					Integer maxDiff = sortedList.get(sortedList.size() - 1);
					int indexOf = rd.indexOf(maxDiff);

					int arrayIndex = 2 * indexOf + 1;
					if (Integer.parseInt(arr[arrayIndex]) > Integer
							.parseInt(arr[arrayIndex + 1])) {
						result[loop] = arrayIndex + 2;
					} else {
						result[loop] = arrayIndex + 1;
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

		// int[] arr = new int[] { 1, 5, 7, 2, 10, 14, 16, 17, 20, 1 };
		// int[] arr = new int[] { 69, 11, 74, 52, 47, 100, 99, 71, 39, 49, 97,
		// 100, 66 };
		int[] arr = new int[] { 1, 10, 20, 40, 60 };
		List<Integer> rd = new ArrayList<Integer>();
		List<Integer> sortedList = new ArrayList<Integer>();
		int upperDiff = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			upperDiff = Math.abs(arr[i] - arr[i + 1]);
			rd.add(upperDiff);
			sortedList.add(upperDiff);
			i += 1;
		}
		Collections.sort(sortedList);
		Integer maxDiff = sortedList.get(sortedList.size() - 1);
		int indexOf = rd.indexOf(maxDiff);

		int arrayIndex = 2 * indexOf + 1;
		if (arr[arrayIndex] > arr[arrayIndex + 1]) {
			System.out.println(arrayIndex + 2);
		} else {
			System.out.println(arrayIndex + 1);
		}
	}

}
