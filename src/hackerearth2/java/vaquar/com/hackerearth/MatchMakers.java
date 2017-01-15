package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MatchMakers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// firstApproach();
		// finalApproach();

		// for Integer inputs, its better to use Scanner in place of
		// BufferedReader.
		finalCorrectApproach();

	}

	private static void finalCorrectApproach() {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int people = sc.nextInt();
			List<Integer> girl = new ArrayList<Integer>();
			List<Integer> boy = new ArrayList<Integer>();
			for (int j = 0; j < people; j++) {
				girl.add(j, sc.nextInt());
			}
			for (int j = 0; j < people; j++) {
				boy.add(j, sc.nextInt());
			}
			Collections.sort(girl);
			Collections.sort(boy);
			Collections.reverse(boy);
			int count = 0;
			for (int j = 0; j < people; j++) {
				if (boy.get(j) % girl.get(j) == 0
						|| girl.get(j) % boy.get(j) == 0) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	private static void finalApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testC = Integer.parseInt(br.readLine());
			int result[] = new int[testC];
			if (testC > 0 && testC <= 100) {

				int loop = 0;
				while (testC > loop) {
					int people = Integer.parseInt(br.readLine());
					String[] boyArray = br.readLine().split(" ");
					String[] girlArray = br.readLine().split(" ");
					List<Integer> boy = new ArrayList<Integer>();
					List<Integer> girl = new ArrayList<Integer>();
					for (int i = 0; i < people; i++) {
						boy.add(Integer.parseInt(boyArray[i]));
						girl.add(Integer.parseInt(girlArray[i]));
					}
					Collections.sort(boy);
					Collections.sort(girl);
					int count = 0;
					for (int i = 0; i < people; i++) {
						// people - 1 - i
						if (boy.get(people - 1 - i) % girl.get(i) == 0
								|| girl.get(i) % boy.get(people - 1 - i) == 0) {
							count++;
						}
					}
					result[loop] = count;

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
		List<Integer> boy = new ArrayList<Integer>();
		List<Integer> girl = new ArrayList<Integer>();
		boy.add(2);
		boy.add(2);
		boy.add(2);
		boy.add(2);

		// Girl order is ascending - Increasing
		girl.add(2);
		girl.add(2);
		girl.add(2);
		girl.add(2);

		Collections.sort(girl);
		Collections.sort(boy);
		Collections.reverse(boy);
		int count = 0;
		for (int i = 0; i < boy.size(); i++) {
			if (boy.get(i) % girl.get(i) == 0 || girl.get(i) % boy.get(i) == 0) {
				count++;
			}
		}
		System.out.println(count);
	}

}
