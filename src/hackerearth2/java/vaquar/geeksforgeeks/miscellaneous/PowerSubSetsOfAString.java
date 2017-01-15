package hackerearth2.java.vaquar.geeksforgeeks.miscellaneous;

public class PowerSubSetsOfAString {

	public static void main(String[] args) {
		String str = "abcd";
		long currentTimeMillis = System.currentTimeMillis();
		possibleSubStringsOfAString(str);
		powerSubSetOfAString(str);

	}

	/**
	 * This method is used to calculate all the possible sub strings of a
	 * String(Power sub sets)
	 * 
	 * Example: S = {abc} P(S) = {}, {c}, {b}, {bc}, {a}, {ac}, {ab}, {abc}
	 * 
	 * @param str
	 */
	private static void powerSubSetOfAString(String str) {
		int strLength = str.length();
		int powerSetSize = (int) Math.pow(2, strLength);
		StringBuilder result = new StringBuilder();
		// Set<String> resultSet = new LinkedHashSet<String>();
		for (int i = 0; i < powerSetSize; i++) {
			String binary = intToBinary(i, strLength);
			// Set<String> innerSet = new LinkedHashSet<String>();
			StringBuilder inner = new StringBuilder();
			for (int j = 0; j < binary.length(); j++) {
				if (binary.charAt(j) == '1') {
					inner.append(str.charAt(j));
				}
			}
			result.append("{").append(inner).append("},");
		}
		System.out.println(result);
	}

	/**
	 * Converts the given integer to a String representing a binary number with
	 * the specified number of digits For example when using 4 digits the binary
	 * 1 is 0001
	 * 
	 * @param number
	 * @param digits
	 * @return binaryString
	 */
	private static String intToBinary(int number, int digits) {
		String binaryString = Integer.toBinaryString(number);
		int convertedLength = binaryString.length();

		for (int i = convertedLength; i < digits; i++) {
			binaryString = "0" + binaryString;
		}
		return binaryString;
	}

	/**
	 * This method is used to get all the possible substrings of a string.
	 * 
	 * Example: S = {abc} P(S) = {c}, {b}, {bc}, {a}, {ab}, {abc}
	 * 
	 * @param str
	 */
	private static void possibleSubStringsOfAString(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {

			for (int j = i + 1; j <= str.length(); j++) {

				String sub = str.substring(i, j);
				res.append("{").append(sub).append("},");

			}
		}
		System.out.println(res);

	}

}
