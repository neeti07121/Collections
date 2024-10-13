package linkedlistproblems;
// Stack Main: Array Implementation Of Stack. How would you design a stack which, in addition to push and pop, has a function min which returns 
// the minimum element?  Push, pop and min should all operate in O(1) time.

public class StackMinArray {
	private static int arr[] = new int[10];
	private static int top = -1;
	private static int min = Integer.MAX_VALUE;

	public static void main(String args[]) {
		StackM m = new StackM();
		m.push(12);
		m.push(23);
		m.push(2);
		m.push(7);
		m.push(98);

		System.out.println("The top element is:" + m.peek());
		m.pop();
		System.out.println("The top element is " + m.peek());
		System.out.println("The minimum element is " + min);
		m.pop();
		m.pop();
		m.pop();
		m.pop();

	}

	static class StackM {
		public void push(int n) {
			if (top >= arr.length - 1) {
				throw new RuntimeException();
			}

			min = Math.min(min, n);

			arr[top + 1] = n;
			top = top + 1;

		}

		public int peek() {
			return arr[top];
		}

		public void pop() {
			if (top == -1) {
				throw new RuntimeException();
			}
			System.out.println("The deleted element is " + arr[top]);
			top = top - 1;

		}
	}

}

// Output
/*The top element is:98
The deleted element is 98
The top element is 7
The minimum element is 2
The deleted element is 7
The deleted element is 2
The deleted element is 23
The deleted element is 12
 */ 
