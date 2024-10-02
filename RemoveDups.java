package linkedlistproblems;

import java.util.HashSet;

// Write code to remove duplicates from an unsorted linked list.
// Solution: Time Complexity is O(N) where N is the number of elements in the doubly linked list.

public class RemoveDups {
	public static void main(String args[]) {
		Node n1 = new Node(12);
		Node n2 = new Node(12);
		Node n3 = new Node(12);
		Node n4 = new Node(13);

		n1.prev = null;
		n1.next = n2;

		n2.prev = n1;
		n2.next = n3;

		n3.prev = n2;
		n3.next = n4;

		n4.prev = n3;
		n4.next = null;

		Node head = n1;

		HashSet<Integer> hs = new HashSet<>();
		Node q = null;
		while (head != null) {
			if (hs.contains(head.data)) {
				q.next = head.next;
			} else {
				hs.add(head.data);
				q = head;
			}
			head = head.next;
		}

		System.out.println(hs);
	}

	static class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}

	}

}
