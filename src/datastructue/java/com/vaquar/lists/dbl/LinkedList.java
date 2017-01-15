package datastructue.java.com.vaquar.lists.dbl;


public class LinkedList {

	private int size;
	private Node head=null;
	private Node tail=null;
	
	public void insertBefore(String value) {
		
		Node newNode=new Node(value);
		
		if (isEmpty()){
			head=newNode;
			tail=head;
		}
		else{
			
			Node previousHead=head;
			newNode.next=previousHead;
			newNode.previous=null;
			head=newNode;
			
		}
		size++;
		
	}
	
	public String list(){
		
		StringBuilder builder=new StringBuilder();
		
		Node tempNode=head;
		while (tempNode!=null){
			builder.append(tempNode.value).append(":");
			System.out.println("Printing item : "+tempNode.value);
			tempNode=tempNode.next;
		}
		return builder.toString();
		
	}

	public void insertAfter(String value){
		
		Node newNode=new Node(value);
		
		if (isEmpty()){
			head=newNode;
			tail=head;
			size++;
		}
		else{
			
			Node previousTail=tail;
			tail=newNode;
			previousTail.next=newNode;
			newNode.previous=previousTail;
			size++;
			
			/*newNode.previous=tail;
			tail.next=newNode;
			tail=newNode;
			size++;*/
		}
		
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty(){
		if (size==0){
			return true;
		}
		
		return false;
	}

}
