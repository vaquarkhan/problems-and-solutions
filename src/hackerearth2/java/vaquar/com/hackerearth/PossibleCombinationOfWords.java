package hackerearth2.java.vaquar.com.hackerearth;

import java.util.Arrays;

public class PossibleCombinationOfWords {

	public static void main(String[] args) {
		c = Arrays.asList("A", "a", "B", "b", "C", "c").toArray(new String[0]);
		permutation(0);
		System.out.println("Number of permutations = " + count);
	}

	static String[]	c;
	static int		count	= 0;

	static void swap(int pos1, int pos2) {
		String temp = c[pos1];
		c[pos1] = c[pos2];
		c[pos2] = temp;
	}

	public static void permutation(int start) {
		if (start != 0) {
			for (int i = 0; i < start; i++)
				System.out.print(c[i]);
			System.out.println();
			count++;
		}

		for (int i = start; i < c.length; i++) {
			swap(start, i);
			permutation(start + 1);
			swap(start, i);
		}
	}
}
