package com.bac.arrays;

import java.security.SecureRandom;
import java.util.Random;

public class FastPointer {

	private static int[] numbers = new int[100];

	static {
		Random rand = new SecureRandom();
		for (int i = 1; i <= numbers.length; i++) {
			numbers[i - 1] = rand.nextInt(50);
		}
	}

	public static void main(String[] args) {
		System.out.println("printing Array:");
		printArrayContents(numbers);
		searchMidElement(numbers);
	}
	
	private static void printArrayContents(int[] numbers2) {
		for (int i : numbers2) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	private static void searchMidElement(int[] array) {
		int start = 0;
		int end = array.length;
		int mid = (start + end) / 2;
		for (int i = 0; i < end; i += 2) {
			if(i == mid) {
				System.out.println("Middle Element at :"+i+", and middle element is: "+array[i]);
			}
		}
	}
}
