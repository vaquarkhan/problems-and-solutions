package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GirlfriendsDemand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// firstApproach();
		finalApproach();
	}

	private static void finalApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine();
			int test = Integer.parseInt(br.readLine());
			int length = str.length();
			if (test > 0 && test <= 10000 && length > 0 && length <= 10000) {
				String result[] = new String[test];
				int loop = 0;
				while (test > loop) {
					String pair = br.readLine();
					String[] split = pair.split(" ");
					long firstIndex = Long.parseLong(split[0]) - 1;
					long secondIndex = Long.parseLong(split[1]) - 1;
					char frstChar = str.charAt((int) (firstIndex % length));
					char scndChar = str.charAt((int) (secondIndex % length));
					if (frstChar == scndChar) {
						result[loop] = "Yes";
					} else {
						result[loop] = "No";
					}
					loop++;
				}
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	private static void firstApproach() {
		String str = "vgxgp";
		String pair = "2 4";
		String[] split = pair.split(" ");
		long firstIndex = Long.parseLong(split[0]) - 1;
		long secondIndex = Long.parseLong(split[1]) - 1;
		int length = str.length();
		char frstChar = str.charAt((int) (firstIndex % length));
		char scndChar = str.charAt((int) (secondIndex % length));
		if (frstChar == scndChar) {

			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
