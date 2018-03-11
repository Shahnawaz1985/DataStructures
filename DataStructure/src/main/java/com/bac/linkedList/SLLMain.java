package com.bac.linkedList;

public class SLLMain {
	
	public static void main(String[] args) {
		SinglyLinkedList<String> stringList =  new SinglyLinkedList<>();
		stringList.addFirst("Ram");
		stringList.addLast("Shyam");
		stringList.addLast("shahnawaz");
		stringList.addLast("akhter");
		stringList.addLast("mantu");
		stringList.addLast("azhar");
		
		stringList.addLast("asif");
		stringList.addLast("steve");
		stringList.addLast("Spinon");
		stringList.addLast("Bill");
		stringList.addLast("Jack");
		
		stringList.addLast("Ramesh");
		stringList.addLast("Suresh");
		stringList.addLast("Sonu");
		stringList.addLast("Sanjay");		
		stringList.addLast("shetty");
		stringList.addLast("Robert");
		stringList.addLast("Martin");
		stringList.addLast("Stewart");
		stringList.addLast("Jackson");
		stringList.addLast("Albert");
				
		System.out.println(stringList);
		
		String middleElement = stringList.findMiddle();
		System.out.println("Element at Middle position:"+middleElement);
		
		
		SinglyLinkedList<String> stringList2 =  new SinglyLinkedList<>();
		stringList2.addLast("Martin");
		stringList2.addLast("Martin2");
		stringList2.addLast("Martin3");
		stringList2.addLast("Martin11");
		
		System.out.println("Find intersection of dLList and dLList2:");
		String intersectionElement = stringList.findIntersection(stringList, stringList2);
		System.out.println(intersectionElement);
	}

}
