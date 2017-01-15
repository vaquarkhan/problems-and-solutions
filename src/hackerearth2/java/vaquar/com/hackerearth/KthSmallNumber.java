package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KthSmallNumber {

	public static void main(String[] args) {
		// firstApproach();
		second();

	}

	private static void second() {
		StringBuilder result = new StringBuilder();
		String str = "abc";
		for (int i = 0; i <= str.length(); i++) {
			for (int j = 0; j <= str.length(); j++) {
				if (j >= i) {
					String sub = str.substring(i, j);

					if ((i == 0 && j == 0) || (sub != null && !sub.equals(""))) {
						result.append("{").append(sub).append("}").append(",");

					}
				}

			}
		}
		System.out.println(result);

	}

	private static void firstApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			if (test > 0 && test <= 100) {
				String nq = br.readLine();
				String[] splitNQ = nq.split(" ");
				int n = Integer.parseInt(splitNQ[0]);
				int q = Integer.parseInt(splitNQ[1]);
				int innerLoop = 0;
				List<Integer> ls = new ArrayList<Integer>();
				while (innerLoop > n) {
					String ab = br.readLine();
					String[] abSplit = ab.split(" ");
					int a = Integer.parseInt(abSplit[0]);
					int b = Integer.parseInt(splitNQ[1]);
					for (int i = 1; i <= q; i++) {
						int diff = b + 1 - a;
						int k = Integer.parseInt(br.readLine());
						if (k > diff) {
							ls.add(-1);
						} else {

						}
					}
				}

				String ab = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
