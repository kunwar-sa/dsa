package P024QuickSort;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

	public static void main(String[] args) {

		// int[] arr = { 8, 1, 7, 2, 9 };
		List<Integer> arr = Arrays.asList(1, 2, 3, 4);
		quickSort(arr);

		for (int x : arr) {
			System.out.println(x);
		}
	}

	public static List<Integer> quickSort(List<Integer> arr) {
		// Write your code here.
		quick(arr, 0, arr.size() - 1);
		return arr;

	}

	public static void quick(List<Integer> arr, int s, int e) {

		if (s >= e)
			return;

		int pivot = partition(arr, s, e);

		quick(arr, s, pivot - 1);
		quick(arr, pivot + 1, e);
	}

	public static int partition(List<Integer> arr, int s, int e) {
		int p = arr.get(s);
		int count = 0;

		// logic to find the pivot index;
		int n = arr.size();
		for (int i = s + 1; i < n; i++)
			if (arr.get(i) < p)
				count++;
		int pivotIndex = s + count;

		// putting the start element at pivot
		int temp = arr.get(s);
		arr.set(s, arr.get(pivotIndex));
		arr.set(pivotIndex, temp);

		/*
		 * putting all the smaller and larget elements to the left and right of pivot
		 * element respectively
		 */
		int i = s;
		int j = e;

		while (i < pivotIndex && j > pivotIndex) {
			while (arr.get(i) < p)
				i++;
			while (arr.get(j) > p)
				j--;

			if (i < pivotIndex && j > pivotIndex) {
				temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
				i++;
				j--;
			}
		}

		return pivotIndex;
	}

}
