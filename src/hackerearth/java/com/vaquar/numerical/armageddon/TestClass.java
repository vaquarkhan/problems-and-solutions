package hackerearth.java.com.vaquar.numerical.armageddon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {

    public static void main(String args[]) throws Exception {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line = br.readLine();
	int T = Integer.parseInt(line);

	int testCaseCount = 0;
	while (testCaseCount < T) {
	    String S = br.readLine();

	    if (S == null || S.isEmpty()) {
		System.out.println(0);
		continue;
	    }

	    int results = 0;
	    for (int i = 1; i <= (1 << (S.length())) - 1; i++) {

		StringBuilder builder = new StringBuilder();
		for (int j = 0; j < S.length(); j++) {
		    if ((i & (1 << j)) != 0) {

			builder.append(S.charAt(j));
		    }
		}
		if (((Integer.valueOf(builder.toString())) % 6) == 0) {
		    results++;
		}

	    }
	    System.out.println(results);
	    testCaseCount++;
	}
    }
}
