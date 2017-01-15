package algoritham.java.com.vaquar.tree;

public class InorderSuccesser {

	public static void main(String[] args) {

		// ODD number of data array
		String[] dataArray = { "1", "2", "3", "4", null, null, "5", null, null, "6", "7", null, null, "8", null, null,
				"9", "10", "11", "12", null, null, "13", null, null, "14", null, null, "15", "16", null, null, "17",
				null, null };

		// Even number of data array
		// String[] dataArray = { "1", "2", "3", "4", null, null, "5", null,
		// null,
		// "6", "7", null, null, "8", null, null, "9", "10", "11", "12",
		// null, null, "13", null, null, "14", null, null, "15", "16",
		// null, null, null };

		// Build Tree from dataArray using PreOrder
		BTNode<String> root = BTNode.buildBTWithPreOrder(dataArray, new Counter(0));
		System.out.println("Tree built using PreOrder:");
		BTDisplay.printTreeNode(root);
		System.out.println();
		System.out.println(" 3: " + findIOS1(root, "3"));
		successor = null;
		System.out.println("13: " + findIOS1(root, "13"));
		successor = null;
		System.out.println("12: " + findIOS1(root, "12"));
		successor = null;
		System.out.println("17: " + findIOS1(root, "17"));
		successor = null;
		isSet = false;
		System.out.println(" 1: " + findIOS1(root, "1"));
		successor = null;
		System.out.println(" 6: " + findIOS1(root, "6"));
		successor = null;
		System.out.println(" 8: " + findIOS1(root, "8"));
		successor = null;
		System.out.println();
		System.out.println();
		System.out.println("13: " + findIOS2(root, "13"));
		System.out.println("12: " + findIOS2(root, "12"));
		System.out.println("17: " + findIOS2(root, "17"));
		System.out.println(" 1: " + findIOS2(root, "1"));
		System.out.println(" 6: " + findIOS2(root, "6"));
		System.out.println(" 8: " + findIOS2(root, "8"));
		
		System.out.println();
		System.out.println();
		System.out.println("13: " + findIOS3(root, "13"));
		System.out.println("12: " + findIOS3(root, "12"));
		found = null;
		System.out.println("17: " + findIOS3(root, "17"));
		found = null;
		System.out.println(" 1: " + findIOS3(root, "1"));
		found = null;
		System.out.println(" 6: " + findIOS3(root, "6"));
		found = null;
		System.out.println(" 8: " + findIOS3(root, "8"));
	}

	// Solution 1
	static BTNode successor;
	static boolean isSet = false;

	private static <T extends Comparable<T>> BTNode<T> findIOS1(BTNode<T> root, T data) {
		if (root == null) {
			return root;
		}
		BTNode<T> nodeFound = findIOS1(root.left, data);
		if (isSet == true) {
			successor = root;
			isSet = false;
		}
		if (successor != null) {
			return successor;
		}
		if (root.data.compareTo(data) == 0) {
			isSet = true;
		}
		return nodeFound != null ? nodeFound : findIOS1(root.right, data);
	}

	// Solution 2
	private static <T extends Comparable<T>> BTNode<T> findIOS2(BTNode<T> root, T data) {
		if (root == null) {
			return null;
		}
		if (root.data.compareTo(data) == 0) {
			if (root.right != null) {
				BTNode<T> tmp = root.right;

				while (tmp != null && tmp.left != null) {
					tmp = tmp.left;
				}
				return tmp;
			}
			return root;
		}
		BTNode<T> left = findIOS2(root.left, data);
		if (left != null && left.data == data) {
			return root;
		}
		return left != null ? left : findIOS2(root.right, data);
	}

	
	// Solution 3
	static BTNode found;
	private static <T extends Comparable<T>> BTNode<T> findIOS3(BTNode<T> root, T data) {
		if (root == null) {
			return null;
		}
		BTNode<T> left = findIOS3(root.left, data);
		if(found != null) {
			found = null;
			return root;
		}
		if (left == null && root.data.compareTo(data) == 0) {
			found = root;
		}
		return left != null ? left : findIOS3(root.right, data);
	}
}
