package linkedlistproblems;

import java.util.EmptyStackException;

// Algorithm to implement a Stack. A stack can be implemented using a linked list, if items were added and removed from the same side.
// Time Complexity for push(), pop(), peek() and isEmpty() is O(1).
// Space Complexity is O(n) where n is the no of elements in the stack.

public class StackImplTemplate<T> {
	private StackNode<T> top;

	public static void main(String args[]) {
		StackImplTemplate<Integer> cl = new StackImplTemplate<Integer>();
		cl.push(23);
		cl.push(56);
		cl.push(87);

		System.out.println("Peek: " + cl.peek());
		System.out.println("Pop:" + cl.pop());
		System.out.println("Pop:" + cl.pop());

		System.out.println("IsEmpty: " + cl.isEmpty());
		System.out.println("Peek: " + cl.peek());
		System.out.println("Pop: " + cl.pop());
		System.out.println("IsEmpty: " + cl.isEmpty());

	}

	public boolean isEmpty() {
		return top == null;
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public T pop() {
		if (top == null)
			throw new EmptyStackException();

		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T data) {
		StackNode<T> item = new StackNode<T>(data);
		item.next = top;
		top = item;
	}

	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

}


/*Output
Peek: 87
Pop:87
Pop:56
IsEmpty: false
Peek: 23
Pop: 23
IsEmpty: true
*/
