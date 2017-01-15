package datastructue.java.com.vaquar.datastruct.tree;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;


public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	
	Node root;
	

	class Node{
		
		private Key key;
		private Value value;
		Node left;
		Node right;
		int height;
		int size;
		
		public Node(Key key, Value value) {
			this.key=key;
			this.value=value;
		}
		
		@Override
		public String toString() {
			return key.toString();
		}
		
	}
	
	
	public void put (Key key, Value value){
		
		root=put (root, key, value);
	}

	public int size(){
		return size(root);
	}
	
	private int size(Node node) {
		if (node==null) return 0;
		return node.size;
	}

	public Value get(Key key){
		
		Node currentNode=root;
		
		if (key==null) return null;
		
		while (currentNode!=null){
		
			int compareResult=key.compareTo(currentNode.key);
			if (compareResult==0){
				return currentNode.value;
			}
			else if (compareResult<0){
				currentNode=currentNode.left;
			}
			else if (compareResult>0){
				currentNode=currentNode.right;
			}
		}
		
		return null;
		
	}

	private Node put(Node currentRoot, Key key, Value value) {
		
		if (currentRoot==null) {
			Node tmpNode=new Node(key, value);
			tmpNode.size=1;
			return tmpNode;
		}
		
		int compareResult=key.compareTo(currentRoot.key);
		
		if (compareResult<0){
			currentRoot.left=put (currentRoot.left, key, value);
		}
		else if (compareResult>0){
			currentRoot.right=put (currentRoot.right, key, value);
		}
		else if (compareResult==0){
			currentRoot.value=value;
		}
		
		currentRoot.size=1+size(currentRoot.left)+size(currentRoot.right);
		return currentRoot;
	}
	
	
	@Override
	public String toString() {
		
		//do an inorder traversal
		
		StringBuilder builder=new StringBuilder();
		if (root==null){
			return "EMPTY TREE";
		}
		 
		//inOrderPrint(root, builder);
		levelOrderPrint(root);
		
		return builder.toString();
	}

	
	private void levelOrderPrint(Node rootNode){
		Deque<Node> queue=new LinkedBlockingDeque<Node>();
		queue.offerLast(rootNode);
		int currentLevelCount=1, nextLevelCount=0;
		
		Node currentNode=rootNode;
		
		while (!queue.isEmpty()){
			
			
			if (currentNode!=null){
				currentNode=queue.removeFirst();
				System.out.print(currentNode.key + "  ");
				currentLevelCount--;
				
				if (currentNode.left!=null){
					queue.offerLast(currentNode.left);
					nextLevelCount+=1;
				}
				if (currentNode.right!=null){
					queue.offerLast(currentNode.right);
					nextLevelCount+=1;
				}
			}
			
			if (currentLevelCount==0){
				System.out.println();
				currentLevelCount=nextLevelCount;
				nextLevelCount=0;
			}
			
			
			
		}
				
		
	}


	public Key max() {

		if (root==null) return null;
		
		Node currentNode=root;
		while (true){
			currentNode=currentNode.right;
			if (currentNode.right==null){
				break;
			}
		}
		
		return currentNode.key;
	}


	public Key min() {
		
		if (root==null) return null;
		
		Node currentNode=root;
		while (true){
			currentNode=currentNode.left;
			
			if (currentNode.left==null){
				break;
			}
		}
		return currentNode.key;
	}


	public Key floor(Key key) {
		
		if (key==null || root==null) return null;
		
		Node returnNode=floor (root, key);
		
		if (returnNode==null) return null;
		
		return returnNode.key;
		
	}


	private Node floor(Node currentTreeRoot, Key key) {
		
		System.out.println("Floor : "+currentTreeRoot);
		if (currentTreeRoot==null) return null;
		
		int compareResult=key.compareTo(currentTreeRoot.key);
		if (compareResult==0) {
			return currentTreeRoot;
		}
		else if (compareResult<0){
			System.out.println("Result < 0 : "+currentTreeRoot + " ::: "+key );
			return floor(currentTreeRoot.left, key);
		}
			
		else if (compareResult>0){
			System.out.println("Result > 0 : "+currentTreeRoot + " ::: "+key );
			Node terminalNode=floor(currentTreeRoot.right, key);
			System.out.println("Terminal Node : "+terminalNode + " Current tree root : "+ currentTreeRoot.right);
			if (terminalNode==null){
				return currentTreeRoot;
			}
			else{
				return terminalNode;
			}
		}
		
		return null;
		
	}
	
	
	//how many keys are greater than the input key
	public int rank(Key key){
		if (key==null) return -1;
		return rank (key, root);
	}


	private int rank(Key inputKey, Node currentNode) {
		
		if (currentNode==null) return 0;
		int compareResult=inputKey.compareTo(currentNode.key);
		
		
		if (compareResult<0) return rank(inputKey, currentNode.left);
		else if (compareResult>0) {
			return 1+ currentNode.left.size +rank (inputKey, currentNode.right);
		}
		
		else return currentNode.left.size;
		
	}
	
	
	
	
}
