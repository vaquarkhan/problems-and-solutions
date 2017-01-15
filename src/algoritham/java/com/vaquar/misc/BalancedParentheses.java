package algoritham.java.com.vaquar.misc;

import java.util.Arrays;

public class BalancedParentheses {
	public static void main(String[] args) {
		String[] values = {"{{[()]}}", "}][{", "({[]})"};
		System.out.println(Arrays.toString(isBalancedParentheses(values)));
	}
	
	static java.util.Map<Character, Character> operatorPartnerMap = new java.util.HashMap<Character, Character>();
    static void buildMap(){
    	operatorPartnerMap.put('{', '}');
    	operatorPartnerMap.put('[', ']');
    	operatorPartnerMap.put('(', ')');
    }
    static String[] isBalancedParentheses(String[] values) {
    	buildMap();
    	String[] result = new String[values.length];
    	for(int i = 0; i < values.length; i++) {
    		String input = values[i];
    		java.util.Stack<Character> stack = new java.util.Stack<Character>();
    		stack.push(input.charAt(0));
    		for(int j = 1; j < input.length(); j++) {
    			if(!stack.isEmpty() && 
    					(Character)input.charAt(j) == operatorPartnerMap.get(stack.peek())) { //Note casting is needed to avoid NPE due to charValue()
    				stack.pop();
       			} else {
    				stack.push(input.charAt(j));
    			}
    		}
    		if(stack.size() != 0) {
    			result[i] = "NO";
    		} else {
    			result[i] = "YES";
    		}
    	}
    	return result;
    }
}
