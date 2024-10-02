package linkedlistproblems;

public class SumLists {
	static int digit1 = 0;
	static int digit2 = 0;
	static int count = 0;
	static Node l1 = null;
	static Node l2 = null;

	public static void main(String args[]) {
		Node head = createNodes();
		Node q = head;
		int carry = 0;

		extractNum(q);

		int sum = calcSum(digit1, digit2, carry);

		System.out.println(digit1);
		System.out.println(digit2);
	}

	private static int calcSum(int digit12, int digit22, int carry) {

		return 0;
	}

	private static void extractNum(Node q) {
		if (q == null) {
			return;
		}
		int sum = 0;
		int temp = q.data;
		count += 1;

		if (count == 1) {

		}
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

}
