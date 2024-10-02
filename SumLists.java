package linkedlistproblems;

// Sum Lists:You have 2 nos represented by a linked list, where each node contains a single digit. The digits are sotred in reverse order, 
// such that the 1's digit is at the head of the list. Write a function that adds the two numbers and 
// returns the sum as a linked list.
// Example: Input: (7->1->6) + (5->9->2). That is, 617 + 295.
// Output 2->1->9. That is 912.
// Solution: The overall time complexity  of the program is O(n), where n is the number of nodes in the input linked list.
// Space Complexity: 1. Recursive Call in calcSum - Since the calcSum method is  recursive, it uses space proportional to the depth of recursion,
// which is proportional to the number of nodes in the list. This contributes O(n) space.
// 2. New Nodes for the resultant linked list.
// 3. Space for input linked lists.
public class SumLists {
	static int digit1 = 0;
	static int digit2 = 0;
	static int count = 0;
	static Node l1 = null;
	static Node l2 = null;
	static Node sumList = null;
	static Node currentNode = null;

	public static void main(String args[]) {
		Node head = createNodes();
		Node q = head;
		int carry = 0;

		extractNum(q);
		l1 = buildLinkedList(digit1);
		l2 = buildLinkedList(digit2);

		calcSum(l1, l2, 0);

		while (sumList != null) {
			System.out.println(sumList.data);
			sumList = sumList.next;
		}
	}

	private static void calcSum(Node l1, Node l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return;
		}

		// Get the values from the nodes, or 0 if the node is null
		int l1Value = (l1 != null) ? l1.data : 0;
		int l2Value = (l2 != null) ? l2.data : 0;

		int tempSum = (l1Value + l2Value) % 10 + carry;
		int tempCarry = (l1Value + l2Value) / 10;
		// Create a new node with the new digit
		Node newNode = new Node(tempSum);

		// If the sum list is empty, this is the first node (head)
		if (sumList == null) {
			sumList = newNode;
			currentNode = newNode; // Keep track of the current node
		} else {
			currentNode.next = newNode; // Append the new node to the list
			currentNode = newNode; // Move the current node pointer
		}
		calcSum((l1 != null) ? l1.next : null, (l2 != null) ? l2.next : null, tempCarry);
		// calcSum(l1.next, l2.next, tempCarry);
	}

	private static void extractNum(Node q) {
		if (q == null) {
			return;
		}
		int sum = 0;
		int temp = q.data;
		count += 1;

		// Move to the next node and check if q is null before accessing data
		if (q.next != null) {
			q = q.next;
			temp = temp + (q.data * 10); // Get the second node's data
		}

		// Move to the next node and check if q is null before accessing data
		if (q.next != null) {
			q = q.next;
			temp = temp + (q.data * 100); // Get the third node's data
		}

		if (count == 1)
			digit1 = temp;
		else
			digit2 = temp;

		extractNum(q.next);

	}

	private static Node createNodes() {
		Node a1 = new Node(7);
		Node a2 = new Node(1);
		Node a3 = new Node(6);
		Node a4 = new Node(5);
		Node a5 = new Node(9);
		Node a6 = new Node(2);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = null;

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

	public static Node buildLinkedList(int digit1) {
		Node head = null; // Head of the linked list
		Node current = null; // Pointer to the current node

		int temp = digit1;

		// Extract digits and create the linked list
		while (temp != 0) {
			int digit = temp % 10; // Get the last digit

			// Create a new node with the current digit
			Node newNode = new Node(digit);

			if (head == null) {
				head = newNode; // First node becomes the head
			} else {
				current.next = newNode; // Link the previous node to the new one
			}

			current = newNode; // Move to the new node
			temp = temp / 10; // Remove the last digit
		}

		return head;
	}
}

// Output:
// 2
// 1
// 9