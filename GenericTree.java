package Trees;

import Queues.QueueUnderFlowSException;
import Queues.QueueUsingLinkedList;

public class GenericTree {

	public static int count(MyTreeNode<Integer> root) {

		int totalCount = 0;
		for (int i = 0; i < root.getChildren().size(); i++) {
			totalCount = totalCount + count(root.getChildren().get(i));
		}

		return totalCount + 1;
	}

	public static int height(MyTreeNode<Integer> root) {

		int maxHeight = 0;

		for (int i = 0; i < root.getChildren().size(); i++) {
			int currentHeight = height(root.getChildren().get(i));
			if (currentHeight > maxHeight) {
				maxHeight = currentHeight;
			}
		}

		return maxHeight + 1;
	}

	public static int heightUsingQueue(MyTreeNode<Integer> root) throws QueueUnderFlowSException {
		QueueUsingLinkedList<MyTreeNode<Integer>> queue = new QueueUsingLinkedList<>();
		queue.enqueue(root);

		int level = 0;
		while (!queue.isEmpty()) {
			MyTreeNode<Integer> currentNode = queue.dequeue();

			for (int i = 0; i < currentNode.getChildren().size(); i++) {
				if (i == 0) {
					level++;
				}
				queue.enqueue(currentNode.getChildren().get(i));
			}
		}

		return level;
	}

}
