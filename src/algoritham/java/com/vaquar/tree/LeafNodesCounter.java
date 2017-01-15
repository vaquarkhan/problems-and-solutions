package algoritham.java.com.vaquar.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class LeafNodesCounter {
	public static void main(String[] args) {

		Integer[] dataArray = { 8, 4, 2, 1, null, null, 3, null, null,
				6, 5, null, null, 7, null, null, 14, 12, 10, 9,
				null, null, 11, null, null, 13, null, null, 16, 15,
				null, null, 17, null, null };
		

		// Build Tree from dataArray using PreOrder
		BTNode<Integer> root = BTNode.buildBTWithPreOrder(dataArray,
				new Counter(0));
		System.out.println("Tree built using PreOrder:");
		BTDisplay.printTreeNode(root);
		Counter numberOfLeafNodes = new Counter();
		getNumberOfLeafNodes(root, numberOfLeafNodes);
		System.out.println(numberOfLeafNodes);
		
		System.out.println(count(root));
	}
	
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
///////////////// SOLUTION 1 ////////////////////////	
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
	public static <T extends Comparable<T>> void getNumberOfLeafNodes(
			BTNode<T> root, Counter c) {
		
		if(root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			c.incrementAndGet();
			return;
		}
		getNumberOfLeafNodes(root.left, c);
		getNumberOfLeafNodes(root.right, c);
	}
	


	
	
	
	
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
///////////////// SOLUTION 2 ////////////////////////	
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
	private static <T extends Comparable<T>> int count(BTNode<T> root) {
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null) {
			return 1;
		}
		
		return count(root.left) + count(root.right);
	}
	

}
