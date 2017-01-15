package datastructue.java.com.vaquar.queue;


public class Node<Item> {

	Item item;
	Node<Item> next;
	
	public Node(Item item) {
		this.item=item;
	}
	
	@Override
	public String toString() {
		return String.valueOf(item);
	}

}
