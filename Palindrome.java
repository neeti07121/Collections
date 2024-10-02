package linkedlistproblems;

import java.util.Stack;
// Palindrome: Implement a function to check if a linked list is a palindrome.
// noon
// racecar

public class Palindrome {
	public static void main(String args[]) {
		Node head = createNodes();

		System.out.println("Is Palindrome " + isPalindrome(head));

	}

	private static boolean isPalindrome(Node head) {
		Node fast = head;
		Node slow = head;

		Stack<String> stack = new Stack<String>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		// Has odd no of elements, so skip the middle element
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			String top = stack.pop();
			if (!top.equals(slow.data)) {
				return false;
			}
			slow = slow.next;
		}

		return true;
	}

	private static Node createNodes() {
		Node a1 = new Node("r");
		Node a2 = new Node("a");
		Node a3 = new Node("c");
		Node a4 = new Node("e");
		Node a5 = new Node("c");
		Node a6 = new Node("a");
		Node a7 = new Node("r");

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;

		return a1;

	}

	static class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
		}
	}
}

// Output:
// Is Palindrome true
