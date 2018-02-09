package Trees;

import java.util.ArrayList;

public class MyTreeNode<T> {
	
	private T data = null;
	private ArrayList<MyTreeNode<T>> children = new ArrayList<>();
	private MyTreeNode<T> parent = null;

	public MyTreeNode(T data) {
		this.data = data;
	}

	public void addChild(MyTreeNode<T> child) {
		child.setParent(this);
		this.children.add(child);
	}

	public void addChild(T data) {
		MyTreeNode<T> newChild = new MyTreeNode<>(data);
		newChild.setParent(this);
		children.add(newChild);
	}

	public void addChildren(ArrayList<MyTreeNode<T>> children) {

		for (MyTreeNode<T> t : children) {
			t.setParent(this);
		}

		this.children.addAll(children);
	}

	public ArrayList<MyTreeNode<T>> getChildren() {
		return children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	private void setParent(MyTreeNode<T> parent) {
		this.parent = parent;
	}

	public MyTreeNode<T> getParent() {
		return parent;
	}

}
