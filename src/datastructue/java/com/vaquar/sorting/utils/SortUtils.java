package datastructue.java.com.vaquar.sorting.utils;

import java.util.Random;

public class SortUtils {

	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public static boolean less(int a, int b) {
		return a < b;
	}

	public static void exchange(Comparable array[], int from, int to) {

		Comparable temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}

	public static void exchange(int[] input, int i, int r) {
		int temp = input[i];
		input[i] = input[r];
		input[r] = temp;
	}

	public static String arrayToString(Comparable[] array) {

		if (array == null) {
			return "NULL ARRAY";
		}

		StringBuilder builder = new StringBuilder();
		for (Comparable eachItem : array) {
			builder.append(eachItem).append(" : ");
		}

		return builder.toString();
	}

	public static String arrayToString(int[] input) {
		if (input == null) {
			return "NULL ARRAY";
		}

		StringBuilder builder = new StringBuilder();
		for (int eachItem : input) {
			builder.append(eachItem).append(" : ");
		}

		return builder.toString();

	}
	
	
	public static String intArrayToString3Space(int[] input) {
		if (input == null) {
			return "NULL ARRAY";
		}

		StringBuilder builder = new StringBuilder();
		for (int eachItem : input) {
			builder.append(eachItem).append("    :    ");
		}

		return builder.toString();

	}
	
	public static String traceArrayToString3Space(String[] traceArray) {
		if (traceArray == null) {
			return "NULL ARRAY";
		}

		StringBuilder builder = new StringBuilder();
		for (String eachItem : traceArray) {
			if (!(eachItem.contains("/"))){
				builder.append(eachItem).append("    :    ");
			}
			else{
				int countOccurence=4;
				for (String eachTerm : eachItem.split("/")) {
					countOccurence--;
					builder.append(eachTerm);
				}
				for (int i = 0; i < countOccurence; i++) {
					builder.append(" ");
				}
				builder.append(" :    ");   
			}
		}

		return builder.toString();

	}

	public static boolean isSorted(int[] input) {

		for (int count = 0; count < input.length - 1; count++) {
			//System.out.println("Comparing : " + input[count] + " & " + input[count + 1]);
			if (input[count] > input[count + 1])
				return false;

		}
		return true;
	}

	public static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static boolean isSorted(int[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static int[] generateRandomData(int count) {

		int[] randomData = new int[count];
		Random random = new Random();

		for (int i = 0; i < count; i++) {
			randomData[i] = random.nextInt(count);
		}

		return randomData;
	}

	
	public static int[] generateDuplicateData(int count) {

		int[] duplicateData = new int[count];
		for (int i = 0; i < count; i++) {
			duplicateData[i]=2; //just any number would do. Just bored with the default 0
		}
		
		return duplicateData;
	}
	
	public static Integer[] convertIntArrayToIntegerArray(int[] input) {

		Integer[] newArray = new Integer[input.length];
		int i = 0;
		for (int value : input) {
			newArray[i++] = Integer.valueOf(value);
		}

		return newArray;
	}

	public static void insertBreak(int inputLength) {
		for (int tmp = 0; tmp < inputLength; tmp++) System.out.print("-----------");
	}


	public static void addToTracer(String[] tracer, int index, String markerString) {
		if (tracer[index].trim().equals("")){
			tracer[index]=markerString;
		}
		else{
			tracer[index]=tracer[index]+"/"+markerString;
		}
		
	}

	public static String[] cleanupArray(String[] tracer) {

		for (int tmp = 0; tmp < tracer.length; tmp++) {
			tracer[tmp]=" ";
		}
		
		return tracer;
	}
	
	public static boolean isHeap(int[] input, int heapRoot) {
		
		//System.out.println("Heap Root input : :::: "+heapRoot);
		int lastIndex=input.length-1;
		
		if (heapRoot>=lastIndex/2+1) return true; //leaf nodes
		
		//System.out.println("condition 1 " +(((heapRoot*2))+2));
		if (((heapRoot*2)+2)<lastIndex){
			
			//System.out.println("Compare 1 : "+ input[heapRoot] + " vs "+ input[heapRoot*2+1] + " & "+ input[heapRoot*2 +2]);
			if (input[heapRoot]>=input[heapRoot*2+2] && input[heapRoot]>= input[heapRoot*2+1]){
				return isHeap(input, heapRoot+1);
			}
			else{
				return false;
			}
			
		}
		else{
			
			//System.out.println("Compare 2 : "+ input[heapRoot] + " vs "+ input[heapRoot*2 +1]);
			
			if (input[heapRoot]> input[heapRoot*2+1]){
				//return isHeapOrdered(input, heapRoot+1);
				return true; //True would do. Heap is a complete BT
			}
			else{
				return false;
			}
		}
		
	}
}