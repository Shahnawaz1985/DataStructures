package com.bac.arrays;

public class MissingNumber {

	private static int[] numbers = new int[100];
	private static int sum_of_100 = 0;
	private static int[] missing_number_array = new int[100];
	private static int[] duplicate_number_array = new int[100];
	static {
		for (int i = 1; i <= numbers.length; i++) {
			numbers[i - 1] = i;
		}
		for (int i = 1; i <= missing_number_array.length; i++) {
			missing_number_array[i - 1] = i;
		}
		for (int i = 1; i <= duplicate_number_array.length; i++) {
			duplicate_number_array[i - 1] = i;
		}
	}

	public static void main(String[] args) {
		printArrayContents(numbers);
		System.out.println(sum_of_100);
		missing_number_array[52] = 0;
		// printArrayContents(missing_number_array);
		int sum = calculateSum(missing_number_array);
		sum_of_100 = getSum(100);
		int missing_number = sum_of_100 - sum;
		System.out.println("Missing number :" + missing_number);
		System.out.println("Missing position:" + (missing_position(numbers, missing_number_array)));
		duplicate_number_array[50] = 52;
		int sum1 = calculateSum(duplicate_number_array);
		// difference tells how many numbers are duplicate - 1 for 1 number and so on.
		int duplicate_number = sum_of_100 - sum1;
		System.out.println("Duplicate number :" + findDuplicate(numbers, duplicate_number_array));
	}

	private static void printArrayContents(int[] numbers2) {
		for (int i : numbers2) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	private static int calculateSum(int[] arry) {
		int temp_sum = 0;
		for (int i = 0; i < arry.length; i++) {
			temp_sum = temp_sum + arry[i];
		}
		return temp_sum;
	}

	private static int getSum(int n) {
		return (n * (n + 1)) / 2;
	}

	private static int missing_position(int[] a1, int[] a2) {
		int missing_position = 0;
		int counter = 0;
		// int[] missing_number_array = new int[a2.length];
		if (a1.length == a2.length) {
			for (int i = 0; i < a1.length; i++) {
				if (a1[i] != a2[i]) {
					missing_position = i;
					++counter;
				}
			}
		}
		System.out.println("No of mismatch :" + counter);
		return missing_position;
	}

	private static int findDuplicate(int[] a1, int[] a2) {
		int duplicate_position = 0;
		int duplicate_number = 0;
		if (a1.length == a2.length) {
			for (int i = 0; i < a1.length; i++) {
				if (a1[i] != a2[i]) {
					duplicate_number = a2[i];
					duplicate_position = i;
				}
			}
		}
		System.out.println("Duplicate position :" + duplicate_position);
		return duplicate_number;
	}
}
