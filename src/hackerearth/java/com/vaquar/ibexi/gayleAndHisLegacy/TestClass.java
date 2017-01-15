package hackerearth.java.com.vaquar.ibexi.gayleAndHisLegacy;

import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 */

class TestClass {
    public static void main(String args[]) throws Exception {

	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();

	for (int t = 0; t < T; t++) {

	    int N = sc.nextInt();
	    long M = sc.nextInt();
	    String status = "YES";

	    for (int n = 0; n < N; n++) {

		long gi = sc.nextLong();
		long pi = sc.nextLong();

		status = "YES";

		for (int n1 = 0; n1 < N; n1++) {

		    if (pi < M) {
			M = M + gi;
		    }
		    else if (pi > M) {
			status = "NO";
			break;
		    }
		}
	    }
	    System.out.println(status);
	}
    }
}
