package algoritham.java.com.vaquar.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		BTNode<String> rt;
		String[] dataArray = {"1","2","3","4",null,null,"5",null,null,"6",null,null,"7","8","9","10",null,null,"11",null,null,null,null};
		rt = BTNode.buildBTWithPreOrder(dataArray, new Counter(0));
		BTDisplay.printTreeNode(rt);
		levelOrderTraversal(rt);
		System.out.println();
		levelOrderTraversal1(rt);
	}

	//Level order traversal with iterative approach.
	private static <T extends Comparable<T>> void levelOrderTraversal(BTNode<T> rt) {
		Queue<BTNode<T>> q = new LinkedList();
		q.offer(rt);
		while(q.peek() != null) {
			BTNode<T> node = q.poll();
			System.out.println(node);
			if(node.left != null)
			q.offer(node.left);
			if(node.right != null)
			q.offer(node.right);
		}
	}
	
	
	//Level order traversal with iterative approach with level separator.
	private static <T extends Comparable<T>> void levelOrderTraversal1(BTNode<T> rt) {
		Queue<BTNode<T>> q = new LinkedList();
		int i = 1;
		System.out.println(" Level_" + i++);
		q.offer(rt);
		q.offer(null);
		while(q.peek() != null) {
			BTNode<T> node = q.poll();
			System.out.print(" " + node + " ");
			if(node.left != null)
			q.offer(node.left);
			if(node.right != null)
			q.offer(node.right);
			BTNode<T> nullNode = q.peek();
			if(nullNode == null && q.size() != 1) {
				System.out.println("\n Level_" + i++);
				//Found an level
				q.poll();
				q.offer(null);
			}
		}
	}
}
