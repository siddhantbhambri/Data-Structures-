package Queues;

import Stacks.LinkedListNode;

public class QueueUsingLinkedList<E> {

	LinkedListNode<E> front;
	LinkedListNode<E> rear;
	private int size;

	public QueueUsingLinkedList() {
		size = 0;
	}

	public void enqueue(E data) {
		LinkedListNode<E> newNode = new LinkedListNode<E>(data);
		if (size == 0) {
			front = newNode;
			rear = newNode;
		}

		rear.next = newNode;
		rear = rear.next;
		size++;
	}

	public E dequeue() throws QueueUnderFlowSException {

		LinkedListNode<E> temp = front;
		size--;
		front = front.next;
		if (size == 0) {
			front = null;
			rear = null;
		}
		return temp.data;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0 ? true : false;
	}

}
