package algoritham.java.com.vaquar.string;

/**
 * Courtesy
 * https://www.careercup.com/question?id=8641795 by Vaclav
 * 
 * http://stackoverflow.com/questions/15045640/how-to-check-if-two-words-are-anagrams
 * 
 * Fastest algorithm would be to map each of the 26 English characters to a unique prime number.
 * Then calculate the product of the string. 
 * By the fundamental theorem of arithmetic, 
 * 2 strings are anagrams if and only if their products are the same.
 * 
 * By SeriousBusiness
 * 
 * 
 *
 */
public class TwoWordsAreAnagram {
	public static void main(String[] args) {
		String[] in = { "node", "salvador dali", "stream" };
		String[] out = { "done", "avida dollars", "master" };
		for(int i = 0; i< in.length; i++){
			boolean result = isAnagram(in[i], out[i]);
			System.out.println(result);
		}
		
	}

	private static boolean isAnagram(String string1, String string2) {
		if(string1 == null || string2 == null || string1.length() != string2.length()) {
			return false;
		}
		int[] characters = new int[256];
		for(int i = 0; i< string1.length(); i++){
//			characters[string1.charAt(i)] += 1; 
//			characters[string2.charAt(i)] -= 1; 
			//The below is the same like above
			characters[string1.charAt(i)]++; 
			characters[string2.charAt(i)]--; 
		}
		for(int i = 0; i< string1.length(); i++){
			if(characters[i] != 0) {
				return false;
			} 
		}
		return true;
	}
	
//	by Makoto
//	public boolean isAnagram(String firstWord, String secondWord) {
//	     char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
//	     char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
//	     Arrays.sort(word1);
//	     Arrays.sort(word2);
//	     return Arrays.equals(word1, word2);
//	}

	
	
//	by jb.
//	If you sort either array, the solution becomes O(n log n). but if you use a hashmap, it's O(n). tested and working.
//	char[] word1 = "test".toCharArray();
//	char[] word2 = "tes".toCharArray();
//
//	Map<Character, Integer> lettersInWord1 = new HashMap<Character, Integer>();
//
//	for (char c : word1) {
//	    int count = 1;
//	    if (lettersInWord1.containsKey(c)) {
//	        count = lettersInWord1.get(c) + 1;
//	    }
//	    lettersInWord1.put(c, count);
//	}
//
//	for (char c : word2) {
//	    int count = -1;
//	    if (lettersInWord1.containsKey(c)) {
//	        count = lettersInWord1.get(c) - 1;
//	    }
//	    lettersInWord1.put(c, count);
//	}
//
//	for (char c : lettersInWord1.keySet()) {
//	    if (lettersInWord1.get(c) != 0) {
//	        return false;
//	    }
//	}
//
//	return true;
}
