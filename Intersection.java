package linkedlistproblems;

public class Intersection {
	public static void main(String args[]) {
		Node l1 = createList1();
		Node l2 = createList2();

		// Get Tail and Sizes
		Result result1 = getTailAndSize(l1);
		Result result2 = getTailAndSize(l2);

		// If different tail nodes, then there's no intersection.
		if (result1.tail != result2.tail) {
			System.out.println("No Intersection");
			System.exit(0);
		}

		// Set pointers to the start of each linked list.
		Node shorter = result1.size < result2.size ? l1 : l2;
		Node longer = result1.size < result2.size ? l2 : l1;

		// Move the pointer of the longer list forward by the size difference.
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));

		// Traverse both lists until they intersect.
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		// Output the data at the intersection node, or print a message if there's no
		// intersection.
		if (shorter != null) {
			System.out.println("Intersection at node with data: " + shorter.data);
		} else {
			System.out.println("No Intersection");
		}
	}

	private static Node getKthNode(Node longer, int abs) {
		Node current = longer;
		while (abs > 0 && current != null) {
			current = current.next;
			abs--;
		}
		return current;
	}

	private static Result getTailAndSize(Node l) {
		if (l == null)
			return null;
		int size = 1;
		Node current = l;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size); // Return the tail node and size of the list
	}

	static class Result {
		Node tail;
		int size;

		Result(Node tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	private static Node createList1() {
		Node a1 = new Node(3);
		Node a2 = new Node(1);
		Node a3 = new Node(5);
		Node a4 = new Node(9);
		Node a5 = new Node(7);
		Node a6 = new Node(2);
		Node a7 = new Node(1);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5; // Intersection starts here
		a5.next = a6;
		a6.next = a7;

		return a1;
	}

	private static Node createList2() {
		Node b1 = new Node(4);
		Node b2 = new Node(6);

		b1.next = b2;
		b2.next = createList1().next.next.next.next; // Make list2 intersect list1 at node 7

		return b1;
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
