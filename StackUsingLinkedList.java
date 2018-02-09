package Stacks;

public class StackUsingLinkedList<T> {

	LinkedListNode<T> top;
	private int size;

	public StackUsingLinkedList() {
		size = 0;
	}

	public void push(T data) {
		LinkedListNode<T> nayaNode = new LinkedListNode<>(data);
		nayaNode.next = top;
		top = nayaNode;
	}

	public T pop() throws StackUnderFlow {

		if (top == null) {
			throw new StackUnderFlow();
		}

		T temp = top.data;
		top = top.next;
		return temp;
	}

	public T top() throws StackUnderFlow {

		if (top == null) {
			throw new StackUnderFlow();
		}
		return top.data;

	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public int size() {
		return size;
	}

}
