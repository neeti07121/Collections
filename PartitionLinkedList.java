package linkedlistproblems;

// Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
// If x is contained within the list, the values of x only need to be after the elements less than x. The partition element x can appear 
// anywhere in the "right partition"; it does not need to appear between the left and right partitions.
// Input: 3->5->8->5->10->2->1
// Output: 3->1->2->10->5->5->8
// The overall time complexity is the sum of the two loops:
// O(n)+O(n) = O(n)
// Thus, the time complexity of the algorithm is O(n), where n is the number of nodes in the linked list.

public class PartitionLinkedList {

	public static void main(String args[]) {
		Node head = createNode();
		Node q = head;
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		int x = 5;

		while (q != null) {
			Node temp = q; // Assign the current node to temp
			q = q.next; // Move q to the next node in the original list before modifying temp
			temp.next = null; // Break the link for temp to ensure it is properly added to the new list
			if (temp.data < x) {
				if (beforeStart == null) {
					beforeStart = temp;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = temp;
					beforeEnd = beforeEnd.next;

				}
			} else {
				if (afterStart == null) {
					afterStart = temp;
					afterEnd = afterStart;
				} else {
					afterEnd.next = temp;
					afterEnd = afterEnd.next;

				}
			}

		}

		// Now merge the two lists
		beforeEnd.next = afterStart;

		// Partitioned List
		System.out.println("List after partition...");
		while (beforeStart != null) {
			System.out.println(beforeStart.data);
			beforeStart = beforeStart.next;
		}
	}

	private static Node createNode() {
		Node a1 = new Node(3);
		Node a2 = new Node(5);
		Node a3 = new Node(8);
		Node a4 = new Node(5);
		Node a5 = new Node(10);
		Node a6 = new Node(2);
		Node a7 = new Node(1);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = null;

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

/*
 * Output: List after partition... 3 2 1 5 8 5 10
 */
