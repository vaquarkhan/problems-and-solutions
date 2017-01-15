package algoritham.java.com.vaquar.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixPrefixPostfix {
	public static void main(String[] args) {
		/**
		 *   Infix expression
		 *   ---------------
		 *   2 + 3 
		 *   <Operand> <OPERATOR> <Operand>
		 *   Operand = Object or value on which operation is performed.
		 *           = Operand can be variable or constants
		 *           = Operand can also be again an expression which can be further divided into <Operand> <Operator> <Operand>
		 *           
		 *   Binary Operator = which requires exactly two operands to perform operation.
		 *   
		 *   
		 *   Postfix expression (Reverse polish)
		 *   ----------------------------------
		 *   2 3 + 
		 *   <Operand> <Operand> <OPERATOR> 
		 *   
		 *   Prefix expression (Polish) Should come from (Right to Left) while evaluating
		 *   -----------------------------
		 *   + 2 3 
		 *   <OPERATOR> <Operand> <Operand>  
		 *   
		 *   
		 *   Order of Operation / Precedence and Associative rule:
		 *   -------------------
		 *   1) Parentheses () {} []
		 *   2) Exponents ^  (2^3^4)  (Right to left for multiple exponents)
		 *   3) Multiplication and Devision shares same precedence and evaluated left to right associative rule.  
		 *   4) Addition and Subtraction shares same precedence and evaluated left to right.
		 *   
		 *   
		 *   A + B * c     
		 *   A + (B * C)
		 *   A + (B C *)
		 *   A B C * +
		 */
		
		
		// http://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters
		// http://stackoverflow.com/questions/16217627/string-split-at-a-meta-character
//		http://stackoverflow.com/questions/13948751/string-parse-error
//		String expression = "4+1*2+3-1/2";
//		String expression = "4+1*2";
//		String expression = "A+B*C";
//		String expression = "((A+B)*C-D)*E";
		String expression = "((2+3)*6-10)*2";
		expression = expression.replaceAll("\\+", "~+~");
		expression = expression.replaceAll("\\*", "~*~");
		expression = expression.replaceAll("-", "~-~");
		expression = expression.replaceAll("/+", "~/~");
		expression = expression.replaceAll("\\(", "~(~"); //also you can use [(] instead of \\(
		expression = expression.replaceAll("\\)", "~)~"); //also you can use [)] instead of \\)
		expression = expression.replaceAll("~~", "~");
		if(expression.startsWith("~")) {
			expression = expression.substring(1);
		}
		
		String[] expressionArray = expression.split("~");
//		System.out.println(Arrays.toString(expressionArray));
//		String postfixExpression = convertInfixToPostfix(expressionArray);
		String postfixExpression = convertInfixToPostfixWithParentheses(expressionArray);
		System.out.println(postfixExpression);
//		String prefixExpression = convertInfixToPrefix(expressionArray);
		
		String[] postfixExpressionArray = arrayConversionOfExpression(postfixExpression);
		int result = evaluatePostfix(postfixExpressionArray);
		System.out.println(result);
		
	}

	enum OperatorPrecedence {
		PLUS("+", 1) {
			@Override
			public int compute(int i, int j) {
				return i + j;
			}
		}, MINUS("-", 1) {
			@Override
			public int compute(int i, int j) {
				return i - j;
			}
		}, 
		STAR("*" , 2) {
			@Override
			public int compute(int i, int j) {
				return i * j;
			}
		}, SLASH("/" , 2) {
			@Override
			public int compute(int i, int j) {
				return i / j;
			}
		}, 
		PARENTHSIS_START("(", 0) {
			@Override
			public int compute(int i, int j) {
				return 0;
			}
		}, PARENTHSIS_END("(", 3) {
			@Override
			public int compute(int i, int j) {
				return 0;
			}
		};
		
		String operator;
		int value;
		
		private OperatorPrecedence(String operator, int value) {
			this.operator = operator;
			this.value = value;
		}
		
		public boolean isGreaterThan (OperatorPrecedence passed) {
			return this.value > passed.value;
		}
		
		public abstract int compute (int i, int j);
		
	}
	static Map<String, OperatorPrecedence> PrecedenceMap = new HashMap<String, OperatorPrecedence>(); 
	static {
		PrecedenceMap.put("+", OperatorPrecedence.PLUS);
		PrecedenceMap.put("-", OperatorPrecedence.MINUS);
		PrecedenceMap.put("*", OperatorPrecedence.STAR);
		PrecedenceMap.put("/", OperatorPrecedence.SLASH);
		PrecedenceMap.put("(", OperatorPrecedence.PARENTHSIS_START);
		PrecedenceMap.put(")", OperatorPrecedence.PARENTHSIS_END);
	}
	
	private static String convertInfixToPostfix(String[] expressionArray) {
		/**
		 * 1) If it is operand simply add it to the appender
		 * 2) We can not append the operator directly; we need to look at next operator
		 *    So put into stack
		 * 3) If next operator is lesser of the one in the top of the stack; then stack is popped out till empty and then added with this lower value.
		 *    e.g) if stack has * then + is compared then * is popped out and then + will be added into the stack. 
		 *    If next operator is equal or greater simply add it into stack.
		 */
		StringBuilder postFix = new StringBuilder();
		Stack<String> stack = new Stack<String>();
		for(String value : expressionArray) {
			 if(!PrecedenceMap.containsKey(value)) { // equals to isNumeric(String str) 
				 postFix.append(value);
			 }
			 else {
//				OperatorPrecedence prevOpr = PrecedenceMap.get(stack.peek());
//				OperatorPrecedence curOpr = PrecedenceMap.get(value);
				if(!stack.isEmpty() && PrecedenceMap.get(stack.peek()).isGreaterThan(PrecedenceMap.get(value))) {
					while(!stack.isEmpty()) {
						postFix.append(stack.pop());
					}
					stack.push(value); //Push the lower value
				} else {
					stack.push(value);
				}
			 }
		}
		while(!stack.isEmpty()) {
			postFix.append(stack.pop());
		}
		return postFix.toString();
	}
	
	private static String convertInfixToPostfixWithParentheses(String[] expressionArray) {
		/**
		 * 1) When you found closing parentheses pop operators till opening parentheses. 
		 */
		StringBuilder postFix = new StringBuilder();
		Stack<String> stack = new Stack<String>();
		for(String value : expressionArray) {
			 if(!PrecedenceMap.containsKey(value)) { // equals to isNumeric(String str) 
				 postFix.append(value);
				 postFix.append(',');
			 }
			 else {
				if(!stack.isEmpty() && PrecedenceMap.get(value) == OperatorPrecedence.PARENTHSIS_END) {
					while(!stack.isEmpty() && PrecedenceMap.get(stack.peek()) != OperatorPrecedence.PARENTHSIS_START) {
						postFix.append(stack.pop());
						postFix.append(',');
					}
					stack.pop(); //Remove OperatorPrecedence.PARENTHSIS_START
				}
				else if(!stack.isEmpty() && PrecedenceMap.get(stack.peek()).isGreaterThan(PrecedenceMap.get(value))) {
					while(!stack.isEmpty() && PrecedenceMap.get(stack.peek()) != OperatorPrecedence.PARENTHSIS_START) {
						postFix.append(stack.pop());
						postFix.append(',');
					}
					stack.push(value);
				} else {
					stack.push(value);
				}
			 }
		}
		while(!stack.isEmpty()) {
			postFix.append(stack.pop());
			postFix.append(',');
		}
		String output = postFix.toString();
		return output.substring(0, output.length() - 1);
	}
	
	private static int evaluatePostfix(String[] postfixExpressionArray) {
		Stack<Integer> stack = new Stack<Integer>();
		for(String value : postfixExpressionArray) {
			 if(!PrecedenceMap.containsKey(value)) { // equals to isNumeric(String str) 
				 stack.push(Integer.parseInt(value));
			 }
			 else {
				 //Important preserve the order.
				 int j = stack.pop(); //So J should come first
				 int i = stack.pop();
				 OperatorPrecedence operator = PrecedenceMap.get(value);
				 stack.push(operator.compute(i, j));
			 }
		}
		return stack.pop();
	}
	
	private static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    int d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	
	private static String[] arrayConversionOfExpression(String expression){
		expression = expression.replaceAll("\\,", "~");
		expression = expression.replaceAll("\\+", "~+~");
		expression = expression.replaceAll("\\*", "~*~");
		expression = expression.replaceAll("-", "~-~");
		expression = expression.replaceAll("/+", "~/~");
		expression = expression.replaceAll("\\(", "~(~"); //also you can use [(] instead of \\(
		expression = expression.replaceAll("\\)", "~)~"); //also you can use [)] instead of \\)
		expression = expression.replaceAll("~~", "~");
		if(expression.startsWith("~")) {
			expression = expression.substring(1);
		}
		return expression.split("~");
	}
}
