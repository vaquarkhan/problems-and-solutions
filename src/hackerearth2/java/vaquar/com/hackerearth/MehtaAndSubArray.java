package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MehtaAndSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = 0;
		int count = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int n;
		String s = null;
		try {
			line = br.readLine();
			n = Integer.parseInt(line);
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String spli[] = s.split(" ");
		int ar[] = new int[spli.length];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(spli[i]);
		}
		for (int i = 0; i < ar.length - 1; i++) {
			a = ar[i];
			count = 1;
			for (int j = i + 1; j < ar.length; j++) {
				a = a + ar[j];
				count++;
				if (a >= 0) {
					al.add(count);
				}
			}
		}
		count = 1;
		Collections.sort(al);
		int x = al.get(al.size() - 1);
		for (int i = 0; i < al.size() - 1; i++) {
			if (al.get(i) == x) {
				{
					count++;
				}
			}

		}
		System.out.println(x + " " + count);

	}

}
