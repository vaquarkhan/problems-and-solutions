package algoritham.java.com.vaquar.tree;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * 
 * Binary Search tree is a binary tree in which each internal node x stores an element such that 
 * the element stored in the left subtree of x are less than or equal to x and 
 * elements stored in the right subtree of x are greater than or equal to x. 
 * 
 * This is called binary-search-tree property.
 * 
 * 
 *
 * @param <T>
 */
public class IsBST<T extends Comparable<T>> {
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
		System.out.println(isBST(root));
		System.out.println(new IsBST().inOrderBSTCheck(root));
		System.out.println(new IsBST().isBSTRecursive(root, new Integer(Integer.MIN_VALUE), new Integer(Integer.MAX_VALUE) ));
	}
	
	
	
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
///////////////// SOLUTION 1 ////////////////////////	
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
	public static <T extends Comparable<T>> boolean isBST(BTNode<T> root) {
		if(root == null) {
			return true;
		}
		if((root.left != null && root.left.data.compareTo(root.data) > 0 ) || (root.right != null && root.right.data.compareTo(root.data) < 0)) {
			return false;
		}
		
		if(isBST(root.left) == true) {
			return isBST(root.right);
		}
		return false;
	}
	
	
		
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
///////////////// SOLUTION 2 ////////////////////////	
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
	private T previous = null;
	private boolean inOrderBSTCheck(BTNode<T> root) {
		if (root != null) {
			if (!inOrderBSTCheck(root.left)) {
				return false;
			}
			
			if(previous == null) {
				previous = root.data;
			}
			
			if ((root.data).compareTo(previous) < 0) {
				return false;
			}
			previous = (root.data);
			return inOrderBSTCheck(root.right);
		}
		return true;
	}
	
	
	
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
///////////////// SOLUTION 3 ////////////////////////	
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
	private boolean isBSTRecursive(BTNode<T> root, T min, T max) {
		if (root == null) {
			return true;
		}

		T value = (root.data);
		
		if (value.compareTo(min) < 0 || value.compareTo(max) > 0) {
			return false;
		}

		return isBSTRecursive(root.left, min, value)
				&& isBSTRecursive(root.right, value, max);
	}
	
}
