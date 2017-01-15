package hackerearth.java.com.vaquar.mobitrans.Pairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {

	int count = 0;
	int leftIndex = 0;
	int rightIndex = 0;
	Scanner in = new Scanner(System.in);
	List<Integer> integerList = new ArrayList<Integer>();
	int N = in.nextInt();
	int K = in.nextInt();
	for (int i = 0; i < N; i++) {
	    integerList.add(in.nextInt());
	}
	Collections.sort(integerList);

	while (rightIndex < N)
	{
	    if (integerList.get(rightIndex) - integerList.get(leftIndex) == K)
	    {
		count++;
		leftIndex++;
		rightIndex++;
	    }
	    else if (integerList.get(rightIndex) - integerList.get(leftIndex) > K)
		leftIndex++;
	    else
		rightIndex++;
	}
	System.out.println(count);
    }
}