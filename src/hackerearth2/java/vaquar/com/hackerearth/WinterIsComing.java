package hackerearth2.java.vaquar.com.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WinterIsComing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 16;
		int sum = 0;
		int[] array = new int[] { 1, 2, 1, 3, 4, 1, 2, 5, 1, 2, 3, 4, 1, 1, 2,
				3 };
		List<Integer> inputList = new ArrayList<Integer>();
		List<Integer> removedElements = new ArrayList<Integer>();
		for (Integer integer : array) {
			inputList.add(integer);
		}
		int max = 0;
		Collections.sort(inputList);
		for (Integer a : inputList) {
			if (a > max) {
				max = a;
				removedElements.add(a);
			}
		}

		for (Integer integer : removedElements) {

			System.out.println(integer);
		}
		System.out.println(max);
		System.out.println(Arrays.binarySearch(array, max) + 1);
	}

}
