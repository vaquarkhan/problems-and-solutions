package hackerearth.java.com.vaquar.vizury.trace.matrix;

import java.util.Scanner;

public class TestClass {
    public static void main(String args[]) throws Exception {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int t = 0; t < T; t++) {
	    int R = sc.nextInt();
	    int C = sc.nextInt();

	    int minRC = 0;
	    if (R < C) {
		minRC = R;
	    } else {
		minRC = C;
	    }

	    int sum = 0;
	    for (int rc = 0; rc < minRC; rc++) {
		sum = sum + ((rc * R) + (rc + 1)) + ((rc * C) + (rc + 1));
	    }
	    System.out.println(sum);
	}

    }
}
