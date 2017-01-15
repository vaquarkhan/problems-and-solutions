package algoritham.java.com.vaquar.misc;
import java.util.Arrays;

public class NextPalindromeForGivenNumber {
	public static void main(String[] args) {
//		int number = 10203;
//		int number = 1232347;
//		int number = 9742367;
//		int number = 2345434;
//		int number = 2349434;
//		int number = 2305012;
//		int number = 2305034;
//		int number = 2309034;
//		int number = 230034;
//		int number = 15451;		
//		int number = 9632369;
//		int number = 121;
//		int number = 10200; // even digit
		int number = 999;

		int[] numberArray = getNumberAsArray(number); 
		if(isPolindrome(numberArray)) {
			number += 1;
			numberArray = getNumberAsArray(number); 
		}
		System.out.println("For input: " + number + ", Next palindrome is: " +Arrays.toString(makePolindromeSolution1(numberArray)));
		System.out.println("For input: " + number + ", Next palindrome is: " +Arrays.toString(makePolindromeSolution2(numberArray)));
	}
	
	
	/**
	 * Solution 1
	 * @param numberArray
	 * @return
	 */
	private static int[] makePolindromeSolution1(int[] numberArray) {
		int mid = ((numberArray.length-1) / 2);
		int i = 0;
		int j = 0;
		boolean isEven = !isOdd(numberArray.length);
		if(isEven){ 
			i = mid;
			j = mid+1;
		} else { //isOdd
			i = mid - 1;
			j = mid + 1;
		}
		
		for(; i >= 0; i--, j++) {
			if(numberArray[i] != numberArray[j]) {
				boolean flag = false;
				if(numberArray[i] < numberArray[j]) {
					flag = true;
				}
				
				for(; i >= 0; i--, j++) {
					numberArray[j] = numberArray[i];
				}
				if(flag) {
					increamentMidByOne(numberArray, mid, isEven);
				}
			}
		}
		return numberArray;		
	}
	

	private static void increamentMidByOne(int[] numberArray, int mid, boolean isEven) {
		int carry = 0;
		int j = numberArray.length - 1;
		int i = mid;
		int additonValue =  numberArray[mid] + 1 + carry;
		if(additonValue >= 10) {
			numberArray[i] = additonValue % 10;
			if(isEven) {
				numberArray[j-i] = additonValue % 10;
			}
			i--;
			carry = additonValue / 10;
		} else {
			carry = 0;
			numberArray[i] = additonValue;
			if(isEven) {
				numberArray[j-i] = additonValue;
			}
		}
		
		while(carry > 0) {
			additonValue = numberArray[i] + carry;
			if(additonValue >= 10) {
				numberArray[i] = additonValue % 10;
				numberArray[j-i] = numberArray[i];
				carry = additonValue / 10;
				i--;
			} else {
				carry = 0;
				numberArray[i] = additonValue;
				numberArray[j-i] = numberArray[i];
			}
		}
	}


	private static boolean isOdd(int value) {
		return (value & 1) == 1;
	}


	/**
	 * Solution 2
	 * @param numberArray
	 * @return
	 */
	private static int[] makePolindromeSolution2(int[] numberArray) {
		for(int i = 1, j = numberArray.length; i < j; i++,j--) {
			if(numberArray[i-1] != numberArray[j-1]) {
				int value = 0;
				if(numberArray[i-1] < numberArray[j-1] ) {
					value = (int)Math.pow(10, i) + numberArray[i-1] - getSubNumberFromLast(numberArray, j-1);
				} else {
					value = (int)Math.pow(10, i-1) * numberArray[i-1] - getSubNumberFromLast(numberArray, j-1); 
				}
				
				numberArray = sum(numberArray, value, true); //sum(numberArray, value)
				return makePolindromeSolution2(numberArray);
			}
		}
		return numberArray;		
	}

	private static int[] sum(int[] numberArray, int value, boolean withoutUsingNumber) {
		int[] valueArray =  getNumberAsArray(value);
		int carry = 0;
		int j = numberArray.length - 1;
		for(int i = valueArray.length - 1; i >= 0; i--, j--) {
			int additonValue =  numberArray[j] + valueArray[i] + carry;
			if(additonValue >= 10) {
				numberArray[j] = additonValue % 10;
				carry = additonValue / 10;
			} else {
				carry = 0;
				numberArray[j] = additonValue;
			}
		}
		
		while(carry > 0) {
			int additonValue = numberArray[j] + carry;
			if(additonValue >= 10) {
				numberArray[j] = additonValue % 10;
				carry = additonValue / 10;
				j--;
			} else {
				carry = 0;
				numberArray[j] = additonValue;
			}
		}
		
		return numberArray;
	}
	
	private static int[] sum(int[] numberArray, int value) {
		int sum = getArrayAsNumber(numberArray) + value;
		return getNumberAsArray(sum);
	}

	private static boolean isPolindrome(int[] numberArray) {
		for(int i = 0, j = numberArray.length-1; i < j; i++,j--) {
			if(numberArray[i] != numberArray[j]) {
				return false;
			}
		}
		return true;
	}

	private static int[] getNumberAsArray(int number) {
		int[] numberArray = new int[(""+number).length()];
		for(int i = numberArray.length - 1;  i >= 0; i--) {
			numberArray[i] = number % 10;
			number = number / 10;
		}
		return numberArray;
	}
	
	private static int getArrayAsNumber(int[] array) {
		int value = 0;
		for(int i = array.length - 1, j = 0; i >= 0; j++, i--) {
			value = value + (array[i] * (int)Math.pow(10, j));
		}
		return value;
	}
	
	private static int getSubNumberFromLast(int number, int tillPosition) {
		int length = (""+number).length();
		int value = 0;
		for(int i = length - 1, j = 0;  i >= tillPosition; i--, j++) {
			value += ((number % 10) * ((int)Math.pow(10, j)));
			number = number / 10;
		}
		return value;
	}
	
	private static int getSubNumberFromLast(int[] numberArray, int startPosition, int endPosition) {
		int value = 0;
		for(int i = numberArray.length - 1, j = 0;  i >= endPosition; i--, j++) {
			value += ((numberArray[i]) * ((int)Math.pow(10, j)));
		}
		return value;
	}
	
	private static int getSubNumberFromLast(int[] numberArray, int tillPosition) {
		int value = 0;
		for(int i = numberArray.length - 1, j = 0;  i >= tillPosition; i--, j++) {
			value += ((numberArray[i]) * ((int)Math.pow(10, j)));
		}
		return value;
	}
	
	private static int getADigit(int number, int atPosition) {
		return (number >> (atPosition-1)) & 1;
	}
	

}
