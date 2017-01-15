package hackerearth.java.com.vaquar.catchTheBus.SalaryProblem.ITEngineer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static long count = 0;

    public static void main(String args[]) throws Exception {
	Scanner in = new Scanner(System.in);
	int MOD = 1000000007;
	int t = in.nextInt();
	Map<String, Long> map = new HashMap<String, Long>();
	for (int i = 0; i < t; i++) {
	    count = 0;
	    long x = in.nextLong();
	    long y = in.nextLong();
	    long min = 0;
	    if (x < y) {
		min = x;

	    } else {
		min = y;
	    }
	    System.out.println("Case #" + (i + 1) + ": " + ((nCr((x + y), min)) % MOD) + "");
	}
    }

    public static long nCr(long n, long r) {
	long a = n;
	long b = r;
	long c = (n - r);

	for (long o = a - 1; o > 0; o--) {
	    a = a * o;
	}
	for (long o = b - 1; o > 0; o--) {
	    b = b * o;
	}
	for (long o = c - 1; o > 0; o--) {
	    c = c * o;
	}

	return (a / (b * c)); // n! / r! * (n - r)!
    }

}
