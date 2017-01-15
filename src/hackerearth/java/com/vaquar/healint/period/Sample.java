package hackerearth.java.com.vaquar.healint.period;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * %100 ACCEPTED BY CODILITY* // FINDING PERMUTATIONS OF A NUMBER EXCEPT LEADING
 * CASE 0 WITHOUT STRING // POINTER // TWO NON NEGATIVE INTEGERS N AND M ARE
 * CALLED SIMILAR IF THEIR DECIMAL // REPRESENTATIONS (WITHOUT LEADING ZEROS) //
 * CAN BE OBTANINED FROM EACH OTHER BY REARRANGING DIGITS FOR EXAMPLE IN // EACH
 * OF THE FOLLOWING PAIRS ONE INTEGER // SIMILAR TO OTHER // NOTE THAT IN THE
 * QUESTION EXPLANATION PERFOMANCE IS NOT CONSIDERED
 **
 * 
 * @param N
 *            is an integer
 * @return
 */
public class Sample {

    public static int solution(int N) {

	// converting Integer to an array of digit
	String temp = String.valueOf(N);
	int[] digitArray = new int[temp.length()];
	for (int i = 0; i < temp.length(); i++) {
	    digitArray[i] = temp.charAt(i) - '0';
	}

	// doing permutations on the array for the solution
	return digitPermutation(digitArray);
    }

    public static int digitPermutation(int[] digitArray) {

	Set<List<Integer>> setOfPermutations = new HashSet<List<Integer>>();
	setOfPermutations.add(new ArrayList<Integer>());

	// for each digit in an array. Create permutation
	for (int i = 0; i < digitArray.length; i++) {

	    // list of permutation. each permutation is a list of integers.
	    // Hence list of list
	    List<List<Integer>> current = new ArrayList<List<Integer>>();
	    for (List<Integer> permutation : setOfPermutations) {

		int lenght = permutation.size();
		for (int j = 0; j < lenght + 1; j++) {

		    // cloning, so that original permutation is preserved
		    ArrayList<Integer> clonePermutation = (ArrayList<Integer>) ((ArrayList<Integer>) permutation).clone();
		    // using java.util.List automatic re-indexing feature.
		    clonePermutation.add(j, digitArray[i]);
		    current.add(new ArrayList<Integer>(clonePermutation));
		}
	    }
	    // save the permutation
	    setOfPermutations = new HashSet<List<Integer>>(current);
	}

	return setOfPermutations.size();
    }

    public static void main(String[] args) {
	System.out.println(solution(1213));
    }
}
