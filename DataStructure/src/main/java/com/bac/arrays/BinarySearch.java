package com.bac.arrays;

//Works for sorted array only.
public class BinarySearch {

	private static int[] numbers = new int[100];

	static {
		for (int i = 1; i <= numbers.length; i++) {
			numbers[i - 1] = i;
		}
	}

	public static void main(String[] args) {
		System.out.println("Position of 45 :" + binarySearch(numbers, 45));
		System.out.println("Position of 78 :" + binarySearch(numbers, 78));
	}

	private static int binarySearch(int[] arry, int number) {
		int match_position = -1;
		int start = 0;
		int end = arry.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (number == arry[mid]) {
				match_position = mid;
				break;
			}
			if (number < arry[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return match_position;
	}
}
