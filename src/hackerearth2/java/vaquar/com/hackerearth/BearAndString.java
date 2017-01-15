package hackerearth2.java.vaquar.com.hackerearth;

import java.util.ArrayList;
import java.util.List;

public class BearAndString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// firstApproach();
		secondApproach();
	}

	private static void secondApproach() {
		String a = "hammer";
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < a.length(); i++) {
			list.add("" + a.charAt(i));
		}
		String startString = "ham";
		String endString = "mer";
		int count = 0;
		boolean flag = false;
		while (flag == false) {
			System.out.println(a.indexOf(startString));
			System.out.println(a.indexOf(endString));
			System.out.println(a.lastIndexOf(startString));
			if (list.indexOf(startString) == list.lastIndexOf(startString)) {
				flag = true;
			}
			for (int i = list.indexOf(startString); i < list.size(); i++) {
				if (list.get(i) == endString) {

					count++;
				}
			}
			list.set(list.indexOf(startString), "#");
		}
		System.out.println(count);
	}

	private static void firstApproach() {
		String a = "rretgaogoa";
		String startString = "g";
		char endString = 'o';
		int count = 0;
		for (int i = a.indexOf(startString); i < a.length(); i++) {
			if (a.charAt(i) == endString) {

				count++;
			}
		}
		System.out.println(count);
	}

}
