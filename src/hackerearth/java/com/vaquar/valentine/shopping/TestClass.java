package hackerearth.java.com.vaquar.valentine.shopping;

import java.util.Scanner;

public class TestClass {

    public static void main(String args[]) throws Exception {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();

	for (int t = 0; t < T; t++) {
	    int N = in.nextInt();
	    int M = in.nextInt();
	    int indexArr[] = new int[N];
	    String output = "";
	    for (int n = 0; n < N; n++) {
		int totalDiscount = 0;

		for (int m = 0; m < M; m++) {
		    int a = in.nextInt();
		    int b = in.nextInt();
		    int c = in.nextInt();
		    int discount = a + b + c - (((a * b) / 100) + ((b * c) / 100) + ((c * a) / 100) - ((a * b * c) / 10000));
		    if (discount > totalDiscount) {
			totalDiscount = discount;
			indexArr[n] = m + 1;
		    }
		}
		if (n != N - 1) {
		    output = output + indexArr[n] + " ";

		} else {
		    System.out.println(output + indexArr[n]);
		}
	    }
	}

    }
}
