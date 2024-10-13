package linkedlistproblems;

import java.util.Stack;

// Problem:  Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack,
// but you many not copy the elements into any other data structure (such as an array). The stack supports the following operations:
// push,pop,peek and isEmpty

public class SortStack {

	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(45);
		stack.push(4);
		stack.push(23);
		stack.push(20);

		sortStack(stack);

		System.out.println(stack);
	}

	public static void sortStack(Stack stack) {
		Stack<Integer> temp = new Stack<Integer>();

		while (!stack.isEmpty()) {
			int current = (int) stack.pop();

			while (!temp.isEmpty() && temp.peek() > current) {
				stack.push(temp.pop());
			}

			temp.push(current);
		}

		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}
	}
}

// Output
// [45, 23, 20, 4]
