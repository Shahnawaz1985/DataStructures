package com.bac.arrays;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FindPairs {

	private static int[] numbers = new int[100];

	static {
		Random rand = new SecureRandom();
		for (int i = 1; i <= numbers.length; i++) {
			numbers[i - 1] = rand.nextInt(50);
		}
	}

	public static void main(String[] args) {
		printArrayContents(numbers);
		// printPairs(numbers, 34);
		//printPairsUsingSet(numbers, 45);
		printPairsUsingTwoPointers(numbers, 57);
	}

	private static void printArrayContents(int[] numbers2) {
		for (int i : numbers2) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	private static void printPairs(int[] array, int sum) {
		for (int i = 0; i < array.length; i++) {
			int first = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int second = array[j];
				if ((first + second) == sum) {
					System.out.printf("(%d, %d), %n", first, second);
				}
			}

		}
	}

	public static void printPairsUsingSet(int[] numbers, int n) {
		if (numbers.length < 2) {
			return;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int value : numbers) {
			int target = n - value; // if target number is not in set then add
			if (!set.contains(target)) {
				set.add(value);
			} else {
				System.out.printf("(%d, %d) %n", value, target);
			}
		}
	}
	
	
	public static void printPairsUsingTwoPointers(int[] numbers, int k){ 
		if(numbers.length < 2){
			return; 
			} 
		Arrays.sort(numbers); 
		System.out.println("After sorting:");
		printArrayContents(numbers);
		int left = 0; 
		int right = numbers.length -1; 
		while(left < right){
			int sum = numbers[left] + numbers[right]; 
			if(sum == k){
				System.out.printf("(%d, %d) %n", numbers[left], numbers[right]); 
				left = left + 1; 
				right = right -1; 
			}else if(sum < k){
				left = left +1; 
			}else if (sum > k) {
				right = right -1; 
			} 
		} 
	}
}
