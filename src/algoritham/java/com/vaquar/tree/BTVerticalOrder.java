package algoritham.java.com.vaquar.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 * http://javabypatel.blogspot.in/2015/10/print-binary-tree-in-vertical-order.html
 * 
 *
 */
public class BTVerticalOrder {
	public static void main(String[] args) {

		Integer[] dataArray = { 8, 4, 2, 1, null, null, 3, null, null, 6, 5,
				null, null, 7, null, null, 14, 12, 10, 9, null, null, 11, null,
				null, 13, null, null, 16, 15, null, null, 17, null, null };

		// Build Tree from dataArray using PreOrder
		BTNode<Integer> root = BTNode.buildBTWithPreOrder(dataArray,
				new Counter(0));
		System.out.println("Tree built using PreOrder:");
		BTDisplay.printTreeNode(root);
		
		Map<Integer, List<BTNode>> map = new TreeMap<Integer, List<BTNode>>();
		int horizontalDistance = 0;
		buildTreeMapBTVerticalOrder(root, horizontalDistance, map);
		System.out.println(map);
	}

	/*
	 * Pre order traversal
	 */
	private static void buildTreeMapBTVerticalOrder(BTNode<Integer> root, int hd,
			Map<Integer, List<BTNode>> map) {
		if(root == null) {
			return;
		}
		List verticalNodes = map.get(hd);
		if(verticalNodes == null) {
			verticalNodes = new ArrayList();
		}
		verticalNodes.add(root);
		map.put(hd, verticalNodes);
		buildTreeMapBTVerticalOrder(root.left, hd-1, map);
		buildTreeMapBTVerticalOrder(root.right, hd+1, map);
	}
}
