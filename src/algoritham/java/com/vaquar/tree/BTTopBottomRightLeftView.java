package algoritham.java.com.vaquar.tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * http://javabypatel.blogspot.in/2015/10/print-bottom-view-of-binary-tree.html
 * http://www.geeksforgeeks.org/print-left-view-binary-tree/
 * 
 * 
 * 
 *
 */
public class BTTopBottomRightLeftView {
	public static void main(String[] args) {

		Integer[] dataArray = { 8, 4, 2, 1, null, null, 3, null, null, 6, 5,
				null, null, 7, null, null, 14, 12, 10, 9, null, null, 11, null,
				null, 13, null, null, 16, 15, null, null, 17, null, null };

		// Build Tree from dataArray using PreOrder
		BTNode<Integer> root = BTNode.buildBTWithPreOrder(dataArray,
				new Counter(0));
		System.out.println("Tree built using PreOrder:");
		BTDisplay.printTreeNode(root);
		
		//TOP View
		Map<Integer, BTNode<Integer>> map = new TreeMap<Integer, BTNode<Integer>>();
		int horizontalDistance = 0;
		buildTopViewOfBT(root, horizontalDistance, map);
		System.out.println(map);
		
		//Bottom view
		map = new TreeMap<Integer, BTNode<Integer>>();
		buildBttomViewOfBT(root, horizontalDistance, map);
		System.out.println(map);
		
		//Left View
		buildLeftViewOfBT(root, 0, new Counter(1));
		
		//RightView
		buildRightViewOfBT(root, 0, new Counter(1));
	}

	private static void buildTopViewOfBT(BTNode<Integer> root, int hd,
			Map<Integer, BTNode<Integer>> map) {
		if(root == null) {
			return;
		}
		BTNode<Integer> firstVerticalNode = map.get(hd);
		if(firstVerticalNode == null) {
			map.put(hd, root);
		}
		buildTopViewOfBT(root.left, hd-1, map);
		buildTopViewOfBT(root.right, hd+1, map);
	}

	private static void buildBttomViewOfBT(BTNode<Integer> root, int hd,
			Map<Integer, BTNode<Integer>> map) {
		if(root == null) {
			return;
		}
		map.put(hd, root);
		buildBttomViewOfBT(root.left, hd-1, map);
		buildBttomViewOfBT(root.right, hd+1, map);
	}
	
	//Pre Order and left traversal first
	private static void buildLeftViewOfBT(BTNode<Integer> root, int currentlevel, Counter nextLevelToPrint) {
		if(root == null) {
			return;
		}
        if( (currentlevel + 1) == nextLevelToPrint.get()) { //This is more important. Don't use <, use ==
        	nextLevelToPrint.incrementAndGet();
        	System.out.println(root);
        }
        buildLeftViewOfBT(root.left, currentlevel + 1, nextLevelToPrint);
        buildLeftViewOfBT(root.right, currentlevel + 1, nextLevelToPrint);
	}
	
	//Pre Order and right traversal first
	private static void buildRightViewOfBT(BTNode<Integer> root, int currentlevel, Counter nextLevelToPrint) {
		if(root == null) {
			return;
		}
        if( (currentlevel + 1) == nextLevelToPrint.get()) { //This is more important.
        	nextLevelToPrint.incrementAndGet();
        	System.out.println(root);
        }
        buildRightViewOfBT(root.right, currentlevel + 1, nextLevelToPrint);
        buildRightViewOfBT(root.left, currentlevel + 1, nextLevelToPrint);
	}
}
