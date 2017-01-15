package algoritham.java.com.vaquar.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class LCAOnBT {
	public static void main(String[] args) {
		String[] dataArray = {"1","2","3","4",null,null,"5",null,null,"6","7",null,null,"8",null,null,
				"9","10","11","12",null,null,"13",null,null,"14",null,null, "15", "16", null, null, "17", null, null};
		BTNode<String> rt = BTNode.buildBTWithPreOrder(dataArray, new Counter(0));
		BTNode<String> one = BTNode.findBTNodeForData(rt, "2");
		BTNode<String> two = BTNode.findBTNodeForData(rt, "6");
		BTDisplay.printTreeNode(rt);
		BTNode<String> lca = findLCAOnBinaryTree(rt, one, two, new Counter(0));
		Result lca1 = findLCAOnBinaryTreeNew(rt, one, two);
		System.out.println(lca);
		System.out.println(lca1);
	}
	
	public static BTNode findLCAOnBinaryTree(BTNode<String> root, BTNode<String> one, BTNode<String> two, Counter noOfNodesFound) {
		if(root == null) {
			return root;
		}
		
		if(one.data.equals(root.data) || two.data.equals(root.data)) {
			noOfNodesFound.incrementAndGet();
			return root;
		}
		
		BTNode<String> foundAtLeft = findLCAOnBinaryTree(root.left, one, two, noOfNodesFound);
		
		//Optimization_1: to return the LCA if it is found only from left subtree, then avoid going to the right subtree
//		if(foundAtLeft != null && (!foundAtLeft.data.equals(one.data) && !foundAtLeft.data.equals(two.data))) {
//			return foundAtLeft;
//		}
		
		//Optimization_2: Avoid traversing right sub tree when both nodes are found. e.g. LCA (4,7) avoid traversing sub tree of 8, because 7 is found on left traversal.
		if(noOfNodesFound.get() == 2) {
			return foundAtLeft;
		}
		
		BTNode<String> foundAtRight = findLCAOnBinaryTree(root.right, one, two, noOfNodesFound);
		
		
		if(foundAtLeft != null && foundAtRight != null) {
			//Found LCA
			return root;
		}
		else {
			return foundAtLeft != null ? foundAtLeft : foundAtRight;
		}
	}
	
	
	public static Result findLCAOnBinaryTreeNew(BTNode<String> root, BTNode<String> one, BTNode<String> two) {
		if(root == null) {
			return new Result (0, null);
		}

//		This check is only needed when two nodes are under different sub tree.
//		if(one.data.equals(root.data) || two.data.equals(root.data)) {
//			return new Result (1, root);
//		}
		
		Result foundAtLeft = findLCAOnBinaryTreeNew(root.left, one, two);
		
		if(foundAtLeft.numTargetNodes == 2) {
			return foundAtLeft;
		}
			
		Result foundAtRight = findLCAOnBinaryTreeNew(root.right, one, two);
		
		if(foundAtRight.numTargetNodes == 2) {
			return foundAtRight;
		}
		
	    int numTargetNodes = foundAtLeft.numTargetNodes + foundAtRight.numTargetNodes
                + (root == one ? 1 : 0) + (root == two ? 1 : 0);
	    
	    return new Result(numTargetNodes, (numTargetNodes == 2 ? root : null));
//	    This check is only needed when two nodes are under different sub tree.
//	    This will ensure out of two (one, two) which precedes the other
//	    	(foundAtLeft.ancestor != null ? foundAtLeft.ancestor : foundAtRight.ancestor)));

	}
	
	
	static class Result {
		
	    public Result (int numTargetNodes, BTNode node) {
	        this.numTargetNodes = numTargetNodes;
	        this.ancestor = node;
	    }
	    
		@Override
		public String toString() {
			return "Result [numTargetNodes=" + numTargetNodes + ", ancestor="
					+ ancestor + "]";
		}

		int numTargetNodes;
		BTNode ancestor;
	}
}
