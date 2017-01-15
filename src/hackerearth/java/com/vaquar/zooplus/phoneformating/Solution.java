package hackerearth.java.com.vaquar.zooplus.phoneformating;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
	Solution solution = new Solution();
	solution.solution("1234");
    }

    public String solution(String S) {
	if (S == null || S.isEmpty() || S.length() <= 3) {
	    System.out.println(S);
	    return S;
	}
	char[] charArray = S.toCharArray();

	List<Character> charList = new ArrayList<Character>();
	StringBuilder sb = new StringBuilder();
	int count = 0;

	for (int i = 0; i < charArray.length; i++) {

	    if (Character.isDigit(charArray[i])) {
		charList.add(charArray[i]);
	    }
	}
	if (charList.size() == 4) {
	    sb.append(charList.get(0));
	    sb.append(charList.get(1));
	    sb.append("-");
	    sb.append(charList.get(2));
	    sb.append(charList.get(3));

	} else {
	    for (int i = 0; i < charList.size(); i++) {
		sb.append(charList.get(i));
		count++;
		if (count == 3 && (i != (charList.size() - 1))) {
		    sb.append("-");
		    count = 0;
		    if (charList.size() - (i + 1) == 4) {
			sb.append(charList.get(i + 1));
			sb.append(charList.get(i + 2));
			sb.append("-");
			sb.append(charList.get(i + 3));
			sb.append(charList.get(i + 4));
			break;
		    }

		}
	    }
	}

	System.out.println(sb.toString());
	return sb.toString();
    }

}
