package hackerearth.java.com.vaquar.honeywell.CrazyTree2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestClass {
    
    static Map<String, Long> cache = new HashMap<String, Long>();

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	int L = scan.nextInt();
	int Q = scan.nextInt();

	long[][] tree = constructTree(L);

	long results[] = new long[Q];
	for (int q = 0; q < Q; q++) {
	    int N = scan.nextInt(), X = scan.nextInt(), Y = scan.nextInt();
	    if(cache.containsKey(N+"-"+X+"-"+Y))
	    System.out.println(calculate(tree, N, X, Y));
	}
    }

    private static long[][] constructTree(int L) {

	long[][] tree = new long[L][];
	int nodes, j, l;
	for (l = L - 1; l >= 0; l--) {
	    nodes = (int) Math.pow(2, l);
	    tree[l] = new long[nodes];

	    if (l == L - 1) {
		for (int k = 0; k < nodes; k++)
		    tree[l][k] = (k + 1);

	    } else {
		for (j = 0; j < nodes; j++) {
		    tree[l][j] = (tree[l + 1][j * 2] * (tree[l + 1][j * 2 + 1])) % (1299709);
		}
	    }
	}
	return tree;
    }

    private static long calculate(long[][] tree, int N, int X, int Y) {

	long sum = 0;
	long[] level = tree[N - 1];
	for (int i = X - 1; i < Y; i++) {
	    sum += level[i];
	}
	return sum % 1299709;
    }
}
