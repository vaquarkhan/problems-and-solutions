package hackerearth.java.com.vaquar.makeMyTrip.connectedHorses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception {
	Scanner in = new Scanner(System.in);
	int MOD = 1000000007;
	int t = in.nextInt();
	for (int i = 0; i < t; i++) {
	    int count = 0;
	    List<String> setString = new ArrayList<String>();
	    int n = in.nextInt();
	    int m = in.nextInt();
	    int q = in.nextInt();

	    for (int j = 0; j < q; j++) {
		int x = in.nextInt();
		int y = in.nextInt();

		setString.add(x + "-" + y);

	    }
	    for (int j = 0; j < q; j++) {

		String str = setString.get(j);
		String[] arr = str.split("-");
		int x = Integer.valueOf(arr[0]);
		int y = Integer.valueOf(arr[1]);

		if (setString.contains((x - 1) + "-" + (y - 2))) {
		    count++;
		}

		if (setString.contains((x - 1) + "-" + (y + 2))) {
		    count++;

		}

		if (setString.contains((x + 1) + "-" + (y + 2))) {
		    count++;
		}

		if (setString.contains((x + 1) + "-" + (y - 2))) {
		    count++;

		}

		if (setString.contains((x + 2) + "-" + (y + 1))) {
		    count++;
		}

		if (setString.contains((x + 2) + "-" + (y - 1))) {
		    count++;

		}

		if (setString.contains((x - 2) + "-" + (y - 1))) {
		    count++;

		}

		if (setString.contains((x - 2) + "-" + (y + 1))) {
		    count++;

		}

	    }

	    System.out.println((count) % MOD);
	}
    }
}
