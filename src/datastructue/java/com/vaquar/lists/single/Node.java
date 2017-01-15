package datastructue.java.com.vaquar.lists.single;

public class Node {

	int value;
	Node next;
	
	public Node(int value) {
		this.value=value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
