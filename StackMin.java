package linkedlistproblems;

// Problem: How would you design a stack which, in addition to push  and pop, has a function min which returns the minimum element?

// Push,pop and min should all operated in O(1) time.

public class StackMin {
	private static Node top = null;

	public static void main(String args[]) {
		Stack s = new Stack();
		s.push(23);
		s.push(45);
		s.push(56);
		s.push(12);
		s.push(89);

		s.pop();
		s.pop();
		s.seek();

		System.out.println("Now the min element is " + s.getMin());
	}

	static class Stack {
		public void push(int no) {
			Node node = new Node(no, (top == null) ? no : Math.min(no, top.min));

			node.next = top;
			top = node;

		}

		public void pop() {
			if (top == null) {
				throw new RuntimeException();
			}
			System.out.println("Item deleted is:" + top.data);
			top = top.next;

		}

		public int seek() {
			return top.data;
		}

		public int getMin() {
			return top.min;
		}

	}

	static class Node {
		private int data;
		private int min;
		private Node next;

		public Node(int data, int min) {
			this.data = data;
			this.min = min;
			this.next = null;
		}

	}

}

// Output
//Item deleted is:89
//Item deleted is:12
//Now the min element is 23
