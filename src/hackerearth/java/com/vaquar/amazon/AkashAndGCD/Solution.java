package hackerearth.java.com.vaquar.amazon.AkashAndGCD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Map<Long, Long> map = new HashMap<Long, Long>();

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	long n = in.nextLong();
	long a[] = new long[(int) (n + 1)];
	for (int i = 0; i < n; i++) {
	    a[i + 1] = in.nextLong();
	}
	int q = in.nextInt();
	in.nextLine();
	for (int i = 0; i < q; i++) {
	    String s = in.nextLine();
	    String[] sa = s.split(" ");
	    if (sa == null || sa.length != 3) {
		continue;
	    }

	    if (sa[0].equalsIgnoreCase("C")) {
		long sum = 0;

		for (int j = Integer.parseInt(sa[1]); j <= Integer.parseInt(sa[2]); j++) {
		    long sum1 = 0;
		    if (map.containsKey(a[j])) {
			sum = sum + map.get(a[j]);
		    } else {
			int k = 1;
			while (k <= a[j]) {
			    sum1 = sum1 + findGCD(k, a[j]);
			    k++;
			}
			sum = sum + sum1;
			map.put(a[j], sum1);
		    }
		}
		System.out.println(sum % (10 ^ 9 + 7));
	    } else if (sa[0].equalsIgnoreCase("U")) {
		a[Integer.parseInt(sa[1])] = Integer.parseInt(sa[2]);
	    }
	}

    }

    private static long findGCD(long number1, long number2) {
	if (number2 == 0) {
	    return number1;
	}
	return findGCD(number2, number1 % number2);
    }

}
