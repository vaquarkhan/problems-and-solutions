package algoritham.java.com.vaquar.search;

public class RabinKarpSubstringSearch_PatternMatching {
	
	/**
	 * A hashtable works by taking the modulus of the hash over the number of buckets.

		It's important in a hashtable not to produce collisions for likely cases, 
		since collisions reduce the efficiency of the hashtable.

		Now, suppose someone puts a whole bunch of values into a hashtable
		 that have some relationship between the items, like all having the same first character.
		  This is a fairly predictable usage pattern, 
		  I'd say, so we don't want it to produce too many collisions.
		  
	 * Input       Modulo 8    Modulo 7
		0           0           0
		4           4           4
		8           0           1
		12          4           5
		16          0           2
		20          4           6
		24          0           3
		28          4           0
		
	* Input       Modulo 9    Modulo 7
		0           0           0
		3           3           3
		6           6           6
		9           0           2
		12          3           5
		15          6           1
		18          0           4
		21          3           0


	 * @param args
	 */
	
	public static void main(String[] args) {
		String input = "ABCDABCEBCRBBA";
		String substring = "BCR";
		System.out.println(isPatternMatches(input, substring));
	}

	private static boolean isPatternMatches(String input, String substring) {
		int hashValueOfSubString = findTheInitialHash(substring, substring.length());
		int hashValueOfInputString = findTheInitialHash(substring, substring.length());
		char [] inputCharArray = input.toCharArray();
		
		for(int i = substring.length(); i < input.length(); i ++){
			hashValueOfInputString = findTheRollingHash(substring, i, i-substring.length(), hashValueOfInputString);
		}
		return false;
	}

	private static int findTheRollingHash(String substring, int i, int j, int hashValueOfInputString) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int findTheInitialHash(String substring, int length) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
