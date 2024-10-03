package linkedlistproblems;

// Question: Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.

// Circular linked list: A (corrupt) linked list in which a node's next pointer popints to an earlier node, so as to make a loop in the linked list.
// Example: A->B->C->D->E->C[the same as earlier]
// The time complexity of this algorithm is O(n)
// The space complexity is O(1), since you are only using a fixed amount of extra space (the 2 pointers slow and fast and a flag variable). No 
// additional data structures or arrays are used, so the space used is constant.

public class LoopDetection {
	public static void main(String args[]) {
		Node head = createNodes();

		Node slow = head;
		Node fast = head;

		boolean flag = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = true;
				break;
			}
		}
		System.out.println(flag);
	}

	private static Node createNodes() {
		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		Node a5 = new Node(2);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a2;

		return a1;
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

// Output
// true