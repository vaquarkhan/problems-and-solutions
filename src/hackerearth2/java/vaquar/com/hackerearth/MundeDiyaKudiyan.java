package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MundeDiyaKudiyan {

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
			int test = Integer.parseInt(br.readLine());
			if (test > 0 && test <= 1500) {
				int loop = 0;
				String result[] = new String[test];
				while (test > loop) {
					int n = Integer.parseInt(br.readLine());
					String[] menSplit = br.readLine().trim().split(" ");
					String[] womenSplit = br.readLine().trim().split(" ");

					Arrays.sort(menSplit);
					Arrays.sort(womenSplit);

					int hotnessBond = 0;
					for (int i = 0; i < n; i++) {
						hotnessBond += Integer.parseInt(menSplit[i])
								* Integer.parseInt(womenSplit[i]);
					}
					result[loop] = "" + hotnessBond;
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

		String men = "2 3 2";
		String women = "1 3 2";
		String[] menSplit = men.split(" ");
		String[] womenSplit = women.split(" ");

		Arrays.sort(menSplit);
		Arrays.sort(womenSplit);

		int hotnessBond = 0;
		for (int i = 0; i < womenSplit.length; i++) {
			hotnessBond += Integer.parseInt(menSplit[i])
					* Integer.parseInt(womenSplit[i]);
		}
		System.out.println(hotnessBond);
	}

}
