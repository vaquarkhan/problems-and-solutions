package algoritham.java.com.vaquar.tree;

/**
 * This class is not thread safe. 
 * 
 */
public class Counter {
	public int count = 0;
	
	public Counter() {}
	
	public Counter(int count) {
		this.count = count;
	}
	
	public int incrementAndGet(){
		return ++count;
	}
	
	public int decrementAndGet(){
		return --count;
	}
	
	public int get(){
		return count;
	}
	
	@Override
	public String toString() {
		return ""+count;
	}
}
