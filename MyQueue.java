package linkedlistproblems;

import java.util.NoSuchElementException;

// Implementation of queue using linked list and template.
// Time Complexity: add: O(1), remove: O(1), peek: O(1) 
// Space Complexity: O(n) where n is the number of elements in the queue.

public class MyQueue<T> {
	private QueueNode<T> first;
	private QueueNode<T> last;
	private QueueNode<T> head = last;

	public static void main(String args[]) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		System.out.println("Addition of Elements: 23 45 32 ");
		q.add(23);
		q.add(45);
		q.add(32);
		System.out.println("Peek Queue:" + q.peek());
		System.out.println("Deletion of 2 elements: ");
		q.remove();
		q.remove();
		System.out.println("Peek Queue:" + q.peek());
	}

	public void add(T data) {
		QueueNode<T> t = new QueueNode<T>(data);

		if (last != null) {
			last.next = t;
			last = last.next;
		}

		if (last == null && first == null) {
			last = t;
			first = last;
		}
	}

	public T remove() {
		if (first == null)
			throw new NoSuchElementException();
		T data = first.data;
		first = first.next;

		if (first == null) {
			last = null;
		}
		return data;
	}

	public T peek() {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}

	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

}

/*
Output

Addition of Elements:23 45 32
Peek Queue:23
Deletion of 2 elements:
Peek Queue:
32
*/