package hackerrank1.java.com.vaquar.codechef.feb2015;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @see http://www.codechef.com/FEB15/problems/STFM
 *
 */
public class ChefAndStrangeFormula {
	static BigInteger[] dp = new BigInteger[7000 + 1];
	static BigInteger[] cache = new BigInteger[7000 + 1];
	static BigInteger TWO = BigInteger.valueOf(2L);

	public static BigInteger solve(BigInteger[] in, BigInteger mod) {
		BigInteger sum = BigInteger.ZERO;
		for (BigInteger val : in) {
			sum = sum.add(f(val.longValue(), mod.longValue()));
		}
		return sum.mod(mod);
	}

	static BigInteger f(long x, long mod) {
		BigInteger res = BigInteger.ZERO;
		for (int i = 1; i <= x; i++) {
			// BigInteger a =
			// BigInteger.valueOf(i).multiply(factorial(i).add(BigInteger.valueOf(x)));
			BigInteger a = BigInteger.valueOf(i).multiply(F(i).add(BigInteger.valueOf(x)));

			res = res.add(a);
		}

		return res;
	}

	public static BigInteger F(long n) {
		long a = 0;
		long s = 0;
		BigInteger P = BigInteger.ONE;
		BigInteger Q = BigInteger.ONE;
		long b = 1;
		for (int i = fL2((int) (n / 2)); i >= 0; i--) {
			a = n >> i;
			s = s + a / 2;
			a = a - 1 | 1;
			P = Q.multiply(P);
			Q = OddP(a, b).multiply(Q);
			b = a + 2;
		}
		return Q.multiply(P).shiftLeft((int) s);
	}

	private static BigInteger OddP(long a, long b) {
		if (a == b)
			return BigInteger.valueOf(a);
		long m = (a + b) / 2;
		m += m & 1;
		return OddP(a, m + 1).multiply(OddP(m - 1, b));
	}

	private static int fL2(int n) {
		int i = -1;
		for (; n > 0; n /= 2)
			i++;
		return i;
	}

	public static BigInteger factorial(int n) {
		if (n == 0) {
			return BigInteger.ONE;
		} else if (n < dp.length && dp[n] != null) {
			return dp[n];
		}
		if (n >= dp.length) {
			return BigInteger.valueOf(n).multiply(factorial(n - 1));
		}
		return dp[n] = BigInteger.valueOf(n).multiply(factorial(n - 1));
	}

	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		BigInteger mod = sc.nextBigInteger();
		BigInteger[] in = sc.nextBigIngtegerArray();
		out.println(solve(in, mod));
		out.close();
	}

	private static class FastScanner {

		private static BufferedReader reader;
		private static StringTokenizer tokenizer;

		public FastScanner(InputStream in) throws Exception {
			reader = new BufferedReader(new InputStreamReader(in));
			tokenizer = new StringTokenizer(reader.readLine().trim());
		}

		public int numTokens() throws Exception {
			if (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine().trim());
				return numTokens();
			}
			return tokenizer.countTokens();
		}

		public boolean hasNext() throws Exception {
			if (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine().trim());
				return hasNext();
			}
			return true;
		}

		public String next() throws Exception {
			if (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine().trim());
				return next();
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		public float nextFloat() throws Exception {
			return Float.parseFloat(next());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		public int[] nextIntArray() throws Exception {
			String[] line = reader.readLine().trim().split(" ");
			int[] out = new int[line.length];
			for (int i = 0; i < line.length; i++) {
				out[i] = Integer.valueOf(line[i]);
			}
			return out;
		}

		public double[] nextDoubleArray() throws Exception {
			String[] line = reader.readLine().trim().split(" ");
			double[] out = new double[line.length];
			for (int i = 0; i < line.length; i++) {
				out[i] = Double.valueOf(line[i]);
			}
			return out;
		}

		public Integer[] nextIntegerArray() throws Exception {
			String[] line = reader.readLine().trim().split(" ");
			Integer[] out = new Integer[line.length];
			for (int i = 0; i < line.length; i++) {
				out[i] = Integer.valueOf(line[i]);
			}
			return out;
		}

		public BigInteger[] nextBigIngtegerArray() throws Exception {
			String[] line = reader.readLine().trim().split(" ");
			BigInteger[] out = new BigInteger[line.length];
			for (int i = 0; i < line.length; i++) {
				out[i] = new BigInteger(line[i]);
			}
			return out;
		}

		public BigInteger nextBigInteger() throws Exception {
			return new BigInteger(next());
		}

		public String nextLine() throws Exception {
			return reader.readLine().trim();
		}

		public long[] nextLongArray() throws Exception {
			String[] line = reader.readLine().trim().split(" ");
			long[] out = new long[line.length];
			for (int i = 0; i < line.length; i++) {
				out[i] = Long.valueOf(line[i]);
			}
			return out;
		}
	}
}
