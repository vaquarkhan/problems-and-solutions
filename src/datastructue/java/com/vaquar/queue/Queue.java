package datastructue.java.com.vaquar.queue;

public class Queue<Item> {

	private Node<Item> head;
	private Node<Item> tail;
	
	private int size;
	
	public void enqueue(Item item) {
		
		Node<Item> newNode=new Node<Item>(item);
		if (isEmpty()){
			head=newNode;
			tail=head;
		}
		else{
			tail.next=newNode;
			tail=newNode;
		}
		
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		if (size==0){
			return true;
		}
		return false;
	}
	
	public String list(){
		
		Node<Item> tempNode=head;
		StringBuilder builder=new StringBuilder();
		
		while (tempNode!=null){
			builder.append(tempNode.item).append(":");
			tempNode=tempNode.next;
		}
		
		return builder.toString();
	}

	public Node<Item> dequeue() {
		
		if (isEmpty()){
			return null;
		}
		
		Node<Item> previousHead=head;
		head=head.next;
		size--;
		return previousHead;
		
	}
	
}
