package hackerearth.java.com.vaquar.makeMyTrip.witch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception {
	Scanner in = new Scanner(System.in);
	int MOD = 1000000007;
	int t = in.nextInt();
	for (int i = 0; i < t; i++) {
	    List<Long> longNum = new ArrayList<Long>();
	    longNum.add(in.nextLong());
	    longNum.add(in.nextLong());
	    longNum.add(in.nextLong());

	    Collections.sort(longNum);
	    int count1 = countMoves(longNum.get(0), longNum.get(1), longNum.get(2), -1);
	    int count2 = countMoves(longNum.get(2), longNum.get(0), longNum.get(1), -1);
	    System.out.println(count1 < count2 ? count2 : count1);
	}
    }

    private static int countMoves(Long long1, Long long2, Long long3, int count2) {

	int count3 = 0;
	int count4 = 0;
	if (long2 < long3 && (long3 - long2) > 1) {
	    count3 = countMoves(long2, long3 - 1, long3, count2);
	    count4 = countMoves(long3, long2 + 1, long2, count2);
	} else if (long2 > long3 && (long2 - long3) > 1) {
	    count3 = countMoves(long3, long2 - 1, long2, count2);
	    count4 = countMoves(long2, long3 + 1, long3, count2);
	} else if (long1 < long2 && (long2 - long1) > 1) {
	    count3 = countMoves(long1, long1 + 1, long2, count2);
	    count4 = countMoves(long1, long1 - 1, long2, count2);
	} else if (long1 > long2 && (long2 - long1) > 1) {
	    count3 = countMoves(long1, long1 + 1, long2, count2);
	    count4 = countMoves(long1, long1 - 1, long2, count2);
	} else {
	    return count2;
	}

	return count3 < count4 ? count4 : count3;
    }

}
