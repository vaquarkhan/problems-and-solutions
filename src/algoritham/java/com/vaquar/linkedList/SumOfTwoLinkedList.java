package algoritham.java.com.vaquar.linkedList;

/**
 * http://www.geeksforgeeks.org/sum-of-two-linked-lists/
 * 
 * Input:
 *  First List: 5->6->3  // represents number 563
 *  Second List: 8->4->2 //  represents number 842
 * Output
 *  Resultant list: 1->4->0->5  // represents number 1405
 * 
 * 
 * Solution One: 0 Space complexity 
 *  Reverse both LL; then start summing up with new list.
 *  Then new sum list along with input lists should be reversed again. 
 * 
 * Solution Two: No modification on given input
 *   1. First find the size difference between two lists.
 *   2. Use recursion; when returning back create new sum list and return it.
 *  
 * 
 * 
 *
 */
public class SumOfTwoLinkedList {
	public static void main(String[] args) {
		LinkedNode<Integer> head1 = new LinkedNode<Integer>(10, null);
		LinkedNode<Integer> head2 = new LinkedNode<Integer>(5, null);

		LinkedNode<Integer> node1 = head1;
		for (int i = 9; i >= 1; i--) { //Node with data 10 is already created above.
			LinkedNode<Integer> nextNode = new LinkedNode<Integer>(i, node1);
			node1 = nextNode;
		}
		head1 = node1;
		
		LinkedNode<Integer> node2 = head2;
		for (int i = 4; i >= 1; i--) {
			LinkedNode<Integer> nextNode = new LinkedNode<Integer>(i, node2);
			node2 = nextNode;
		}
		head2 = node2;
		
		
		System.out.println();
		while (node1 != null) {
			System.out.print(node1 + " --> ");
			node1 = node1.next;
		}
		System.out.println();
		
		while (node2 != null) {
			System.out.print(node2 + " --> ");
			node2 = node2.next;
		}
		System.out.println();
		
//		System.out.println("Size Difference of head1, head2: " + findSizeDifference(head1, head2));
//		System.out.println("Size Difference of head2, head1: " + findSizeDifference(head2, head1));
//		System.out.println("Size Difference of head1, head1: " + findSizeDifference(head1, head1));
		
		LinkedNode<Integer> sumList = null;
		if(findSizeDifference(head1, head2) > 0) { //This is important
			sumList = sumOfTwoLL(head1, head2, findSizeDifference(head1, head2)); 
		} else {
			sumList = sumOfTwoLL(head1, head2, findSizeDifference(head2, head1)); 
		}
		
		System.out.println();
		while (sumList != null) {
			System.out.print(sumList+ " --> ");
			sumList = sumList.next;
		}

	}

	private static <T> int findSizeDifference(LinkedNode<T> head1, LinkedNode<T> head2) {
		int sizeDiff = 0;
		while(head1.next != null) {
			head1 = head1.next; 
			if(head2.next == null) {
				sizeDiff ++;
			} else {
				head2 = head2.next;
			}
		}
		
		while(head2.next != null) {
			head2 = head2.next;
			sizeDiff --;
		}
		
		return sizeDiff;
	}
	
	static int carry = 0;
	private static LinkedNode<Integer> sumOfTwoLL(LinkedNode<Integer> head1, LinkedNode<Integer> head2, int ignoreTillZero) {
		if(head1 == null) {
			return  null;
		}
		LinkedNode<Integer> newListNode = null;
		LinkedNode<Integer> returnNode = null;
		int sum = 0;
		if(ignoreTillZero > 0) {
			newListNode = sumOfTwoLL(head1.next, head2, ignoreTillZero-1);
			sum = head1.data + carry;
		} else {
			newListNode = sumOfTwoLL(head1.next, head2.next, ignoreTillZero-1);
			sum = head1.data + head2.data + carry;
		}
		
		carry = sum / 10;
		int divisor = sum % 10;
		returnNode = new LinkedNode<Integer>(divisor, newListNode);
		return returnNode;
	}
}
