package datastructue.java.com.vaquar.stack;

public class Stack<Item> {

	private Node<Item> head;
	private int size=0;
	
	/*public void push(Item item) {

		if (head==null){
			head=new Node<Item>(item); 
			size++;
		}
		else{
			Node<Item> newNode=new Node<Item>(item);
			newNode.next=head;
			head=newNode;
			size++;
		}
		
	}*/
	
	public void push(Item item){
		Node<Item> oldHead=head;
		Node<Item> newNode=new Node<Item>(item);
		newNode.next=oldHead;
		head=newNode;
		size++;
		
	}
	

	
	public int size(){
		return size;
	}
	
	public String list(){
		StringBuilder builder=new StringBuilder();
		Node<Item> currentNode=head;
		
		while (currentNode!=null){
			builder.append(currentNode.item).append(":");
			currentNode=currentNode.next;
		}
		return builder.toString();
	}




	public Node<Item> pop() {

		if (isEmpty()){
			return null;
		}
		Node<Item> previousHead=head;
		head=head.next;
		size--;
		
		return previousHead;
	}




	public boolean isEmpty() {
		if (size==0){
			return true;
		}
		return false;
	}
	
	
}
