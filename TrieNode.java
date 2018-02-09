package Trie;

import HashMaps.HashMap;

public class TrieNode {

	char data;
	HashMap<Character, TrieNode> children;
	boolean isWord;

	TrieNode(char data) {
		this.data = data;
		this.children = new HashMap<>();
		isWord = false;
	}

}
