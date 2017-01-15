package algoritham.java.com.vaquar.misc;

/**
 * 
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-249-telephonic-
 * interview/ I/p: I work at xyz O/p: xyz at work I
 * 
 * 
 *
 */
public class DisplayTheWordsInReverseOrder {
	public static void main(String[] args) {
		String input = "I work at xyz";
		String output = getTheWordsInReverseOrder(input);
		System.out.println(output);
	}

	private static String getTheWordsInReverseOrder(String input) {
		String[] words = input.split(" ");
		StringBuilder br = new StringBuilder();
		for(int i = words.length-1; i >= 0; i--) { //Important for > operator in reverse order.
			br.append(words[i]);
			br.append(" ");
		}
		return br.toString();
	}
}
