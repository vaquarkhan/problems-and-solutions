package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EvenNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			List<Long> result = new ArrayList<Long>();
			long num = 0;
			while (num >= 0) {
				String number = br.readLine();
				num = Long.parseLong(number);
				if (num % 2 == 0) {
					result.add(num);
				}
			}
			for (Long lon : result) {
				System.out.println(lon);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
