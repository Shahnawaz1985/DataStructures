package com.bac.linkedList;

public class SinglyLinkedList<E> {
	
	private Node<E> head = null;
	private Node<E> tail = null;
	
	private int size = 0;
	
	public SinglyLinkedList() {
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return head.getElement();
	}
	
	public E last() {
		if(isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
	
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if(size == 0) {
			tail = head;
			size++;
		}
	}
	
	public void addLast(E e) {
		Node<E> newItem = new Node<>(e, null);
		if(isEmpty()) {
			head = newItem;
		}else {
			tail.setNext(newItem);
		}
		tail = newItem;
		size++;
	}
	
	public E removeFirst() {
		if(isEmpty()) {
			return null;
		}
		E firstItem = head.getElement();
		head = head.getNext();
		size--;
		if(size == 0){
			tail = null;			
		}
		return firstItem;
		
	}
	/*
	 * Concept of fast and slow pointer.
	 */
	public E findMiddle(){
		Node<E> slowPtr = head;
		Node<E> fastPointer = head;
		while(slowPtr != null && fastPointer != null && fastPointer.next != null) {
			slowPtr = slowPtr.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}
		System.out.println("Slow Pointer at :"+slowPtr.getElement()+", fastPointer at :"+fastPointer.getElement());
		return slowPtr.getElement();
	}
	
	public E findIntersection(SinglyLinkedList<E> list1, SinglyLinkedList<E> list2) {
		Node<E> tempNode1 = list1.head;
		Node<E> tempNode2 = list2.head;
		E element = null;
		int size1 = list1.size();
		int size2 = list2.size();
		int diff_nodes = 0;
		if(size1 > size2) {
			diff_nodes = size1 - size2;
			element = getIntersection(diff_nodes, tempNode1, tempNode2);
		}else if(size2 < size1) {
			diff_nodes = size2 - size1;
			element = getIntersection(diff_nodes, tempNode2, tempNode1);
		}
		return element;		
		
	}
	
	private E getIntersection(int d, Node a, Node b) {
		Node current_1 = a;
		Node current_2 = b;
		E element = null;
		for(int i=0; i<d; i++) {
			if(current_1 == null) {
				return null;
			}
			current_1 = current_1.getNext();
		}
		
		while(current_1 != null && current_2 != null) {
			if(null != current_1.getElement() && null != current_2.getElement()) {
			if(current_1.getElement().equals(current_2.getElement())) {				
				element = (E) current_1.element;
				break;
			}
			}
			current_1 = current_1.next;
			current_2 = current_2.next;
		}
		return element;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SinglyLinkedList [\n\"head\"=\"").append(head).append("\", \ntail\"=\"").append(tail)
				.append("\", \nsize\"=\"").append(size).append("\n]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinglyLinkedList other = (SinglyLinkedList) obj;
		if (size != other.size)
			return false;
		Node walkA = head;
		Node walkB = other.head;
		while(walkA != null) {
			if(!walkA.getElement().equals(walkB.getElement())) {
				return false;
			}
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}

	private static class Node<E>{
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [element=").append(element).append(", next=").append(next).append("]");
			return builder.toString();
		}		
	}

}
