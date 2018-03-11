package com.bac.linkedList;

public class CLLMain {
	
	public static void main(String[] args) {
		CircularlyLinkedList<String> cList = new CircularlyLinkedList<>();
		
		
		cList.addFirst("Ram");
		cList.addLast("Shyam");
		cList.addLast("shahnawaz");
		cList.addLast("akhter");
		cList.addLast("mantu");
		cList.addLast("azhar");
		
		cList.addLast("asif");
		cList.addLast("steve");
		/*cList.addLast("Spinon");
		cList.addLast("Bill");
		cList.addLast("Jack");
		
		cList.addLast("Ramesh");
		cList.addLast("Suresh");
		cList.addLast("Sonu");
		cList.addLast("Sanjay");		
		cList.addLast("shetty");
		cList.addLast("Sanjana");*/
				
		System.out.println(cList);
	}
}
