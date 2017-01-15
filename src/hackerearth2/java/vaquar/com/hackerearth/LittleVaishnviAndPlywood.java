package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LittleVaishnviAndPlywood {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
	}

	private static void firstApproach() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String a = br.readLine();
			if (Integer.valueOf(a) > 0 && Integer.valueOf(a) <= 100) {
				int count = 0;
				long result[] = new long[Integer.valueOf(a)];
				while (count < Integer.valueOf(a)) {
					String line = br.readLine();
					String[] split = line.split(" ");
					int m = Integer.parseInt(split[0]);
					int k = Integer.parseInt(split[1]);
					long totalJump = 0;
					long tempJump = 0;
					if (m >= 1 && m <= 5) {
						if (k >= 0 && k <= 100000) {
							tempJump = 4 * k;
							if (k % 2 == 0) {
								if (m == 1) {
									totalJump = 8 * (k + 1);
								}
								if (m == 2) {
									totalJump = tempJump + 1;
								}
								if (m == 3) {
									totalJump = tempJump + 2;
								}
								if (m == 4) {
									totalJump = tempJump + 3;
								}
								if (m == 5) {
									totalJump = (8 * (k + 1)) - 4;
								}

							} else {
								if (k == 1) {
									if (m == 1) {
										totalJump = 8;
									}
									if (m == 2) {
										totalJump = tempJump + 3;
									}
									if (m == 3) {
										totalJump = tempJump + 2;
									}
									if (m == 4) {
										totalJump = tempJump + 1;
									}
									if (m == 5) {
										totalJump = (8 * (k + 1)) - 4;
									}
								} else {
									if (m == 1) {
										totalJump = 8 * (k + 1);
									}
									if (m == 2) {
										totalJump = tempJump + 3;
									}
									if (m == 3) {
										totalJump = tempJump + 2;
									}
									if (m == 4) {
										totalJump = tempJump + 1;
									}
									if (m == 5) {
										totalJump = (8 * (k + 1)) - 4;
									}
								}

							}

							if (m == 1 && k == 0) {
								totalJump = 0;
							}
							if (m == 2 && k == 0) {
								totalJump = 1;
							}
							if (m == 3 && k == 0) {
								totalJump = 2;
							}
							if (m == 4 && k == 0) {
								totalJump = 3;
							}
							if (m == 5 && k == 0) {
								totalJump = 4;
							}
						}
					}

					result[count] = totalJump;
					count++;
				}
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
