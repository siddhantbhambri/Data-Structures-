package Lecture15_Heap;

public class HeapNode<V> {
	
	int priority;
	V value;
	HeapNode(V data,int priorirty){
		this.value=data;
		this.priority=priorirty;
	}

}
