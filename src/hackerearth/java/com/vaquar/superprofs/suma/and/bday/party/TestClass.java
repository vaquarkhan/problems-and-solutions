package hackerearth.java.com.vaquar.superprofs.suma.and.bday.party;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestClass {
    public static void main(String args[]) throws Exception {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	Set<Integer> selectedList = new HashSet<Integer>();
	Set<Integer> optionalList = new HashSet<Integer>();
	for (int t = 0; t < T; t++) {
	    int N = sc.nextInt();
	    int K = sc.nextInt();
	    for (int n = 0; n < N; n++) {
		boolean selectedFlag = false;
		String str = sc.next();
		char[] charStr = str.toCharArray();
		for (int k = 0; k < charStr.length; k++) {
		    int dishFlag = Integer.parseInt("" + charStr[k]);
		    if (dishFlag == 1 && (selectedList.contains(k) || optionalList.contains(k)) && selectedFlag == false) {
			if (optionalList.contains(k)) {
			    selectedList.add(k);
			    selectedFlag = true;
			    if (optionalList.contains(k)) {
				optionalList.remove(k);
			    }
			}
			continue;
		    } else if (dishFlag == 1 && selectedFlag == false) {
			selectedList.add(k);
			selectedFlag = true;
			if (optionalList.contains(k)) {
			    optionalList.remove(k);
			}
		    } else if (dishFlag == 1 && selectedFlag == true) {
			optionalList.add(k);
		    }

		}
	    }
	    System.out.println(selectedList.size());
	}

    }
}
