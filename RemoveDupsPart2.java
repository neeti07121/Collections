package linkedlistproblems;

// Write Code to remove duplicates from an unsorted linked list.
// How would you solve the problem if a temporary buffer is not allowed?
// This code runs in O(1) space, but O(N^2) time.

public class RemoveDupsPart2 {
	public static void main(String args[]) {
		Node head = createNode();
		Node q = head;

		while (head != null) {
			Node current = head;
			while (current.next != null) {
				if (current.next.data == head.data) {
					current.next = current.next.next;
				} else {
					current = current.next;
				}
			}
			head = head.next;
		}

		while (q != null) {
			System.out.println(q.data);
			q = q.next;
		}

	}

	private static Node createNode() {
		Node n1 = new Node(12);
		Node n2 = new Node(12);
		Node n3 = new Node(14);
		Node n4 = new Node(12);

		n1.prev = null;
		n1.next = n2;

		n2.prev = n1;
		n2.next = n3;

		n3.prev = n2;
		n3.next = n4;

		n4.prev = n3;
		n4.next = null;

		return n1;
	}

	static class Node {
		int data;
		Node prev;
		Node next;

		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
}

// Output
// 12
// 14
