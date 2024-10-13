package linkedlistproblems;

import java.util.Stack;

// Problem: Queue Via Stack: Implement a MyQueue class which implements a queue using two stacks.

public class MyQueueUsingStack {
	public static void main(String args[]) {
		MyQueue1 q = new MyQueue1();

		q.enqueue(23);
		q.enqueue(43);
		q.enqueue(23);
		q.enqueue(5);
		q.enqueue(32);

		System.out.println("Item Popped is " + q.dequeue());

		System.out.println("Top element is:" + q.peek());

	}

	static class MyQueue1 {
		public Stack<Integer> stackOld; // Stack to push the elements;
		public Stack<Integer> stackNew; // Stack to pop or peek oldest elements.

		public MyQueue1() {
			stackOld = new Stack<Integer>();
			stackNew = new Stack<Integer>();
		}

		// Enqueue operation (push element to the back of the queue)
		public void enqueue(int x) {
			stackOld.push(x);
		}

		//
		public int dequeue() {
			shiftStacks(); //
			return stackNew.pop();

		}

		private void shiftStacks() {
			if (stackNew.isEmpty()) {
				while (!stackOld.isEmpty()) {
					stackNew.push(stackOld.pop());
				}
			}
		}

		public int peek() {
			shiftStacks();
			return stackNew.peek();
		}
	}

}

// Output
/* 
Item Popped is 23
Top element is:43
*/