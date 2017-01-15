package hackerearth.java.com.vaquar.marcura.visibleNode;

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
    public static int solution(Tree T) {
	return parseNodes(T, 0);
    }

    public static void main(String[] args) {
	System.out.println(solution(new Tree(8, (new Tree(2, new Tree(8, null, null), new Tree(7, null, null))), new Tree(6, null, null))));
    }

    public static int parseNodes(Tree T, int max) {
	int count = 0;
	if (T == null) {
	    return 0;
	}
	// for root thsi sets to one
	if (T.x >= max) {
	    count = 1;
	    max = T.x;
	}

	return count + parseNodes(T.l, max) + parseNodes(T.r, max);
    }
}

class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public Tree(int x, Tree l, Tree r) {
	this.x = x;
	this.l = l;
	this.r = r;
    }
}
