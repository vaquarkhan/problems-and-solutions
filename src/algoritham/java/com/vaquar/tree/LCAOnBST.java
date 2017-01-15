package algoritham.java.com.vaquar.tree;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class LCAOnBST {
	public static void main(String[] args) {
		Integer[] dataArray = {4, 2, 1, null, null, 3, null, null, 6, 5, null,
				null, 8,7,null,null,10,null,null};
		BTNode<Integer> rt = BTNode.buildBTWithPreOrder(dataArray, new Counter(0));
		BTNode<Integer> one = BTNode.findBTNodeForData(rt, 2);
		BTNode<Integer> two = BTNode.findBTNodeForData(rt, 3);
		BTDisplay.printTreeNode(rt);
		BTNode<Integer> lca = findLCAOnBinarySearchTree_Iterative(rt, one, two);
		System.out.println(lca);
	}
	
	public static <T extends Comparable<T>> BTNode<T> findLCAOnBinarySearchTree_Iterative(BTNode<T> root, BTNode<T> one, BTNode<T> two) {
		while(root != null) {
			if(root.data.compareTo(one.data) > 0 && root.data.compareTo(two.data) > 0) {
				root = root.left;
			} else if (root.data.compareTo(one.data) < 0 && root.data.compareTo(two.data) < 0) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}
}



/***
 * 
 * It is not possible to String array here since comparison of String with numeric has some issues.
 * @see http://stackoverflow.com/questions/900745/java-compareto-for-string-and-integer-arguments/33731518#33731518
 *
 */
//System.out.println("" + new StringNumericComparator().compare("PHOTO10", "PHOTO2"));
//System.out.println("" + new StringNumericComparator().compare("ABCD", "ABZ"));
//System.out.println("" + "ABCD".compareTo("ABZ"));
class StringNumericComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
        int len1 = o1.length();
        int len2 = o2.length();
        if(len1 != len2) {
        	return len1 - len2;
        }
        int lim = Math.min(len1, len2);
        char v1[] = o1.toCharArray();
        char v2[] = o2.toCharArray();
       
        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return 0;
	}
}