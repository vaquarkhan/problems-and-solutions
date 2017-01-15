package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FindMeRoots {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int numberOfTestCases = Integer.parseInt(br.readLine());
			if (numberOfTestCases > 0 && numberOfTestCases <= 100) {
				int loop = 0;
				int count = 0;
				while (loop < numberOfTestCases) {
					int array[] = new int[3];
					String[] s1 = br.readLine().split(" ");
					for (int i = 0; i < array.length; i++) {
						array[i] = Integer.parseInt(s1[i]);
					}
					if (array[0] != 0 && array[0] >= -100 && array[0] <= 100 && array[1] >= -100
							&& array[1] <= 100 && array[2] >= -100
							&& array[2] <= 100) {
						int rootVal = (array[1] * array[1])
								- (4 * array[0] * array[2]);
						if (rootVal > 0) {
							count++;
						}
					}
					loop++;
				}
				System.out.println(count);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
