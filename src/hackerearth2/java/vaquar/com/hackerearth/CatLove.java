package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CatLove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			String[] s1 = br.readLine().split(" ");
			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(s1[i]);
			}
			int[] b = new int[n];
			String[] s2 = br.readLine().split(" ");
			for (int j = 0; j < b.length; j++) {
				b[j] = Integer.parseInt(s2[j]);
			}

			int indivisualStrength = 0;
			int maxStrength = 0;
			if (a.length == b.length) {
				for (int i = 0; i < b.length; i++) {
					indivisualStrength = a[i] * b[i];
					maxStrength += indivisualStrength;
				}
				System.out.println(maxStrength);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}