package hackerearth2.java.vaquar.com.hackerearth;

import java.util.Arrays;
import java.util.Scanner;

class LuckyNumber_LogicNotClear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();

		while (c-- > 0) {
			sc.nextLine();
			String input = sc.nextLine().replaceAll("\\D", "");
			int[] luckyDigit = new int[input.length()];
			int count = 0;
			int allDigit = 0;
			for (char x : input.toCharArray()) {
				luckyDigit[count] = x - '0';
				allDigit |= 1 << luckyDigit[count++];
			}
			Arrays.sort(luckyDigit);
			int factor = sc.nextInt();
			boolean ispreCheckingPassed = preChecking(factor, luckyDigit);
			boolean isStart = false;
			if (ispreCheckingPassed) {
				boolean isRemDigit[][] = new boolean[factor][allDigit + 1];
				int testNumber = 0;
				int maxtest = 1024024;
				int nextDigitIndex[] = new int[maxtest];
				int quotients[] = new int[maxtest];
				int reminders[] = new int[maxtest];
				int digits[] = new int[maxtest];
				for (int x : luckyDigit) {
					if (x != 0) {
						int rem = x % factor;
						reminders[testNumber] = rem;
						digits[testNumber] = 1 << x;
						isRemDigit[rem][digits[testNumber]] = true;
						quotients[testNumber] = x / factor;
						nextDigitIndex[testNumber++] = -1;
					}
				}
				int temptest = 0;
				while (temptest < testNumber) {
					if (0 == reminders[temptest]
							&& digits[temptest] == allDigit) {
						int j = temptest;
						int i = 0;
						long msd = 0;
						int[] q = new int[maxtest];
						int[] d = new int[maxtest];

						do {
							q[i] = quotients[j];
							long temp = q[i] * factor + msd;
							d[i++] = (int) (temp % 10);
							msd = temp / 10;
							j = nextDigitIndex[j];
						} while (j != -1);

						if (msd > 0) {
							System.out.print(msd);
							isStart = true;
						}
						for (j = --i; j >= 0; j--) {
							if (!isStart && d[j] != 0) {
								isStart = true;
							}
							if (isStart) {
								System.out.print(d[j]);
							}
						}
						System.out.printf(" = %d * ", factor);
						isStart = false;
						for (j = i; j >= 0; j--) {
							if (!isStart && q[j] != 0) {
								isStart = true;
							}
							if (isStart) {
								System.out.print(q[j]);
							}
						}
						System.out.println();
						break;
					}
					for (int x : luckyDigit) {
						int tempD = digits[temptest] | (1 << x);
						int tempNumber = reminders[temptest] * 10 + x;
						int rem = tempNumber % factor;
						if (rem >= 0 && !isRemDigit[rem][tempD]) {
							quotients[testNumber] = tempNumber / factor;
							reminders[testNumber] = rem;
							isRemDigit[rem][tempD] = true;
							nextDigitIndex[testNumber] = temptest;
							digits[testNumber++] = tempD;
						}
					}
					temptest++;
				}
			}
			if (!isStart) {
				System.out.println("Impossible");
			}
		}
	}

	static boolean preChecking(int factor, int[] digits) {
		boolean testpass = true;
		if (factor % 10 == 0) {
			testpass = digits[0] == 0;
			return testpass;
		}
		if (testpass && factor % 5 == 0) {
			testpass = false;
			for (int x : digits) {
				if (x == 0 || x == 5) {
					testpass = true;
					break;
				}
			}
		}
		if (testpass && factor % 2 == 0) {
			testpass = false;
			for (int x : digits) {
				if ((x & 1) == 0) {
					testpass = true;
					break;
				}
			}
		}
		return testpass;
	}
}