package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AGameForSoftDrinks {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// firstApproach();
		finalApproach();
	}

	private static void finalApproach() throws IOException,
			NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		if (testCase > 0 && testCase <= 10000) {
			int loop = 0;
			String result[] = new String[testCase];
			while (testCase > loop) {
				String str = br.readLine();
				String[] split = str.split(" ");
				int firstPile = Integer.parseInt(split[0]);
				int secondPile = Integer.parseInt(split[1]);
				int thirdPile = Integer.parseInt(split[2]);

				boolean flag = true;
				int counter = 0;
				if (firstPile >= 0 && firstPile <= 100 && secondPile >= 0
						&& secondPile <= 100 && thirdPile >= 0
						&& thirdPile <= 100) {
					while (flag) {
						for (int i = 1; i < 7; i++) {
							flag = false;
							if (i == 1 || i == 2) {
								if (firstPile != 0) {
									firstPile--;
									flag = true;
									counter++;

								} else if (secondPile != 0) {
									secondPile--;
									flag = true;
									counter++;
								} else if (thirdPile != 0) {
									thirdPile--;
									flag = true;
									counter++;
								}

							} else if (i == 3 || i == 4) {
								if (firstPile != 0 && secondPile != 0) {
									firstPile--;
									secondPile--;
									flag = true;
									counter++;
								} else if (firstPile != 0 && thirdPile != 0) {
									firstPile--;
									thirdPile--;
									flag = true;
									counter++;
								} else if (secondPile != 0 && thirdPile != 0) {
									secondPile--;
									thirdPile--;
									flag = true;
									counter++;
								}
							} else if (i == 5 || i == 6) {
								if (firstPile != 0 && secondPile != 0
										&& thirdPile != 0) {
									firstPile--;
									secondPile--;
									thirdPile--;
									flag = true;
									counter++;
								}
							}

						}
					}
					if (counter % 2 == 0) {
						result[loop] = "Aishwarya";
					} else {
						result[loop] = "Ashima";
					}

				}
				loop++;
			}
			for (int j = 0; j < result.length; j++) {
				System.out.println(result[j]);
			}
		}
	}

	private static void firstApproach() {

		String str = "2 1 1";
		String[] split = str.split(" ");
		int firstPile = Integer.parseInt(split[0]);
		int secondPile = Integer.parseInt(split[1]);
		int thirdPile = Integer.parseInt(split[2]);

		boolean flag = true;
		int counter = 0;
		while (flag) {
			for (int i = 1; i < 7; i++) {
				flag = false;
				if (i == 1 || i == 2) {
					if (firstPile != 0) {
						firstPile--;
						flag = true;
						counter++;

					} else if (secondPile != 0) {
						secondPile--;
						flag = true;
						counter++;
					} else if (thirdPile != 0) {
						thirdPile--;
						flag = true;
						counter++;
					}

				} else if (i == 3 || i == 4) {
					if (firstPile != 0 && secondPile != 0) {
						firstPile--;
						secondPile--;
						flag = true;
						counter++;
					} else if (firstPile != 0 && thirdPile != 0) {
						firstPile--;
						thirdPile--;
						flag = true;
						counter++;
					} else if (secondPile != 0 && thirdPile != 0) {
						secondPile--;
						thirdPile--;
						flag = true;
						counter++;
					}
				} else if (i == 5 || i == 6) {
					if (firstPile != 0 && secondPile != 0 && thirdPile != 0) {
						firstPile--;
						secondPile--;
						thirdPile--;
						flag = true;
						counter++;
					}
				}

			}
		}
		if (counter % 2 == 0) {
			System.out.println("Aishwarya");
		} else {
			System.out.println("Ashima");
		}
	}

}
