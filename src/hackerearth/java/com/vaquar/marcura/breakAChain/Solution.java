package hackerearth.java.com.vaquar.marcura.breakAChain;

//
//A zero indexed Array consisting of N integers is given. The elements of Array A together represent a chain, and each element represents the strength of each link in chain. We want to divide this chain into three smaller chains. All we can do is to break this chain in exactly to non- adjacent postitions. More presisely we should brea links P, Q(01), resulting in three chains: [0, P-1],[P+1,Q-1],[Q+1,N-1]. The total cost of this operation is A[P]+a[Q].
//
//For example consider the array A such that:
//
//  A[0] = 5
//  A[1] = 2
//  A[2] = 4
//  A[3] = 6
//  A[4] = 3
//  A[5] = 7
//We can choose to break the following Links:
//
//(1,3) : total cost is 6+2 = 8
//(1,4) : total cost is 2+3 = 5
//(2,4) : total cost is 4+3 = 7
//
//Write a method:
//
//int solution(int[] A. int N);
//that, given a zero indexed array A of N integers, returns the minimum cost of dividing the chain into three parts. For above example it should return 5

class Solution {
    public static int solution(int[] A, int N) {

	int sum = A[1] + A[3];
	for (int i = 1; i < N - 3; i++) {
	    for (int j = i + 2; j < N - 1; j++) {
		if (A[i] + A[j] < sum) {
		    sum = A[i] + A[j];
		}
	    }
	}
	return sum;
    }

    public static void main(String[] args) {
	System.out.println(solution(new int[] { 5, 2, 4, 6, 3, 2, 5 }, 7));
    }
}
