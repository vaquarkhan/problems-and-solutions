package algoritham.java.com.vaquar.array;

public class DutchNationalFlagProblem {

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 0, 2, 1, 0, 0, 2, 2 };
		solveIt(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
	
    /**
     * Start three pointer i(start; points till all left side zeros), 
     *                     j(start; probagates till k crosses) and 
     *                     k(end; points till all right side ones).
     */
   	private static void solveIt(int[] a) {
		for (int i = 0, j = 0, k = a.length - 1; j < k;) {
			switch (a[j]) {
			case 0:
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				j++;
				i++;
				continue;
			case 1:
				j++;
				continue;
			case 2:
				temp = a[j];
				a[j] = a[k];
				a[k] = temp;
				k--;
				continue;
			}
			System.out.println(i);
		}
	}
}
