package datastructue.java.com.vaquar.lists.single;

public class LinkedList {

	private Node firstNode;
	private int size=0;
	
	public void insert(int value){
		
		if (firstNode==null){
			firstNode=new Node(value);
			size++;
		}
		else{
			Node temp=firstNode;
			while (temp.next!=null){
				temp=temp.next;
			}
			
			Node newNode=new Node(value);
			newNode.next=null;
			temp.next=newNode;
			size++;
			
		}
	}
	
	
	public String list(){
		
		StringBuilder builder=new StringBuilder();
		
		Node tempNode=firstNode;
		while (tempNode!=null){
			builder.append(tempNode.value).append(":");
			System.out.println("Printing item : "+tempNode.value);
			tempNode=tempNode.next;
		}
		return builder.toString();
		
	}

	public Node search(int index) {
		if (index>size) return null;
		Node tempNode=firstNode;
		
		for (int i=1;i<index;i++){
			tempNode=tempNode.next;
		}
		return tempNode;
	}

	public Node searchByValue(int value){
		Node tempNode=firstNode;
		if (firstNode==null) return null;
		while (tempNode!=null && tempNode.value!=value){
			tempNode=tempNode.next;
			
		}
		
		return tempNode;
		
	}
	
	public void delete(int value) {

		if (firstNode==null) return; 
		
		if (firstNode!=null && firstNode.value==value){
			firstNode=firstNode.next;
			size--;
		}
		else{
			Node previousNode=firstNode;
			Node currentNode=firstNode.next;
			
			while (currentNode!=null){
				if (currentNode.value==value){
					previousNode.next=currentNode.next;
					size--;
					return;
				}
				else{
					previousNode=currentNode;
					currentNode=previousNode.next;
				}
			}
		}
	}

	public int size() {
		return size;
	}

}
