package Trees;

public class BinaryTreeNode<T> {

	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	public BinaryTreeNode<T> getRight() {
		// TODO Auto-generated method stub
		return right;
	}

	public BinaryTreeNode<T> getLeft() {
		// TODO Auto-generated method stub
		return left;
	}

	public void setData(T d) {
		data = d;
	}

	public T getData() {
		return data;
	}

}
