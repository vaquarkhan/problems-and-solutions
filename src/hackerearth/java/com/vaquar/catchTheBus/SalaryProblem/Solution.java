package hackerearth.java.com.vaquar.catchTheBus.SalaryProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception {
	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	List<String> stringList = new ArrayList<String>();
	for (int i = 0; i < t; i++) {
	    int n = in.nextInt();
	    in.nextLine();
	    String line1 = in.nextLine();
	    String line2 = in.nextLine();
	    String[] line1arr = line1.split(" ");
	    String[] line2arr = line2.split(" ");

	    for (int j = 0; j < line1arr.length; j++) {
		if (!line1arr[j].equalsIgnoreCase(line2arr[j])) {
		    stringList.add(line2arr[j] + " " + line1arr[j]);
		    break;
		}
	    }
	}
	Collections.reverse(stringList);
	for (String str : stringList) {
	    System.out.println(str);
	}

    }

}
