package algoritham.java.com.vaquar.string;
public class Anagrams {
	public static void main(String[] args) {
		int k = 4;
		printAnagrams("ABCDE".toCharArray(), k);
	}

	public static void printAnagrams(char[] set, int anagramLength) {
		int inputLength = set.length;
		printAnagrams(set, "", inputLength, anagramLength);
	}

	public static void printAnagrams(char[] set, String angram, int inputLength,
			int anagramLength) {

		if (anagramLength == 0) {
			System.out.println(angram);
			return;
		}

		for (int i = 0; i < inputLength; ++i) {
			String newPrefix = angram + set[i];
			
//			char[] newset = new char[set.length];
//			for(int itr = 0; itr < set.length; itr++) {
//				if(itr < i){
//				newset[itr] = set[itr]; }
//				else if (itr == i){
//					continue;
//				}
//				else {
//					newset[itr-1] = set[itr];
//				}
//			}

			StringBuilder s = new StringBuilder(new String(set));
            s.deleteCharAt(i);
            printAnagrams(s.toString().toCharArray(), newPrefix, s.toString().toCharArray().length, anagramLength - 1);
		}
	}
}
