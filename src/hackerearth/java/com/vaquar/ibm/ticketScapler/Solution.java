package hackerearth.java.com.vaquar.ibm.ticketScapler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
	args = new String[] { "2", "2", "5", "4", "10", "6", "20" };
	int n = Integer.valueOf(args[0]);
	int[] a = new int[n];
	for (int i = 0; i < n; i++) {
	    a[i] = Integer.valueOf(args[i + 1]);
	}
	int k = Integer.valueOf(args[n + 1]);
	System.out.println(maximumAmount(a, k));
    }

    /*
     * Complete the function below.
     */

    static long maximumAmount(int[] a, long k) {

	List<Integer> lst = new ArrayList<Integer>();
	for (int i = 0; i < a.length; i++) {
	    lst.add(a[i]);
	}

	Comparator cmp = Collections.reverseOrder();
	Collections.sort(lst, cmp);
	List<Integer> intList = new ArrayList<Integer>();
	int multiplier = 1;
	long sum = 0;

	int value = lst.get(0);
	lst.remove(0);
	int i = 0;

	while (value > 0 && i < k) {
	    while (lst.contains(value)) {
		multiplier++;
		lst.remove(0);
	    }
	    i = i + (1 * multiplier);
	    if (i < k) {
		sum = sum + (value * multiplier);
	    } else {
		int j = i - (1 * multiplier);
		while (j < k) {
		    sum = sum + (value);
		    j++;
		}
	    }
	    value = value - 1;
	}

	return sum;
    }
    // static long maximumAmount(int[] a, long k) {
    //
    //
    // List<Integer> intList = new ArrayList<Integer>();
    // for (int i = 0; i < a.length; i++) {
    // for (int j = 1; j <= a[i]; j++) {
    // intList.add(j);
    // }
    // }
    //
    // Comparator cmp = Collections.reverseOrder();
    // Collections.sort(intList, cmp);
    // long sum = 0;
    // for (int i = 0; i < k; i++) {
    // sum = sum + intList.get(i);
    // }
    //
    // return sum;
    //
    //
    // }
}
