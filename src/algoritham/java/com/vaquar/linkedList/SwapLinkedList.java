package algoritham.java.com.vaquar.linkedList;

/**
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-261-sde1/
 * 
 * Given a linked list eg : 1->2->3->4->5->6, make the following changes
 *	                        1->6->2->5->3->4
 *
 * We can also use stack to push 4->5->6 then start from 1 (1->2->3) and peek() from stack.
 *   
 * 
 *
 */
public class SwapLinkedList {
	static LinkedNode<Integer> head = null;
	public static void main(String[] args) {
		head = new LinkedNode<Integer>(6, null);
   
		//Build sequential list
		LinkedNode<Integer> node = head;
		for (int i = 5; i >= 1; i--) {
			LinkedNode<Integer> nextNode = new LinkedNode<Integer>(i, node);
			node = nextNode;
		}
		head = node;
		
		// Print nodes.
		while (node != null) {
			System.out.println(node);
			node = node.next;
		}
		
		LinkedNode<Integer> retNode = doSwapLinkedList(head);
		
		node = head;
		// Print nodes.
		while (node != null) {
			System.out.println(node);
			node = node.next;
		}
	}

//	private static LinkedNode<Integer> doSwapLinkedList(LinkedNode<Integer> node) {
//		if(node == null) {
//			return head;
//		}
//		LinkedNode<Integer> retNode = doSwapLinkedList(node.next);
//		if(retNode == node || retNode.next == node || retNode == head) {
//			return head;
//		}
//		LinkedNode<Integer> tmp = retNode.next;
//		retNode.next = node;
//		return tmp;
//	}
	
	
	private static LinkedNode<Integer> doSwapLinkedList(LinkedNode<Integer> node) {
		if(node.next == null) {
			//This is to avoid returning head from the last base condition check.
			//Since i have if (retNode == head) inside the code after base condition.
			LinkedNode<Integer> tmp = head.next;
			head.next = node;
			node.next = tmp; //This is important
			return tmp;
		}
		
		//Reached the mid
		LinkedNode<Integer> retNode = doSwapLinkedList(node.next);
		if(retNode == node || retNode == head) {
			return head;
		}
		//Reached the mid
		if(retNode.next == node) { //This is more important.
			node.next = null;
			return head;
		} 
		
		LinkedNode<Integer> tmp = retNode.next;
		retNode.next = node;
		node.next = tmp;
		return tmp;
	}
}
