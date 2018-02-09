package Arrays;

public class Arrays2 {

	public static void insertionSort(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j > 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}

	}

	public static void printIntersection(int arr1[], int arr2[]) {

		insertionSort(arr1);
		insertionSort(arr2);

		int i = 0;
		int j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else if (arr1[i] == arr2[j]) {
				System.out.print(arr1[i] + " ");
				i++;
				j++;
			}
		}
	}

	public static void triplets(int arr[], int sum) {

		int start1 = 0;
		int start2 = 1;
		int end = arr.length;

		while (start1 < arr.length && start2 < arr.length && end > 0) {
			if (arr[start1] + arr[start2] + arr[end] == sum) {
				System.out.println(arr[start1] + " " + arr[start2] + " " + arr[end]);
			} else {
				start1++;
				start2++;
				end--;
			}
		}
	}

	public static void rotationalNumber(int arr[]) {

		for (int i = 0; i < arr.length + 1; i++) {
			if (arr[i] > arr[i + 1]) {
				System.out.println(i + 1);
			}
		}
	}

	public static void waveLikeSorting(int arr[]) {

		insertionSort(arr);

		for (int i = 0; i < arr.length; i = i + 2) {
			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void sorting0s1sAnd2s(int arr[]) {

		int lo = 0;
		int hi = arr.length - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (arr[mid]) {
			case 0: {
				temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				temp = arr[mid];
				arr[mid] = arr[hi];
				arr[hi] = temp;
				hi--;
				break;
			}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		// int arr1[]={2,4,6,8,0,4,8,9};
		// int arr2[]={1,4,2,6,3,7,8,9,0};
		// printIntersection(arr1, arr2);
		// int arr[] ={1,2,3,4,5,6,7,8,9,0};
		// int sum = 13;
		// triplets(arr, sum);
		// int arr[]={1,2,3,4,5,6};
		// waveLikeSorting(arr);
		int arr[] = { 1, 0, 0, 2, 2, 1, 0, 1 };
		sorting0s1sAnd2s(arr);
	}

}