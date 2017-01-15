package algoritham.java.com.vaquar.primitiveTypes;

public class BitManipulation {
	public static void main(String[] args) {
		
		
		int value = 1;
		int i = 15;
		System.out.println("Example on multiplying the value by 2: " + value); 
		while( i-- != 0) {
		//Value will doubled   e.g. X << 1 = 2X	 
		value = value << 1;
		System.out.print("  " + value); 
		}
		
		System.out.println("Example on dividing the value by 2: " + value);
		while( i++ != 15) {
		System.out.println(value);
		//Value will be divided by 2  e.g  X >> 1 = X/2
		value = value >> 1;
		System.out.print("  " + value); 
		}
		
		//After printing zero it will continue printing the same zero 
		System.out.println(value);
		value = value >> 1;
		System.out.println(value);
		
		//Positive whole number one will be printed not 1.5
		System.out.println(3 >> 1);
		
		 //Check any particular bit is set(1) or not (0) then
		 int thirdBitTobeChecked =   1 << 2;   // (...0000100)
		 int onWhichThisHasTobeTested = 5;     // (.......101)

		 int isBitSet = onWhichThisHasTobeTested  & thirdBitTobeChecked;
		 if(isBitSet > 0) {
		  //Third Bit is set to 1 
		 } 
		 
		 //Set(1) a particular bit
		 int thirdBitTobeSet =   1 << 2;       // (...0000100)
		 int onWhichThisHasTobeSet = 2  ;      // (.......010)
		 onWhichThisHasTobeSet |= thirdBitTobeSet;
		 
		 //ReSet(0) a particular bit
		 int thirdBitTobeReSet =   ~(1 << 2);   //(...1111011)
		 int onWhichThisHasTobeReSet = 6  ;     //(.....000110)
		 onWhichThisHasTobeReSet &= thirdBitTobeReSet;
		 
		//XOR
		//Just note that if you perform XOR operation twice, will results the same value.
		byte toBeEncrypted = (byte) 00100110;
		byte salt          = (byte) 01001011;
		byte encryptedVal  = (byte) (toBeEncrypted ^ salt);  // == 01101101
		byte decryptedVal  = (byte) (encryptedVal  ^ salt);   //== 0010 0110 == toBeEncrypted :)
		
		
		value = 1234567;
		//What's the k-th digit of x?  (x >> (k-1)) & 1
		System.out.println("Value :" + value);
		System.out.println((value >> (3-1)) & 1);
		
		
		//Is a number odd? (I.e., Is the last digit 1?) 	(x & 1) == 1
		System.out.println((value & 1) == 1);
		
		
		//What's the last k digits of x? 	x & (1 << k - 1)
		System.out.println(value & (1 << 4 - 1));
		
		//What's the last 3 digits of x? 	x & 0x111
		System.out.println(value & 0x111);
		
		//Set the k-th digit to 0, e.g. 0x101101 -> 0x101001, k=3
		//x & ~(1 << (k-1))
//		System.out.println(value & ~(1 << (k-1)));
		
		
		//Is a number pow of 2?
		value = 512;
		System.out.println("Is 512 is pow of 2?- " + ((value != 0) && ((value & (value-1)) == 0)));
		

		//Flip the last continuous 1's to 0's, e.g. 0b10101111 -> 0b10100000
		//x & (x+1)
		//or (|) operator - "is any of them 1?" */

		
		
		
		
		//Set the last digit to 1
		//x | 1
		
		//Set the number to its closest even number (i.e. set the last digit to 0)
		//(x | 1) - 1
		
		//Set the k-th digit to 1, e.g. 0b101001 -> 0b101101, k=3
		// x | (1 << (k-1))
		
		//Set the last k digits to 1, e.g. 0b101001 -> 0b101111, k=3
		//x | (1 << k - 1)
		
		//Flip the last continuous 0's to 1's, e.g. 0b10110000 -> 0b10111111
		//x | (x-1)
		
		//Flip the first 0 to 1 (starting from right), e.g. 0b10101011 -> 0b10101111
		//x | (x+1)
		//xor (^) operator - "are they different?"

		
		
		//Also, notice that xor's inverse operation is itself! That is, (x ^ y) ^ x = y
		
		//Flip k-th digit
		//x ^ (1 << (k-1))
		
		//Flip last k digits
		//x ^ (1 << k - 1)
		
		//Get the last continuous 1's, e.g. 0b10101111 -> 0b1111
		//(x ^ (x+1)) >> 1
		
		//Remove the left of the first 1 from the right, e.g. 0b10101000 -> 0b1000
		//(x ^ (x-1)) >> 1 + 1   or   x ^ (x-1) & x
		
		//Swap two numbers
		//One way to swap two numbers is to use + and - (two inverse operations):
		//a = a + b;  b = a - b;  a = a - b;
		//And we can use xor and since its inverse operation is itself:
		//a = a ^ b;  b = a ^ b;  a = a ^ b;
		
		
		//not (~) operator

		//~0 = 1,  ~1 = 0
		
		//Flip all digits of an unsigned number
		//~x
		
		// shifting (>>, <<) operators
		// x >> k, shift right by k digits, i.e. divide by 2^k (note: ^ is not xor here... :)
		// x << k, shift left by k digits, i.e. multiple by 2^k
		
		//Remove the last digit
		//x >> 1
		//Add a 0 to the end of a number
		//x << 1
		//Add an 1 to the end of a number
		//x << 1 + 1

		
		
		/*
		 * TODO
		 * 1. program to perform 2's complement & when it is used
		 * 2. program to convert Binary to HEX to Decimal to Octal 
		 */
		
	}
}
