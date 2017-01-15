package hackerearth.java.com.vaquar.picnic.skillmeter;

import java.util.Arrays;
import java.util.List;

/**
 * This is a basic test intended to demonstrate java fluency and quickly .
 */
class ScreeningTest {
    public static void main(String[] args) {
	List<Integer> data1 = Arrays.asList(1, 4, 7);
	List<Integer> data2 = Arrays.asList(123, -2, 477, 3, 14, 6551);

	ScreeningTest obj = new ScreeningTest();

	int result = obj.fold(data1);
	System.out.println(result);

	int yourAnswer = obj.fold(data2); // what is the answer for this one???
	System.out.println(yourAnswer);
    }

    private int fold(List<Integer> input) {
	//
	// if (input != null && !input.isEmpty()) {
	// int firstElement = input.get(0);
	// for (int i = 1; i < input.size(); i++) {
	//
	// int result = input.get(i) + firstElement;
	// input.set(i, new Integer(result));
	// }
	// input.
	// }
	// if (input.size() == 1) {
	// return input.get(0);
	// } else {
	// return fold(input);
	// }
	for (int i = 0; i < input.size() - 1; i++) {
	    for (int j = i + 1; j < input.size(); j++) {
		int result = input.get(i) + input.get(j);
		input.set(j, new Integer(result));
		System.out.print(result + " ");
	    }
	    System.out.println();
	}

	return input.get(input.size() - 1);

    }
}
