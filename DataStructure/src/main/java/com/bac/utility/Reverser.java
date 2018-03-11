package com.bac.utility;

public class Reverser {
	
	public static void main(String[] args) {
		reverse(123456789);
		reverse(123456789000012345L);
	}
	
	private static long reverse(long number) {
		long reverse = 0;
		int count = 0;
		if(number == 0) {
			reverse = 0;
		}
		long temp = number;
		while (temp > 0) {
			++count;
			temp = temp/10;
		}
		System.out.println("Digit count for "+number+" is :"+count);
		long tempNo = number;
		while(count > 0) {
			long digit = tempNo % 10;			
			reverse = reverse*10 + digit;
			tempNo = tempNo/10;
			count--;
		}
		System.out.println("Reverse number is:"+reverse);
		
		return reverse;
	}

}
