package hackerearth.java.com.vaquar.furniture.transportation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestClass {
    private static int count = 0;

    public static void main(String args[]) throws Exception {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int l = in.nextInt();
	int m = in.nextInt();
	List<Integer> integerList = new ArrayList<Integer>();
	for (int i = 0; i < n; i++) {
	    int num = in.nextInt();
	    if (!(num >= l)) {
		integerList.add(num);
	    }
	}
	if (integerList.size() < m) {
	    System.out.println(0);
	} else {
	    printCombination(integerList, integerList.size(), m);
	    System.out.println(count);
	}
    }

    private static void printCombination(List<Integer> integerList, int n, int m) {

	int data[] = new int[m];

	// Print all combination using temprary array 'data[]'
	combinationUtil(integerList, data, 0, n - 1, 0, m);

    }

    private static void combinationUtil(List<Integer> integerList, int[] data, int start, int end, int index, int m) {

	if (index == m)
	{
	    permute(data, 0);
	    return;
	}

	for (int i = start; i <= end && end - i + 1 >= m - index; i++)
	{
	    data[index] = integerList.get(i);
	    combinationUtil(integerList, data, i + 1, end, index + 1, m);
	}

    }

    static void permute(int[] num, int start) {

	if (start >= num.length) {
	    count++;
	}
	for (int j = start; j <= num.length - 1; j++) {
	    swap(num, start, j);
	    permute(num, start + 1);
	    swap(num, start, j);
	}
    }

    private static void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }
}
