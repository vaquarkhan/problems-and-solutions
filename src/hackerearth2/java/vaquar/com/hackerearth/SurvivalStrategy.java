package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SurvivalStrategy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		firstApproach();
	}

	private static void firstApproach() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			if (test > 0 && test <= 1000) {
				String result[] = new String[test];
				int loop = 0;
				while (test > loop) {

					long n = Long.parseLong(br.readLine());
					List<String> list = new ArrayList<String>();
					List<String> copyList = new ArrayList<String>();
					for (long i = 1; i <= n; i++) {
						list.add(i + "");
					}
					copyList.addAll(list);
					int count = 0;
					while (list.size() > 2) {
						for (String string : copyList) {
							count++;
							if (count == 2) {
								list.remove(list.indexOf(string));
								count = 0;
							}
						}
						copyList = new ArrayList<String>();
						copyList.addAll(list);
					}
					result[loop] = list.get(0);
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
}
