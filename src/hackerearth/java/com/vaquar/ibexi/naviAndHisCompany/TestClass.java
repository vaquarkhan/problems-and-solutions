package hackerearth.java.com.vaquar.ibexi.naviAndHisCompany;

import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 */

class TestClass {
    public static void main(String args[]) throws Exception {
	/*
	 * Read input from stdin and provide input before running
	 * 
	 * BufferedReader br = new BufferedReader(new
	 * InputStreamReader(System.in)); String line = br.readLine(); int N =
	 * Integer.parseInt(line); for (int i = 0; i < N; i++) {
	 * System.out.println("hello world"); }
	 */

	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	int numOfResource = 0;
	int numOfProject = 0;

	for (int t = 0; t < T; t++) {
	    long N = in.nextLong();

	    for (long n = 0; n < N; n++) {
		if (in.hasNextInt()) {
		    numOfResource = numOfResource + in.nextInt();
		} else {
		    String project = "";
		    project = in.nextLine();
		    if (project.isEmpty()) {
			project = in.nextLine();
			if (project.trim().equals("New Project")) {
			    numOfProject = numOfProject + 1;
			}
		    } else {
			if (project.trim().equals("New Project")) {
			    numOfProject = numOfProject + 1;
			}
		    }
		}

	    }
	    int result = numOfProject - numOfResource;
	    if (result < 0) {
		result = 0;
	    }
	    System.out.println(Math.abs(result));
	}
    }
}
