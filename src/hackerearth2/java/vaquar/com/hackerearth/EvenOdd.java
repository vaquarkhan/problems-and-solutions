package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EvenOdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
		finalApproach();
	}

	private static void finalApproach() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int test = Integer.parseInt(br.readLine());
			if (test > 0 && test <= 100000) {
				int count = 0;
				String result[] = new String[test];
				while (count < test) {
					String[] split = br.readLine().split(" ");
					long a = Long.parseLong(split[0]);
					long b = Long.parseLong(split[1]);
					long evenNumber = 0;
					long allNumbers = 0;
					long oddNumber = 0;
					for (long i = 1; i < a; i++) {
						if (i % 2 == 0) {
							evenNumber += i;
						}
						allNumbers += i;
					}
					if (a <= b) {
						if (a%2==0) {
						allNumbers += a;
						evenNumber += a;
						oddNumber = allNumbers - evenNumber;
						} else {
							allNumbers += a;
							oddNumber = allNumbers - evenNumber;
						}
					} else {
						if (a % 2==0) {
							allNumbers += b;
							evenNumber += b;
							oddNumber = allNumbers - evenNumber;
						} else {
							allNumbers += b; 
							oddNumber = allNumbers - evenNumber;
						}
					}
					result[count] = evenNumber + " " + oddNumber;
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

	private static void firstApproach() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int test = Integer.parseInt(br.readLine());
			if (test > 0 && test <= 100000) {
				int count = 0;
				String result[] = new String[test];
				while (count < test) {
					String[] split = br.readLine().split(" ");
					long a = Long.parseLong(split[0]);
					long b = Long.parseLong(split[1]);
					long evenNumber = 0;
					long allNumbers = 0;
					long oddNumber = 0;
					if (a <= b) {
						for (long i = 1; i <= a; i++) {
							if (i % 2 == 0) {
								evenNumber += i;
							}
							allNumbers += i;
						}
						oddNumber = allNumbers - evenNumber;
					} else {
						long tempEvenNumber = 0;
						for (long i = 1; i < a; i++) {
							if (i % 2 == 0) {
								tempEvenNumber += i;
							}
							allNumbers += i;
						}
						evenNumber = tempEvenNumber + b;
						oddNumber = allNumbers - tempEvenNumber;
					}
					result[count] = evenNumber + " " + oddNumber;
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