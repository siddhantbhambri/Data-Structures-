package Trees;

public class BinaryTree extends BinaryTreeNode<Integer> {

	public BinaryTree(Integer data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	private BinaryTreeNode<Integer> root = null;

	public void setLeft(BinaryTreeNode<Integer> node) {
		left = node;
	}

	public void setRight(BinaryTreeNode<Integer> node) {
		right = node;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int data) {

		if (node == null) {
			node = new BinaryTreeNode<Integer>(data);
		} else {
			if (node.getRight() == null) {
				node.right = insert(node.right, data);
			} else
				node.left = insert(node.left, data);
		}

		return node;
	}

	public int countNodes() {

		return countNodes(root);
	}

	private int countNodes(BinaryTreeNode<Integer> node) {

		if (node == null) {
			return 0;
		} else {
			int ans = 1;
			ans += countNodes(node.getRight());
			ans += countNodes(node.getLeft());
			return ans;
		}
	}

	public boolean search(int val) {
		return search(root, val);
	}

	private boolean search(BinaryTreeNode<Integer> node, int val) {

		if (node.getData() == val) {
			return true;
		}

		if (node.getLeft() != null) {
			if (search(node.getLeft(), val)) {
				return true;
			}
		}

		if (node.getRight() != null) {
			if (search(node.getRight(), val)) {
				return true;
			}
		}

		return false;
	}

	public void inorder() {

		inorder(root);
	}

	private void inorder(BinaryTreeNode<Integer> node) {

		if (node != null) {
			inorder(node.getLeft());
			System.out.println(node.getData() + " ");
			inorder(node.getRight());
		}
	}

	public void preorder() {

		preorder(root);
	}

	private void preorder(BinaryTreeNode<Integer> node) {

		if (node != null) {
			System.out.println(node.getData() + " ");
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}

	public void postorder() {

		postorder(root);
	}

	private void postorder(BinaryTreeNode<Integer> node) {

		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.println(node.getData() + " ");
		}
	}

}
