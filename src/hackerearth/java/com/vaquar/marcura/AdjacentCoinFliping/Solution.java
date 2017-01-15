package hackerearth.java.com.vaquar.marcura.AdjacentCoinFliping;

class Solution {
    public static int solution(int[] A) {
	int n = A.length;
	int result = 0;
	for (int i = 0; i < n - 1; i++) {
	    if (A[i] == A[i + 1])
		result = result + 1;
	}
	int r = 0;
	for (int i = 0; i < n; i++) {
	    int count = 0;
	    if (i > 0) {
		if (A[i - 1] != A[i])
		    count = count + 1;
		else
		    count = count - 1;
	    }
	    if (i < n - 1) {
		if (A[i + 1] != A[i])
		    count = count + 1;
		else
		    count = count - 1;
	    }
	    r = Math.max(r, count);
	}
	// Below code require JDK 8, uncomment it once JDK 8 is installed
	// return ( ( (int) java.util.Arrays.stream(A).filter(p -> p ==
	// 0).count()==0 && (int) java.util.Arrays.stream(A).filter(p -> p ==
	// 1).count()>0) || ( (int) java.util.Arrays.stream(A).filter(p -> p ==
	// 1).count()==0 && (int) java.util.Arrays.stream(A).filter(p -> p ==
	// 0).count()>0) ) ? result + r-1 : result + r;
	return 0;
    }

    public static void main(String[] args) {
	System.out.println(solution(new int[] { 1, 1, 0, 1, 0, 0 }));
    }
}
