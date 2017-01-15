package algoritham.java.com.vaquar.linkedList;

public class ReverseLinkedList {
	public static void main(String[] args) {
		LinkedNode<Integer> head = new LinkedNode<Integer>(10, null);

		LinkedNode<Integer> node = head;
		for (int i = 9; i >= 1; i--) {
			LinkedNode<Integer> nextNode = new LinkedNode<Integer>(i, node);
			node = nextNode;
		}
		head = node;
		
		
		while (node != null) {
			System.out.println(node);
			node = node.next;
		}
		
		LinkedNode<Integer> updated = recursiveReverseLL(head, null); //Passing null is important here, to set 1's next to NULL.
//		head.next = null;  This is needed when calling  recursiveReverseLL1
		
//		LinkedNode<Integer> updated = reverseLL(head);
		while (updated != null) {
			System.out.println(updated);
			updated = updated.next;
		}

	}
	
	private static <T> LinkedNode<T> reverseLL(LinkedNode<T> head) {
		LinkedNode<T> prev = head;
		LinkedNode<T> current = head.next;    //Note previous and current is enough, not next is needed.
		head.next = null;  //Don't forget to set head to null
		while(current != null) {   //NOTE not current.next
			LinkedNode<T> temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}
	
//	static LinkedNode<Integer> updated = null;
//	private static <T> void recursiveReverseLL(LinkedNode<T> head, LinkedNode<T> prev) {
//		if(head.next == null) {
//			head.next = prev;
//			updated = (LinkedNode<Integer>) head;
//			return;
//		}
//		recursiveReverseLL(head.next, head);
//		head.next = prev;
//	}
	
	
	/**
	 * recursiveReverseLL1 will return the first node passed which is "1" though list is reversed.
	 * But we want "10" should be returned since this is the first node after reverse.
	 * Hence this method lastReturn is always pointing to "10"
	 * 
	 * Also recursiveReverseLL1 will not set the first node to null. But this
	 * method take care of it, as prev is NULL when we calling this API.
	 * 
	 * @param head
	 * @param prev
	 * @return
	 */
	private static <T> LinkedNode<T> recursiveReverseLL(LinkedNode<T> head, LinkedNode<T> prev) {
		if(head == null) {
			return  prev;
		}
		LinkedNode<T> lastReturn = recursiveReverseLL(head.next, head);
		head.next = prev;
		return lastReturn;
	}
	
	
	private static <T> LinkedNode<T> recursiveReverseLL1(LinkedNode<T> head) {
		if(head.next == null) { //Last node found
			return  head;
		}
		LinkedNode<T> lastReturn = recursiveReverseLL1(head.next);
		lastReturn.next = head;
		return head;
	}
}

class LinkedNode<T> {
	
	T data;
	LinkedNode<T> next;

	LinkedNode(T data, LinkedNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
