package linkedlistproblems;

import java.util.ArrayList;

// Problem: Statck of Plates: Imagine a stack of plates. IF the stack gets too high, it might topple. Therefore, in real life, we would likely
// start a new stack when the previous stack exceeds some threshold. Implement a data structure that mimics this. SetOfStacks should be
// composed of several stacks and should create a new stack once the previous one exceeds capacity. SetofStacks.push() and SetofStacks.pop()
// should behave identically to a single stack (i.e. pop() should return the same values as it would if there were just a single stack.

public class StackOfPlates {
	private static Node top = null;
	private static Node last = null;
	private static int lastStacks = -1;

	public static void main(String args[]) {
		Stacks s = new Stacks(4);
		s.push(23);
		s.push(43);
		s.push(24);
		s.push(87);

		s.push(98);
		s.push(34);
		s.push(43);
		s.push(23);

		s.push(76);
		s.push(32);

		System.out.println("Popped: " + s.pop());
		System.out.println("Popped: " + s.pop());

		s.printAll(); // Print all remaining elements across all plates
		// s.printAll(); // Print all elements across all plates
		// s.popAt(2);
	}

	static class Stacks {
		ArrayList<StackPlate> plates = new ArrayList<StackPlate>();
		int plateCapacity;

		Stacks(int capacity) {
			this.plateCapacity = capacity;
		}

		public void push(int no) {
			if (plates.isEmpty() || plates.get(plates.size() - 1).isFull()) {
				StackPlate newPlate = new StackPlate(plateCapacity);
				plates.add(newPlate);
			}
			StackPlate currentPlate = plates.get(plates.size() - 1);
			currentPlate.push(no);
		}

		// Pop operation
		public int pop() {
			if (plates.isEmpty()) {
				throw new RuntimeException("Stack is empty.");
			}
			StackPlate currentPlate = plates.get(plates.size() - 1); // plates.size() returns the current no of elments in the 
			// ArrayList Plates
			int poppedValue = currentPlate.pop();

			// If the current plate becomes empty after popping, remove it
			if (currentPlate.isEmpty()) {
				plates.remove(plates.size() - 1);
			}

			return poppedValue;
		}

		// Print all elements across all stack plates
		public void printAll() {
			for (int i = plates.size() - 1; i >= 0; i--) {
				StackPlate plate = plates.get(i);
				plate.print();
			}
		}
	}

	static class StackPlate {
		private int capacity;
		private Node localTop = null;
		private Node localBottom = null;

		public int size = 0;

		StackPlate(int capacity) {
			this.capacity = capacity;

		}

		// Pop the top element from this stack plate
		int pop() {
			if (localTop == null) {
				throw new RuntimeException("Stack plate is empty.");
			}
			int poppedValue = localTop.data;
			localTop = localTop.next; // Move the top pointer down
			size--;
			return poppedValue;
		}

		void push(int no) {
			Node newNode = new Node(no);
			newNode.next = localTop;
			localTop = newNode;

			if (size == 0) {
				localBottom = newNode; // First element, set as bottom
			}

			size++;
		}

		// Check if this stack plate is full
		public boolean isFull() {
			return size >= capacity;
		}

		// Check if this stack plate is empty
		public boolean isEmpty() {
			return size == 0;
		}

		// Print the stack from top to bottom in this plate
		public void print() {
			Node current = localTop;
			while (current != null) {
				System.out.println(current.data);
				current = current.next;
			}
		}

	}

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}

// Output
/*
Popped: 32
Popped: 76
23
43
34
98
87
24
43
23
*/