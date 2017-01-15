package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class FinalCode {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int nt = Integer.parseInt(br.readLine());
			if (Integer.valueOf(nt) > 0 && Integer.valueOf(nt) <= 1020) {
				int count = 0;
				int r[] = new int[Integer.valueOf(nt)];
				int[] ar = new int[5];
				while (count < Integer.valueOf(nt)) {
					String[] s1 = br.readLine().split(" ");
					for (int i = 0; i < ar.length; i++) {
						ar[i] = Integer.parseInt(s1[i]);
					}
					int a = ar[0];
					int c = ar[1];
					int n = ar[2];
					int m = ar[3];
					int M = ar[4];

					int b = calculateCombinations(n, m);
					double result = ((Math.pow(a, Math.pow(b, c))) % M);
					r[count] = (int) result;
					count++;
				}
				for (int i = 0; i < r.length; i++) {
					System.out.println(r[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int calculateCombinations(int n, int m) {
		int o = n - m;
		// int top = calculateFactorial(n);
		// int bot1 = calculateFactorial(m);
		// int bot2 = calculateFactorial(o);
		int combinations = calculateFactorial(n) / (calculateFactorial(m)
				* calculateFactorial(o));
		return combinations;
	}

	private static int calculateFactorial(int number) {
		int fect = 1;
		for (int i = 1; i <= number; i++) {
			fect *= i;
		}
		return fect;
	}
}
