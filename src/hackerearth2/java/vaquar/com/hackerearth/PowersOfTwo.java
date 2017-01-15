package hackerearth2.java.vaquar.com.hackerearth;

public class PowersOfTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
	}

	private static void firstApproach() {
		long n = 1000000;
		long count = 0;
		
		for (long i = 1; i < n; i++) {
			for (long j = i+1; j <= n; j++) {
				long divisor = (long) (Math.pow(2, i) - 1);
				long divident = (long) (Math.pow(2, j) - 1);
				if (divident % divisor == 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
