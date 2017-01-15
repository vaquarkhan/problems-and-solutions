package algoritham.java.com.vaquar.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * This node is used in both in binary tree as well as binary search tree.
 * To support BST; it is declared with data T which extends Comparable<T>  
 * 
 * There are utility methods available in this class to build the tree.
 * 
 * 
 *
 * @param <T> is data this node holds.
 */
public class BTNode<T extends Comparable<T>> {
	public BTNode<T> left;
	public BTNode<T> right;
	public T data;
	
	public BTNode(T data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
	
	public static void main(String[] args) {
		BTNode<String> rt;
//		rt.data = "5";
//		rt.left = new BTNode<String>();
//		rt.left.data = "10";
//		rt.right = new BTNode<String>();
//		rt.right.data = "20";
		String[] dataArray = {"1","2","3","4",null,null,"5",null,null,"6",null,null,"7","8","9","10",null,null,"11",null,null,null,null};
//		String[] dataArray = {"1","2","3","4"};
		rt = buildBTWithPreOrder(dataArray, new Counter(0));
		BTDisplay.printTreeNode(rt);
		List a = new ArrayList();
		buildDataArryaWithPreOrder(rt, a, new Counter(0));
		System.out.println(a);
	}
	

	public static <T extends Comparable<T>> BTNode<T> buildBTWithPreOrder(T[] dataArray, Counter i){
		if(dataArray[i.get()] == null) {
			return null;
		}
		BTNode<T> node = new BTNode<T>(dataArray[i.get()]);
		i.incrementAndGet();
		node.left = buildBTWithPreOrder(dataArray, i);
		i.incrementAndGet();
		node.right = buildBTWithPreOrder(dataArray, i);
		return node;
	}
	
	
	public static <T extends Comparable<T>>  void buildDataArryaWithPreOrder(BTNode<T> root, List<T> dataArray, Counter i){
        if(root == null) {
        	dataArray.add(null);
        	i.incrementAndGet();
        	return;
        }
        dataArray.add(root.data);
    	i.incrementAndGet();
    	buildDataArryaWithPreOrder(root.left, dataArray, i);
		i.incrementAndGet();
		buildDataArryaWithPreOrder(root.right, dataArray, i);
	}
	
	
	//Since binary tree is unbalanced and not sorted, we have to lookup on all the nodes.
	//The search is worst case is n here.
	//This is how you can skip the recursion; when you found it. 
	public static <T extends Comparable<T>>  BTNode<T> findBTNodeForData(BTNode<T> root, T data){
        if(root == null || root.data.equals(data)) {
        	return root;
        }
        BTNode<T> foundNode =  findBTNodeForData(root.left, data);
        if(foundNode == null) {
        	foundNode = findBTNodeForData(root.right, data);
        }
		return foundNode;
	}
	
	
	//Since binary Search tree is sorted, we search node in log n time.
	public static <T extends Comparable<T>> BTNode<T> findBSTNodeForData(
			BTNode<T> root, T data) {
		if (root == null || root.data.equals(data)) {
			return root;
		}
        
        if (root.data.compareTo(data) > 0)
        {
        	return findBSTNodeForData(root.left, data);
        } else {
        	return findBSTNodeForData(root.right, data);
        }

	}
	

	static class BTNodeComparator<T extends Comparable<T>> implements Comparator<BTNode<T>>{
		public static  BTNodeComparator compator = new BTNodeComparator();
		
		@Override
		public int compare(BTNode<T> o1, BTNode<T> o2) {
			return o1.data.compareTo(o2.data);
		}
	}
	
	
	
	/*******************************************************/
	/*******************************************************/
	/*** Check the possibility of building the tree with ***/
	/***         other traversal technique               ***/
	/*******************************************************/
	/*******************************************************/
	
	public static void buildBTWithInOrder(Object[] dataArray){
//		BTNode<Object> rt = new BTNode<Object>(dataArray[0]);
	}
	
	private static <T extends Comparable<T>> BTNode<T> buildBTWithInOrder(T data, BTNode<T> parent, BTNode<T> child, boolean isLeft){
		if(child == null) {
			BTNode<T> node = new BTNode<T>(data);
			if(isLeft) {
				parent.left = node;
			} else {
				parent.right = node;
			}
			return node;
		}
		return null;
//		if(parent.data < data) {
//			buildBTWithInOrder(data, parent, parent.left, true);
//		}
//		if(parent.data > data) {
//			buildBTWithInOrder(data, parent, parent.left, true);
//		}
	}
	
}
