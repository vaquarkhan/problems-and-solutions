package algoritham.java.com.vaquar.array;

import java.util.Stack;

/**
 * http://cs.stackexchange.com/questions/57411/want-to-know-the-time-complexity-inner-for-loop-which-is-partially-iterating-the
 * Question: Find out next increasing value of each element in this below array.

	int[] array = { 5, 2, 7, 10, 4, 12}
	e.g) 
	5's nextIncreasingValue: 7 
	2's nextIncreasingValue: 7 
	7's nextIncreasingValue: 10 
	... 
	12's nextIncreasingValue: -1

 * 
 *
 */
public class NextIncreasingValue {
	public static void main(String[] args) {
		int[] array = { 5, 2, 7, 10, 4, 12 };
		solution_O_N(array);
		solution_O_N_SQURE(array);
	}

	private static void solution_O_N(int[] array) {
		Stack s = new Stack();
		for (int i = 0; i < array.length; i++) {
			while (!s.isEmpty() && array[i] > (int) s.peek()) {
				System.out.println("For " + s.pop() + "th next increasing value is: " + array[i]);
			}
			s.push(array[i]);
		}
		while (!s.isEmpty()) {
			System.out.println("For " + s.pop() + "th next increasing value is: " + -1);
		}
	}

	private static void solution_O_N_SQURE(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int nextIncreasingValue = -1;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[i]) {
					nextIncreasingValue = array[j];
					break;
				}
			}
			System.out.println("For " + array[i] + "th next increasing value is: " + nextIncreasingValue);
		}
	}
}
