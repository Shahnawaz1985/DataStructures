package com.bac.linkedList;

public class DLLMain {
	
	public static void main(String[] args) {
		DoublyLinkedList<String> dLList = new DoublyLinkedList<>();		
		dLList.addFirst("Ram");
		dLList.addLast("Shyam");
		dLList.addLast("shahnawaz");
		dLList.addLast("akhter");
		dLList.addLast("mantu");
		dLList.addLast("azhar");
		dLList.addLast("asif");		
		dLList.addLast("Bill");
		dLList.addLast("Jack");
		dLList.addLast("Ramesh");
		dLList.addLast("Madhav");
		dLList.addLast("Sonu");
		dLList.addLast("Amol");		
		dLList.addLast("shetty");
		dLList.addLast("Sanjana");
		
		System.out.println("Elements of dLList:");
		System.out.println(dLList);
		
		String middleElement = dLList.findMiddle();
		System.out.println("Element at Middle position:"+middleElement);
		System.out.println("------------------------------------");
		DoublyLinkedList<String> dLList2 = new DoublyLinkedList<>();
		dLList2.addLast("Suresh");
		dLList2.addLast("Abhishek");
		dLList2.addLast("Ojha");		
		dLList2.addLast("Amol");
		dLList2.addLast("Pandey");		
		System.out.println("Elements of dLList2:");
		System.out.println(dLList2);
		
		System.out.println("Find intersection of dLList and dLList2:");
		String intersectionElement = dLList.findIntersection(dLList, dLList2);
		System.out.println(intersectionElement);
	}

}
