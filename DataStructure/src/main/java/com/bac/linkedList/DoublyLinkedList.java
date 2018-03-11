package com.bac.linkedList;

public class DoublyLinkedList<E> {
	
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	public DoublyLinkedList() {
		header = new Node<>(null, null,null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
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
		}else {
			return header.getNext().getElement();
		}		
	}
	
	public E last() {
		if(isEmpty()) {
			return null;
		}else {
			return trailer.getPrev().getElement();
		}
	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newNode = new Node<>(e, predecessor, successor);
		predecessor.setNext(newNode);
		successor.setPrev(newNode);
		size++;
	}
	
	private E remove(Node<E> e) {
		Node<E> predecessor = e.getPrev();
		Node<E> successor = e.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return e.getElement();
	}
	
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}	
	
	public E removeFirst() {
		if(isEmpty()) {
			return null;
		}else {
			return remove(header.getNext());
		}
	}
	
	public E removeLast() {
		if(isEmpty()) {
			return null;
		}else {
			return remove(trailer.getPrev());
		}
	}
	
	/*
	 * Concept of fast and slow pointer.
	 */
	public E findMiddle(){
		Node<E> slowPtr = header;
		Node<E> fastPointer = header;
		while(slowPtr != null && fastPointer != null && fastPointer.next != null) {
			slowPtr = slowPtr.next;
			fastPointer = fastPointer.next.next;
		}
		System.out.println("Slow Pointer at :"+slowPtr.getElement()+", fastPointer at :"+fastPointer.getElement());
		return slowPtr.getElement();
	}
	
	public E findIntersection(DoublyLinkedList<E> list1, DoublyLinkedList<E> list2) {
		Node<E> tempNode1 = list1.header;
		Node<E> tempNode2 = list2.header;
		E element = null;
		int size1 = list1.size;
		int size2 = list2.size;
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
			if(current_1.getElement().equals(current_2.getElement())||
					current_1.getElement().equals(current_2.getPrev().getElement())||
					current_1.getElement().equals(current_2.getNext().getElement())) {
				
				element = (E) current_1.getElement();
				break;
			}
			}
			current_1 = current_1.getNext();
			current_2 = current_2.getNext();
		}
		return element;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node<E> node = header;
		while(node != null) {
			builder.append(node);
			builder.append("\n");
			node = node.next;
			
		}
		builder.append("Size:"+size);
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
		DoublyLinkedList other = (DoublyLinkedList) obj;
		if (size != other.size)
			return false;
		Node walkA = header;
		Node walkB = other.header;
		
		while(walkA.next != null) {
			if(!walkA.getNext().getElement().equals(walkB.getNext().getElement())) {
				return false;
			}
			walkA = walkA.next;
			walkB = walkB.next;
		}
		return true;
	}



	private static class Node<E>{
		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
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
		    return "Node [Element=" + element + ", next=" + (next==null?"null":next.element) + ", prev=" + (prev==null?"null":prev.element) + "]";
		}		
	}

}
