package Strings;

public class Strings {

	public static void removeDuplicates(String input) {

		String result = new String();
		for (int i = 1; i < input.length(); i++) {
			for (int j = 0; j < result.length(); j++) {
				if (input.charAt(i - 1) != result.charAt(j)) {
					result = result + input.charAt(i);
				}
			}
		}
		System.out.print(result);
	}

	public static void highestOccurringCharacter(String input) {

	}

	public static void sortingArrayOfStrings(String[] input) {

		for (int i = 0; i < input.length; i++) {
			String temp = input[i];
			int j = i - 1;
			while (j > 0 && input[j].length() > temp.length()) {
				input[j + 1] = input[j];
				j--;
			}
			input[j + 1] = temp;
		}
	}

	public static void reverseEachWordSeparately(String input) {

		String[] words = input.split(" ");
		String result = "";

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String reverseWord = "";
			for (int j = word.length() - 1; j >= 0; j--) {
				reverseWord = reverseWord + word.charAt(j);
			}
			result = result + reverseWord + " ";
		}
		System.out.println(result);
	}

	public static void reverseStringWords(String input) {

		String[] words = input.split(" ");
		String result = "";

		for (int i = words.length - 1; i >= 0; i--) {
			result = result + words[i] + " ";
		}

		System.out.println(result);

	}
	
	public static void main(String[] args) {
		// String input = "aabccbaa";
		// removeDuplicates(input);
//
//		String input =  "aaabbccds";
//		String result = basicStringCompression(input);
//		System.out.println(result);
	}
}
