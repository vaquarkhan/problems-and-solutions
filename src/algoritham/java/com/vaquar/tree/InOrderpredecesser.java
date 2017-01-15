package algoritham.java.com.vaquar.tree;

public class InOrderpredecesser {

public static void main(String[] args) {
		
	//ODD number of data array 
	String[] dataArray = { "1", "2", "3", "4", null, null, "5", null, null,
			"6", "7", null, null, "8", null, null, "9", "10", "11", "12",
			null, null, "13", null, null, "14", null, null, "15", "16",
			null, null, "17", null, null };
	
	//Even number of data array 
//	String[] dataArray = { "1", "2", "3", "4", null, null, "5", null, null,
//			"6", "7", null, null, "8", null, null, "9", "10", "11", "12",
//			null, null, "13", null, null, "14", null, null, "15", "16",
//			null, null, null };
	
	//Build Tree from dataArray using PreOrder
	BTNode<String> root = BTNode.buildBTWithPreOrder(dataArray,
			new Counter(0));
	System.out.println("Tree built using PreOrder:");
	BTDisplay.printTreeNode(root);
	System.out.println();
	System.out.println(" 3: " + findIOP1(root, "3"));
	successor = null;
	System.out.println("13: " + findIOP1(root, "13"));
	successor = null;
	System.out.println("12: " + findIOP1(root, "12"));
	successor = null;
	System.out.println("17: " + findIOP1(root, "17"));
	successor = null;
	isSet = false;
	System.out.println(" 1: " + findIOP1(root, "1"));
	successor = null;
	System.out.println(" 6: " + findIOP1(root, "6"));
	successor = null;
	System.out.println(" 8: " + findIOP1(root, "8"));
	successor = null;
	System.out.println();
	System.out.println();
	System.out.println("13: " + findIOP2(root, "13"));
	System.out.println("12: " + findIOP2(root, "12"));
	System.out.println("17: " + findIOP2(root, "17"));
	System.out.println(" 1: " + findIOP2(root, "1"));
	System.out.println(" 6: " + findIOP2(root, "6"));
	System.out.println(" 8: " + findIOP2(root, "8"));
	
	System.out.println();
	System.out.println();
	System.out.println("13: " + findIOP3(root, "13"));
	System.out.println("12: " + findIOP3(root, "12"));
	System.out.println("17: " + findIOP3(root, "17"));
	prev = null;
	System.out.println(" 1: " + findIOP3(root, "1"));
	prev = null;
	System.out.println(" 6: " + findIOP3(root, "6"));
	prev = null;
	System.out.println(" 8: " + findIOP3(root, "8"));
	
	}

	// Solution 1
	static BTNode successor;
	static boolean isSet = false;
	private static <T extends Comparable<T>> BTNode<T> findIOP1(BTNode<T> root, T data) {
		if (root == null) {
			return root;
		}
		BTNode<T> nodeFound = findIOP1(root.left, data);
		if( nodeFound == null ){
			nodeFound = findIOP1(root.right, data);
		}
		if (isSet == true) {
			successor = root;
			isSet = false;
		}
		if (successor != null) {
			return successor;
		}
		if (root.data.compareTo(data) == 0) {
			nodeFound = root;
			isSet = true;
		}
		return nodeFound;
	}

	//Solution 2 : Incomplete
	private static <T extends Comparable<T>> BTNode<T> findIOP2 (BTNode<T> root, T data) {
		if (root ==  null) {
			return null;
		}
		if (root.data.compareTo(data) == 0) {
			if (root.left != null) {
				BTNode<T> tmp = root.left;
				while (tmp !=null && tmp.right != null) {
					tmp = tmp.right;
				}
				System.out.println(tmp);
				return tmp;
			}
			return root;
		}
		BTNode<T> right = findIOP2(root.right, data);
		if (right != null && root.data.compareTo(data) == 0) {
			return root;
		}
		return right != null ? right : findIOP2(root.left, data);
	}
	
	// Solution 3 : Easy to understand
	static BTNode prev;
	private static <T extends Comparable<T>> BTNode<T> findIOP3(BTNode<T> root, T data) {
		if (root == null) {
			return null;
		}
		BTNode<T> left = findIOP3(root.left, data);
		if (left == null && root.data.compareTo(data) == 0) {
			return prev;
		}
		prev = root;
		return left != null ? left : findIOP3(root.right, data);
	}
}
