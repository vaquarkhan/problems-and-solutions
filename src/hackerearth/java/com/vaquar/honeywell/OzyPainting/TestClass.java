package hackerearth.java.com.vaquar.honeywell.OzyPainting;

import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	long T = in.nextLong();
	for (int t = 0; t < T; t++) {
	    long x = in.nextLong();
	    long y = in.nextLong();
	    long z = in.nextLong();
	    long max = findBestCombination(x, y, z, 0);
	    System.out.println(max);

	}

    }

    private static long findBestCombination(long x, long y, long z, long count) {

	if (x >= 0 && y >= 0 && z >= 0) {
	    long a = 0, b = 0, c = 0, d = 0;

	    if (x >= 3) {
		a = findBestCombination(x - 3, y, z, count + 1);
	    } else {
		a = count;
	    }

	    if (y >= 3) {
		b = findBestCombination(x, y - 3, z, count + 1);
	    } else {
		b = count;
	    }

	    if (z >= 3) {
		c = findBestCombination(x, y, z - 3, count + 1);
	    } else {
		c = count;
	    }

	    if (x >= 1 && y >= 1 && z >= 1) {
		d = findBestCombination(x - 1, y - 1, z - 1, count + 1);
	    } else {
		d = count;
	    }
	    return ((a > b) && (a > c) && (a > d)) ? a : (((b > c) && (b > d)) ? b : (c > d) ? c : d);
	} else {
	    return count;
	}

    }

}
