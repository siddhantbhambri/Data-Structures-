package Lecture15_Heap;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public abstract class Heap<V> {

	ArrayList<HeapNode<V>> heap;
	private int count = 0;

	public Heap() {

		heap = new ArrayList<>();
		count = 0;
	}

	protected int getLeftChildIndex(int index) {
		int leftChildIndex = 2 * index + 1;
		if (leftChildIndex > count) {
			return -1;
		}
		return leftChildIndex;

	}

	protected int getRightChildIndex(int index) {
		int rightChildIndex = 2 * index + 2;
		if (rightChildIndex > count) {
			return -1;
		}
		return rightChildIndex;

	}

	public int getParentIndex(int index) {
		if (index == 0) {
			return -1;
		}
		int parentIndex = (index - 1) / 2;
		return parentIndex;
	}

	public void swap(int index1, int index2) {
		HeapNode<V> temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}

	public HeapNode<V> getElementAtIndex(int index) {

		return heap.get(index);
	}

	public void insert(V value, int priority) throws HeapFullException {

		HeapNode<V> node = new HeapNode<>(value, priority);
		heap.add(node);

		shiftUp(count);
		count++;
	}

	abstract void shiftUp(int index){
		
	}

	abstract void shiftDown(int index){
		
	}

	public V removeHighestPriority() throws HeapIndexOutOfBoundsException {

		V min = heap.get(0).value;
		heap.set(0, heap.get(count - 1));
		heap.remove(heap.size() - 1);
		count--;
		shiftDown(0);
		return min;
	}

	public V getHighestPriority() {
		return heap.get(0).value;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0 ? true : false;

	}
}
