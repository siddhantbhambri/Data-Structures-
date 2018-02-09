package LinkedList;

import java.util.Scanner;

public class LinkedList {

	public static void printList_R(Node<Integer> head) {

		if (head == null) {
			return;
		}
		printList_R(head.next);
		System.out.println(head.data);
	}

	public static Node<Integer> reverseList_I(Node<Integer> head) {

		Node<Integer> curr = head;
		Node<Integer> prev = null;
		Node<Integer> fwd = null;

		while (curr != null) {
			fwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fwd;
		}

		return prev;
	}

	public static Node<Integer> reverseList_R(Node<Integer> head) {

		if (head.next == null) {
			return head;
		}
		Node<Integer> finalHead = reverseList_R(head.next);
		head.next.next = head;
		head.next = null;

		return finalHead;
	}

	public static int searchIndex(Node<Integer> head, int element) {

		if (head == null) {
			return -1;
		}
		if (head.data == element) {
			return 0;
		}
		int smallResult = searchIndex(head.next, element);
		if (smallResult == -1) {
			return -1;
		} else {
			return smallResult + 1;
		}
	}

	public static Node<Integer> prepareLinkedList() {

		Node<Integer> head = null;
		Node<Integer> tail = null;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter data.");
		int data = scan.nextInt();

		while (data != -1) {
			Node<Integer> nayaNode = new Node<Integer>(data);
			if (head == null) {
				head = nayaNode;
				tail = nayaNode;
			} else {
				tail.next = nayaNode;
				tail = tail.next;
			}
			System.out.println("Enter data.");
			data = scan.nextInt();
		}
		return head;
	}

	public static void printList_I(Node<Integer> head) {

		Node<Integer> temp = head;
		while (temp != null) {
			System.out.println(temp.data + "--->");
			temp = temp.next;
		}
	}

	public static Node<Integer> insertNode_R(Node<Integer> head, int pos, int data) {

		if (pos == 1) {
			Node<Integer> nayaNode = new Node<Integer>(data);
			nayaNode.next = head;
			return nayaNode;
		}
		head.next = insertNode_R(head.next, pos - 1, data);
		return head;
	}

	public static Node<Integer> deleteNode(Node<Integer> head, int pos, int data) {

		if (pos == 1) {
			return head.next;
		}
		head.next = deleteNode(head.next, pos - 1, data);
		return head;
	}

	public static Node<Integer> insertNode_I(Node<Integer> head, int pos, int data) {

		Node<Integer> nayaNode = new Node<Integer>(data);
		if (pos == 1) {
			nayaNode.next = head;
			head = nayaNode;
		} else {
			Node<Integer> temp = head;
			int count = 1;
			while (count < pos - 1) {
				temp = temp.next;
				count++;
			}
			nayaNode.next = temp.next;
			temp.next = nayaNode;
		}
		return head;
	}

}
