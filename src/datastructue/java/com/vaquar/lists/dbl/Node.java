package datastructue.java.com.vaquar.lists.dbl;

public class Node {
	
	Node previous;
	Node next;
	String value;
	
	public Node(String value) {
		this.value=value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
