package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HypotheticalNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
		// finalApproach();
	}

	private static void finalApproach() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int numberOfTestCases = Integer.parseInt(br.readLine());
			int[] result = new int[numberOfTestCases];
			int count = 0;
			int loop = 0;
			while (loop < numberOfTestCases) {
				int number = Integer.parseInt(br.readLine());
				String[] s1 = br.readLine().split(" ");
				int array[] = new int[number];
				for (int i = 0; i < array.length; i++) {
					array[i] = Integer.parseInt(s1[i]);
				}
				for (int i = 1; i < array.length - 1; i++) {
					int previous = array[i - 1];
					int desiredNumber = array[i];
					int next = array[i + 1];
					boolean ascending1 = desiredNumber - 1 != previous;
					boolean ascending2 = desiredNumber + 1 != next;

					boolean decending1 = desiredNumber + 1 != previous;
					boolean decending2 = desiredNumber - 1 != next;

					if (ascending1) {
						count++;
					} else if (ascending2) {
						count++;
					} else if (decending1) {
						count++;
					} else if (decending2) {
						count++;
					}
				}

				result[loop] = count;
				loop++;
			}
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void firstApproach() {
		int array[] = new int[] { 1, 2, 3, 4, 3, 4, 5, 6, 5, 1 };
		int count = 0;
		for (int i = 1; i < array.length - 1; i++) {
			int previous = array[i - 1];
			int desiredNumber = array[i];
			int next = array[i + 1];
			boolean ascending1 = desiredNumber - 1 != previous;
			boolean ascending2 = desiredNumber + 1 != next;

			boolean decending1 = desiredNumber + 1 != previous;
			boolean decending2 = desiredNumber - 1 != next;

			if (ascending1) {
				count++;
			} else if (ascending2) {
				count++;
			} else if (decending1) {
				count++;
			} else if (decending2) {
				count++;
			}

		}
		System.out.println(count);
	}

}
