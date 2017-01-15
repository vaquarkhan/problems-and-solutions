package hackerearth.java.com.vaquar.superprofs.palin.pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestClass {
    public static void main(String args[]) throws Exception {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	Map<String, Integer> map = new HashMap<String, Integer>();
	List<String> strList = new ArrayList<String>();
	for (int n = 0; n < N; n++) {

	    String str = sc.next();
	    strList.add(str);
	}

	for (int i = 0; i < strList.size() - 1; i++) {
	    int count = 0;
	    for (int j = i + 1; j < strList.size(); j++) {
		if (strList.get(i).equals(reverse(new StringBuilder(strList.get(j))))) {
		    count++;
		}
	    }
	    if (count != 0)
		System.out.println(count);
	}

    }

    public static String reverse(StringBuilder str) {
	return str.reverse().toString();
    }
}
