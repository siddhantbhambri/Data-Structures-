package HashMaps;

import java.util.ArrayList;

public class HashMap<K, V> {

	ArrayList<HashMapNode<K, V>> bucket;
	int bucketSize = 2;
	int noOfEntries = 0;

	public HashMap() {
		// TODO Auto-generated constructor stub

		bucket = new ArrayList<>();
		bucketSize = 10;
		for (int i = 0; i < bucketSize; i++) {
			bucket.add(null);
		}
	}

	public int size() {
		return noOfEntries;
	}

	public boolean isEmpty() {
		return noOfEntries == 0 ? true : false;
	}

	public void put(K key, V value) {

		int index = getIndex(key);

		HashMapNode<K, V> head = bucket.get(index);

		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		head = bucket.get(index);
		HashMapNode<K, V> newNode = new HashMapNode<>(key, value);
		newNode.next = head;
		bucket.set(index, newNode);
		noOfEntries++;
		if (noOfEntries * (1.0) / bucketSize > 0.75) {
			rehash();
		}
	}

	private void rehash() {

		ArrayList<HashMapNode<K, V>> temp = bucket;
		bucket = new ArrayList<>();

		bucketSize = bucketSize * 2;

		for (int i = 0; i < bucketSize; i++) {
			bucket.add(null);
		}

		noOfEntries = 0;
		for (HashMapNode<K, V> head : temp) {
			while (head != null) {
				put(head.key, head.value);
				head = head.next;
			}
		}
	}

	private int getIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		compress(hashCode);
		return 0;
	}

	private int compress(int hashCode) {
		return hashCode % bucketSize;
	}

	public V get(K key) {
		int index = getIndex(key);
		HashMapNode<K, V> head = bucket.get(index);
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public boolean delete(K key) {
		int index = getIndex(key);
		HashMapNode<K, V> head = bucket.get(index);

		if (head.key.equals(key)) {
			bucket.set(index, head.next);
			noOfEntries--;
			return true;
		}
		while (head.next != null) {
			if (head.next.key.equals(key)) {
				noOfEntries--;
				head.next = head.next.next;
				return true;
			}
			head = head.next;
		}
		return false;
	}

	public ArrayList<K> getKeys() {
		ArrayList<K> result = new ArrayList<>();
		for (int i = 0; i < bucketSize; i++) {
			HashMapNode<K, V> head = bucket.get(i);
			while (head != null) {
				result.add(head.key);
				head = head.next;
			}
		}

		return result;
	}

	public ArrayList<V> getValues() {

		ArrayList<V> result = new ArrayList<>();
		for (int i = 0; i < bucketSize; i++) {
			HashMapNode<K, V> head = bucket.get(i);
			while (head != null) {
				result.add(head.value);
				head = head.next;
			}
		}

		return result;
	}

}
