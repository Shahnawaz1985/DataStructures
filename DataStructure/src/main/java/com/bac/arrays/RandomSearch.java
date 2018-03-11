package com.bac.arrays;

import java.security.SecureRandom;
import java.util.Random;

public class RandomSearch {

	private static int[] numbers = new int[100];

	static {
		Random rand = new SecureRandom();
		for (int i = 1; i <= numbers.length; i++) {
			numbers[i - 1] = rand.nextInt(50);
		}
	}

	public static void main(String[] args) {
		printArrayContents(numbers);
		System.out.println("Search for 41:" + randomSearch(numbers, 41));
		maximumAndMinimum(numbers);
	}

	private static void printArrayContents(int[] numbers2) {
		for (int i : numbers2) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	private static String randomSearch(int[] arry, int number) {
		int n = arry.length;
		String msg = null;
		if (arry[n - 1] == number) {
			msg = "Found";
		}
		int temp_no = arry[n - 1];
		arry[n - 1] = number;
		int counter = 0;
		for (int i = 0;; i++) {
			if (arry[i] == number) {
				++counter;
				arry[n - 1] = temp_no;
				if (i < n - 1) {
					msg = "Found at " + i;
				} else {
					msg = "Not Found";
				}
				break;
			}
		}
		return msg;
	}

	private static void maximumAndMinimum(int[] array) {
		int largest = array[array.length - 1];
		int smallest = array[0];
		for (int number : array) {
			if (number > largest) {
				largest = number;
			} else if (number < smallest) {
				smallest = number;
			}
		}
		System.out.println("Largest no :" + largest);
		System.out.println("Smallest no :" + smallest);
	}
}
