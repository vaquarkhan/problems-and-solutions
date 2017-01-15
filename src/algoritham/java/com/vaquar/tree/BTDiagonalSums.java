package algoritham.java.com.vaquar.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 * http://www.geeksforgeeks.org/diagonal-sum-binary-tree/
 * 
 * 
 *
 */
public class BTDiagonalSums {
	public static void main(String[] args) {
		Integer[] dataArray = { 8, 4, 2, 1, null, null, 3, null, null, 6, 5, null, null, 7, null, null, 14, 12, 10, 9,
				null, null, 11, null, null, 13, null, null, 16, 15, null, null, 17, null, null };

		// Build Tree from dataArray using PreOrder
		BTNode<Integer> root = BTNode.buildBTWithPreOrder(dataArray, new Counter(0));
		System.out.println("Tree built using PreOrder:");
		BTDisplay.printTreeNode(root);
		Map<Integer, Integer /*DiagonalLeve, Sum*/> diagonalSumMap = new HashMap<Integer, Integer>();
		computeDiagonalSum(root, diagonalSumMap);
		System.out.println(diagonalSumMap);
	}

	private static void computeDiagonalSum(BTNode<Integer> root, Map<Integer, Integer> diagonalSumMap) {
		Queue<BTNode<Integer>> q = new LinkedList<BTNode<Integer>>();
		q.add(root);
		Map<BTNode<Integer>, Integer /*BTNode, DiagonalValue*/> nodeDiagonalValueMap = new HashMap<BTNode<Integer>, Integer>();
		nodeDiagonalValueMap.put(root, 1);
		while(!q.isEmpty()) {
			BTNode<Integer> node = q.remove();
			int diagonalValue = nodeDiagonalValueMap.get(node); 
			while(node != null) {
//				int diagonalValue = nodeDiagonalValueMap.get(node); Only Left node will be added here, so should be above this loop.
				int prevSum = (diagonalSumMap.get(diagonalValue) == null?0:diagonalSumMap.get(diagonalValue));
				int newSum = prevSum + node.data;
				diagonalSumMap.put(diagonalValue, newSum);
				if(node.left != null) {
					q.add(node.left);
					nodeDiagonalValueMap.put(node.left, diagonalValue + 1);
				}
				node = node.right;
			}
		}
		
	}
}
