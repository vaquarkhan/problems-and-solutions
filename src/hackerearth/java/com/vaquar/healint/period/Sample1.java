package hackerearth.java.com.vaquar.healint.period;

//
//A non-empty zero-indexed string S consisting of Q characters is given. The period of this string is the smallest
//
//positive integer P such that:
//
//P â‰¤ Q / 2 and S[K] = S[K+P] for 0 â‰¤ K < Q âˆ’ P.
//
//For example, 7 is the period of â€œpepsicopepsicopepâ€�. A positive integer M is the binary period of a positive integer N if M is the period of the binary representation of N.
//
//For example, 1651 has the binary representation of "110011100111". Hence, its binary period is 5. On the other hand, 102 does not have a binary period, because its binary representation is â€œ1100110â€� and it does not have a period.
//
//Consider above scenarios & write a function in Java which will accept an integer N as the parameter. Given a positive integer N, the function returns the binary period of N. The function should return âˆ’1 if N does not have a binary period.
//
//Below I have included the solution I worked for it as well & I would like to know whether there exists any other better ways to solve it?
public class Sample1 {

    static int solution(int n) {
	int[] d = new int[30];
	int l = 0;
	int p;
	while (n > 0) {
	    d[l] = n % 2;
	    n /= 2;
	    l++;
	}
	for (p = 1; p <= (l / 2); ++p) {
	    int i;
	    boolean ok = true;
	    for (i = 0; i < l - p; ++i) {
		if (d[i] != d[i + p]) {
		    ok = false;
		    break;
		}
	    }
	    if (ok) {
		return p;
	    }
	}
	return -1;
    }

    static int getBinaryPeriodForInt(int n) {
	int[] d = new int[30];
	int l = 0, res = -1;
	while (n > 0) {
	    d[l] = n % 2;
	    n /= 2;
	    l++;
	}

	for (int p = 1; p < l; p++) {
	    if (p <= l / 2) {
		boolean ok = true;
		for (int i = 0; i < l - p; i++) {
		    if (d[i] != d[i + p]) {
			ok = false;
			break;
		    }
		}
		if (ok) {
		    res = p;
		}
	    }
	}

	return res;
    }

    public static void main(String[] args) {
	System.out.println("\nEx1: " + solution(102));
	System.out.println("\nEx2: " + solution(1651));
	System.out.println("\nEx3: " + solution(955));
    }

}
