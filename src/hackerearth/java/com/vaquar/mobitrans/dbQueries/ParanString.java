package hackerearth.java.com.vaquar.mobitrans.dbQueries;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParanString {

    private static final Map<Character, Character> braces = new HashMap<Character, Character>();
    static {
	braces.put('[', ']');
	braces.put('{', '}');
	braces.put('(', ')');
    }

    public static void main(String[] args) {

	String[] s = { "{}[]()", "{[}]}", "({[]})", "[{)]" };
	String[] result = validateBraces(s);
	for (String s1 : result) {
	    System.out.println(s1);
	}
    }

    private static String[] validateBraces(String[] values) {
	String[] result = new String[values.length];

	for (int i = 0; i < values.length; i++) {
	    result[i] = isParenthesisMatch(values[i]) ? "YES" : "NO";
	}

	return result;
    }

    public static boolean isParenthesisMatch(String str) {

	// if string is null it is always balanced
	if (str == null || str.length() == 0) {
	    return true;
	} else if ((str.length() % 2) != 0) {
	    // odd length string doesnt make sense as it should be a balanced
	    // braces ie even
	    return false;
	}

	final Stack<Character> stack = new Stack<Character>();
	for (int i = 0; i < str.length(); i++) {
	    if (braces.containsKey(str.charAt(i))) {
		stack.push(str.charAt(i));
	    } else if (stack.empty() || (str.charAt(i) != braces.get(stack.pop()))) {
		return false;
	    }
	}
	return true;
    }

}