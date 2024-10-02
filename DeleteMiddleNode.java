package linkedlistproblems;

// Delete Middle Node: Implement an algorithm to delete a node in the middle(i.e., any node but the first and lasst node, not necessarily
// the exact middle) of a singly linked list, given only access to that node.
// Example
// Input: the node c from the linked list a->b->c->d->e->f
// Result: nothing is returned, but the new linked list looks like a->b->d->e->f

public class DeleteMiddleNode {
	static Node head = createNode();
	static Node q = head;

	public static void main(String args[]) {

		Node del = head.next.next;

		deleteMiddleNode(del);
		while (q != null) {
			System.out.println(q.data);
			q = q.next;
		}
	}

	private static void deleteMiddleNode(Node q) {
		System.out.println("Data to be deleted is "+q.data);
		q.data = q.next.data;
		q.next = q.next.next;
	}

	private static Node createNode() {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = null;

		return a;
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
