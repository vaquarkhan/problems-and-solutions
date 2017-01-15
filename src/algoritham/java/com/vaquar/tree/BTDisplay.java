package algoritham.java.com.vaquar.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Please note that; this is not my code; it is from the net.
 * 
 *
 */
class BTDisplay {

    public static <T extends Comparable<T>> void printTreeNode(BTNode<T> root) {
        int maxLevel = BTDisplay.maxLevel(root);

        printTreeNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<T>> void printTreeNodeInternal(List<BTNode<T>> TreeNodes, int level, int maxLevel) {
        if (TreeNodes.isEmpty() || BTDisplay.isAllElementsNull(TreeNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTDisplay.printWhitespaces(firstSpaces);

        List<BTNode<T>> newTreeNodes = new ArrayList<BTNode<T>>();
        for (BTNode<T> BTNode : TreeNodes) {
            if (BTNode != null) {
                System.out.print(BTNode.data);
                newTreeNodes.add(BTNode.left);
                newTreeNodes.add(BTNode.right);
            } else {
                newTreeNodes.add(null);
                newTreeNodes.add(null);
                System.out.print(" ");
            }

            BTDisplay.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < TreeNodes.size(); j++) {
                BTDisplay.printWhitespaces(firstSpaces - i);
                if (TreeNodes.get(j) == null) {
                    BTDisplay.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (TreeNodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTDisplay.printWhitespaces(1);

                BTDisplay.printWhitespaces(i + i - 1);

                if (TreeNodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTDisplay.printWhitespaces(1);

                BTDisplay.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printTreeNodeInternal(newTreeNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<T>> int maxLevel(BTNode<T> BTNode) {
        if (BTNode == null)
            return 0;

        return Math.max(BTDisplay.maxLevel(BTNode.left), BTDisplay.maxLevel(BTNode.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
