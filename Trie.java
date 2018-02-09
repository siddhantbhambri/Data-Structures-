package Trie;

public class Trie {

	TrieNode root;

	int noOfEntries = 0;

	Trie() {
		root = new TrieNode('\0');
	}

	public int size() {
		return noOfEntries;
	}

	public boolean isEmpty() {
		return noOfEntries == 0 ? true : false;
	}

	public boolean addWord(String word) {
		return addWord(word, root);
	}

	private boolean addWord(String word, TrieNode root) {
		if (word.length() == 0) {
			if (root.isWord == false) {
				root.isWord = true;
				return true;
			}
			return false;
		}

		char firstChar = word.charAt(0);
		TrieNode node = root.children.get(firstChar);

		if (node == null) {
			node = new TrieNode(firstChar);
			root.children.put(firstChar, node);
		}

		return addWord(word.substring(1), root.children.get(firstChar));
	}

	public boolean searchWord(String word) {
		return searchWord(word, root);
	}

	private boolean searchWord(String word, TrieNode root) {
		if (word.length() == 0) {
			if (root.isWord == true) {
				return true;
			}
			return false;
		}
		char firstChar = word.charAt(0);
		if (root.children.get(firstChar) == null) {
			return false;
		}
		return searchWord(word.substring(1), root.children.get(firstChar));
	}

	public boolean deleteWord(String word) {
		return deleteWord(word, root);
	}

	private boolean deleteWord(String word, TrieNode root) {
		if (word.length() == 0) {
			if (root.isWord == true) {
				root.isWord = false;
				return true;
			}
			return false;
		}

		char firstChar = word.charAt(0);
		TrieNode node = root.children.get(firstChar);
		if (node == null) {
			return false;
		}

		boolean result = deleteWord(word.substring(1), root.children.get(firstChar));
		if (node.isWord != true && node.children.size() == 0) {
			root.children.put(firstChar, null);
		}
		return result;
	}

}
