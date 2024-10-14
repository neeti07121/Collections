package linkedlistproblems;

// Binary Search Tree operations: Insertion, Searching and Inorder Traversal.
public class BinarySearchTree {

	public static void main(String args[]) {
		BST bst = new BST();

		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);

		// Print inorder Traversal (sorted Order)
		System.out.println("Inorder Traversal of Binary Search Tree");
		bst.inorder();

		System.out.println("Is 20 present:" + bst.search(20));
		System.out.println("Is 24 present:" + bst.search(24));

	}

	static class TreeNode {
		int data;
		TreeNode left, right;

		public TreeNode(int item) {
			this.data = item;
			left = right = null;
		}
	}

	static class BST {
		TreeNode root;

		BST() {
			root = null;
		}

		void insert(int key) {
			root = insertRec(root, key);
		}

		TreeNode insertRec(TreeNode root, int key) {
			if (root == null) {
				root = new TreeNode(key);
				return root;
			}

			if (key < root.data) {
				root.left = insertRec(root.left, key);
			} else {
				root.right = insertRec(root.right, key);
			}

			return root;
		}

		boolean search(int key) {
			return searchKey(root, key);
		}

		boolean searchKey(TreeNode root, int key) {
			if (root == null) {
				return false;
			} else if (root.data == key) {
				return true;
			}

			if (key < root.data) {
				return searchKey(root.left, key);
			} else {
				return searchKey(root.right, key);
			}

		}

		// Inorder Traversal of BST
		void inorder() {
			inorderRec(root);
		}

		public void inorderRec(TreeNode root) {
			if (root == null) {
				return;
			}

			inorderRec(root.left);
			System.out.println(root.data);
			inorderRec(root.right);

		}
	}
}

// Output
/*
Inorder Traversal of Binary Search Tree
20
30
40
50
60
70
80
true
false
*/