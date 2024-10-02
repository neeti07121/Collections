package linkedlistproblems;

// Implement an algorithm to find the kth to last element of a singly linked list.

public class ReturnKthToLast {
	public static void main(String args[]) {
		Node head = createNodes();
		Node q = head;

		int k = 2;
		int index = printKthToLast(head, k);

		while (q != null) {
			System.out.println(q.data);
			q = q.next;
		}

	}

	private static int printKthToLast(Node head, int k) {
		if (head == null) {
			return 0;
		}

		int index = printKthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th node to the last node is " + head.data);
		}

		return index;
	}

	private static Node createNodes() {
		Node n1 = new Node(12);
		Node n2 = new Node(13);
		Node n3 = new Node(14);
		Node n4 = new Node(15);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;

		return n1;
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

}
