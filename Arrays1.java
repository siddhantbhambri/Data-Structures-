package Arrays;

import java.util.Scanner;

public class Arrays1 {

	public static void decimalToBinary(int num) {

		int arr[] = new int[100];
		int i = 0;
		while (num > 0) {

			arr[i] = num % 2;
			num = num / 2;
			i++;
		}

		for (int n = i - 1; n >= 0; n--) {
			System.out.print(arr[n] + " ");
		}

	}

	public static void separateSummations() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int arr[] = new int[10];
		System.out.println("Enter 10 random positive and negative numbers.");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0) {
				sum1 = sum1 + arr[i];
			}
			if (arr[i] < 0) {
				sum2 = sum2 + arr[i];
			}
		}

		System.out.println("The sum of all positive numbers of the array is" + sum1 + ".");
		System.out.println("The sum of all negative numbers of the array is" + sum2 + ".");

	}

	public static void sumOfTwoArrays(int[] arr1, int[] arr2) {

		int result[] = new int[Math.max(arr1.length, arr2.length) + 1];
		if (arr1.length < arr2.length) {
			for (int i = result.length + 1; i > 0; i--) {
				for (int j = arr1.length + 1; j > 0; j--) {
					for (int k = arr2.length + 1; k > 0; k--) {
						int sum = arr1[j] + arr2[k];
						if (sum <= 9) {
							result[i] = sum;
						} else if (sum > 9) {
							int carry = sum / 10;
							result[i] = sum % 10;
							result[i - 1] = arr1[j - 1] + arr2[k - 1] + carry;
						}
					}
				}
			}
		}
	}

	public static void sort0sAnd1s(int arr[]) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = 1;
				arr[temp++] = 0;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		// int []input1 = {1,2,4};
		// int []input2 = {4,5,6};
		// sumOfTwoArrays(input1, input2);

		// decimalToBinary(12);
		// int arr1[]={1,0,0,1,1,1,0,1,0};
		// sort0sAnd1s(arr1);
	}

}
