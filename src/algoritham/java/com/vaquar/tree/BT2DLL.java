package algoritham.java.com.vaquar.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  [] dataArray for the tree using Preorder with null for leaf; is used for serialization.
 *  With this we can rebuild the tree as it is.
 *  
 *  But for Doubly Linked List creation; Don't use Preorder since memory will be doubled in this case.
 *  we can use in-Order traversal; this will give sorted data and from 
 *  that we can build balanced tree. This concept is used to merge two balanced tree into one balanced tree.
 * 
 * 
 */
public class BT2DLL {
	public static void main(String[] args) {
		//ODD number of data array 
		String[] dataArray = { "1", "2", "3", "4", null, null, "5", null, null,
				"6", "7", null, null, "8", null, null, "9", "10", "11", "12",
				null, null, "13", null, null, "14", null, null, "15", "16",
				null, null, "17", null, null };
		
		//Even number of data array 
//		String[] dataArray = { "1", "2", "3", "4", null, null, "5", null, null,
//				"6", "7", null, null, "8", null, null, "9", "10", "11", "12",
//				null, null, "13", null, null, "14", null, null, "15", "16",
//				null, null, null };
		
		//Build Tree from dataArray using PreOrder
		BTNode<String> root = BTNode.buildBTWithPreOrder(dataArray,
				new Counter(0));
		System.out.println("Tree built using PreOrder:");
		BTDisplay.printTreeNode(root);
		System.out.println();
		
		//Rebuild dataArray from Tree using PreOrder
		List a = new ArrayList();
		BTNode.buildDataArryaWithPreOrder(root, a, new Counter(0));
		System.out.println(a);
		
		
		
		//Forming DLL from Binary tree
		fromBT2DLL(root);
		BTNode<Integer> current = head;
        int nodeCount = 0;
		while (current != null) {
			System.out.print(current + "->");
			nodeCount ++;
			current = current.right;
		}
		System.out.println();
		
		//Forming Binary tree from DLL
		BTNode<Integer> rt = fromDLL2BT(0, nodeCount - 1);
		BTDisplay.printTreeNode(rt);
	}
	
	
//	public static <T extends Comparable<T>> void toDLL(BTNode<T> root, List<T> dataArray, AtomicInteger i) {
//	       if(root == null) {
//	        	dataArray.add(null);
//	        	i.incrementAndGet();
//	        	return;
//	        }
//	        dataArray.add(root.data);
//	    	i.incrementAndGet();
//	    	toDLL(root.left, dataArray, i);
//			i.incrementAndGet();
//			toDLL(root.right, dataArray, i);
//	}
	
	
	
	
	
	////////////////////////////////////////////////////
	////////////////////////////////////////////////////
	///////// IN ORDER TRAVERSAL ///////////////////////
	////////////////////////////////////////////////////
	////////////////////////////////////////////////////
	
	static BTNode head = null;
	static BTNode prev = null;

	private static <T extends Comparable<T>> void fromBT2DLL(BTNode<T> root) {
		if (root == null) {
			return ;
		}

		fromBT2DLL(root.left);

		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		
		fromBT2DLL(root.right);
	}
	
	
	
	static BTNode next = null;
	private static <T extends Comparable<T>> BTNode<T> fromDLL2BT(int l, int r) {
		if (l > r) {
			return null;
		}

		int m = l + (r - l) / 2;
		BTNode<T> left = fromDLL2BT(l, m - 1);
		BTNode<T> root = new BTNode (head.data);
		root.left = left;

		if (head.right != null) {
			head = head.right;
		}

		root.right = fromDLL2BT(m + 1, r);
		return root;
	}
}
