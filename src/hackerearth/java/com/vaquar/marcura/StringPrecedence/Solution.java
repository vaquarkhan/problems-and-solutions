package hackerearth.java.com.vaquar.marcura.StringPrecedence;

class Solution {
    public static int solution(String S1, String S2) {

	S1 = S1.toUpperCase();
	S2 = S2.toUpperCase();

	int result = S1.compareTo(S2);
	if (result < 0) {
	    return -1;
	} else if (result > 0) {
	    return 1;
	} else {
	    return 0;
	}

    }

    public static void main(String[] args) {
	System.out.println(solution("sfdility", "cod"));
    }
}
