package hackerearth.java.com.vaquar.cyient.powOf11num1count;

public class Solution {

    public static void main(String[] args) {
	solution(1000);

    }

    public static int solution(int N) {
	int value = Solution.power(11, N);
	System.out.println(value);
	System.out.println(Solution.countOne(String.valueOf(value)));
	return N;
    }

    public static int power(int x, int n)
    {
	if (x == 1 || n == 0)
	    return 1;

	int m = power(x, n / 2);
	if (n % 2 == 0)
	    return m * m;

	return m * m * x;
    }

    public static int countOne(String s) {
	int count = 0;
	for (int i = 0; i < s.length(); i++) {
	    int j = s.charAt(i) - 48;
	    if (j == 1) {
		count++;
	    }
	}
	return count;
    }

}
