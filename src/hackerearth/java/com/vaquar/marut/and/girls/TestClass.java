package hackerearth.java.com.vaquar.marut.and.girls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestClass {

    public static void main(String args[]) throws Exception {
	Scanner in = new Scanner(System.in);
	int M = in.nextInt();
	List<Integer> qualities = new ArrayList<Integer>();
	String qualitiesStr = "";
	while (in.hasNext()) {
	    qualitiesStr = in.nextLine();
	    if (!qualitiesStr.isEmpty()) {
		break;
	    }
	}
	String[] qualitiesBit = qualitiesStr.split(" ");

	for (String quality : qualitiesBit) {
	    qualities.add(Integer.parseInt(quality));

	}

	int N = in.nextInt();
	int countResult = 0;

	for (int n = 0; n < N; n++) {
	    String girlQualitiesStr = "";
	    while (in.hasNext()) {
		girlQualitiesStr = in.nextLine();
		if (!girlQualitiesStr.isEmpty()) {
		    break;
		}
	    }
	    String[] bits = girlQualitiesStr.split(" ");
	    List<Integer> girlQualities = new ArrayList<Integer>();
	    for (String girlQuality : bits) {
		girlQualities.add(Integer.parseInt(girlQuality));

	    }
	    if (girlQualities.containsAll(qualities)) {
		countResult++;
	    }

	}

	System.out.println(countResult);

    }

}
