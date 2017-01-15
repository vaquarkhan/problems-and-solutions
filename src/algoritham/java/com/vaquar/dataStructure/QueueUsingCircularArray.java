package algoritham.java.com.vaquar.dataStructure;

import java.lang.reflect.Array;

/**
 * Based on
 * https://www.youtube.com/watch?v=z3R9-DkVtds
 * Data Structure & Alogorithm: Queue using Circular Array by Ripon Datta
 * 
 * 1) When front and rear are equal there is no data.
 * 2) For each addition rear get incremented to new (empty) position, and for each removal
 *    front get moved right to point to the next available element. 
 * 3) Q Size (N - front + rear) % N :where N is total array size allocated
 * 4) Resize the array as part of adding new element and founding front and rear are equal 
 *    OR size is reached the MAX value. 
 * 5) While resizing add the element from front to rear to the new array.
 *  
 * 
 *
 */
public class QueueUsingCircularArray <T> {
	T[] array;
	int front = 0;
	int rear = 0;
	int N;
	Class<T> clazz;

	public QueueUsingCircularArray(Class<T> clazz, int size) {
		N = size;
		this.clazz = clazz;
		array = (T[]) Array.newInstance(clazz, N);
	}

	public int size() {
		return (N - front + rear) % N; //Important %
	}

	public void add(T data) {
		int size = size();
		if (size() == N - 1) { //Full Size achieved
			resize();
		}
		array[rear++] = data;
		if (rear == N) {
			rear = 0;
		}
	}

	private void resize() {
		int size = size();
		N = N * 2;
		T[] newArray = (T[]) Array.newInstance(clazz, N);
		int i = 0;
		while (size > 0) {
			size--;
			newArray[i++] = array[front++];
			if (front == array.length) {
				front = 0;
			}
		}
		rear = i;
		front = 0;
		array = newArray;
	}

	public T remove() {
		if (size() == 0) {
			return null;
		}
		T data = array[front++];
		array[front - 1] = null;
		if (front == N) {
			front = 0;
		}
		return data;
	}

	public static void main(String[] args) {
		QueueUsingCircularArray ca = new QueueUsingCircularArray(Integer.class, 5);
		ca.add(1);
		ca.add(2);
		ca.add(3);
		ca.remove();
		ca.add(4);
		ca.add(5);
		ca.add(55); //RESIZE
		ca.remove();
		ca.remove();
		ca.add(6);
		ca.add(7);
		ca.add(8);
		ca.add(9);
		ca.add(10);
		
		
	}

}
