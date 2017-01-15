package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CompositeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
//		secondApproach();
	}

	private static void secondApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String a = br.readLine();
			if (Integer.valueOf(a) > 0 && Integer.valueOf(a) <= 100) {
				int loop = 0;
				long result[] = new long[Integer.valueOf(a)];
				while (loop < Integer.valueOf(a)) {
					String line = br.readLine();
					String[] split = line.split(" ");
					int n = Integer.parseInt(split[0]);
					int m = Integer.parseInt(split[1]);
					List<Integer> list = new ArrayList<Integer>();
					int flag = 0;
					for (int i = n; i <= m; i++) {
						flag = 0;
						for (int j = 2; j < i; j++) {
							if (i % j == 0)
								flag++;
						}
						if (flag != 0)
							list.add(i);
					}
					int count = 0;
					for (Integer integer : list) {
						char[] charArray = integer.toString().toCharArray();
						for (int i = 0; i < charArray.length; i++) {
							if (charArray[i] == '7') {
								count++;
							}
						}

					}
					if (count != 0) {
						result[loop] = count;
					} else {
						result[loop] = -1;
					}
					loop++;
				}
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private static void firstApproach() {
		int n = 14;
		int m = 37;
		List<Integer> list = new ArrayList<Integer>();
		int flag = 0;
		for (int i = n; i <= m; i++) {
			flag = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					flag++;
			}
			if (flag != 0)
				list.add(i);
		}
		int count = 0;
		for (Integer integer : list) {
			char[] charArray = integer.toString().toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] == '7') {
					count++;
				}
			}

		}
		if (count != 0) {
			System.out.println(count);
		} else {
			System.out.println("-1");
		}
	}

}
