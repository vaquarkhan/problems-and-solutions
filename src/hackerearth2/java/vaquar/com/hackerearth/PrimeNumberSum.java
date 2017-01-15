package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumberSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int number = Integer.parseInt(reader.readLine());
			List<Integer> list = new ArrayList<Integer>();
			Integer sum = 0;
			for (int i = 1; i <= number; i++) {
				list.add(i);
			}
			int firstPrime = 2;
			while ((firstPrime * firstPrime) < number) {
				for (Integer integer : list) {
					if (integer % firstPrime == 0 && integer != firstPrime) {
						// list.remove(list.indexOf(integer));
						list.set(list.indexOf(integer), 0);
					}
				}
				firstPrime++;
			}
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
			}
			System.out.println(sum-1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
