package com.bac.linkedList;

public class CircularlyLinkedList<E> {
	
	private Node<E> tail = null;
	private int size = 0;
	
	public CircularlyLinkedList() {
		
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
		return tail.getNext().getElement();
	}
	
	public E last() {
		if(isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
	
	public void rotate() {
		if(tail != null) {
			tail = tail.getNext();
		}
	}
	
	public void addFirst(E e) {
		if(isEmpty()) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		}else {
			Node<E> newItem = new Node<>(e, tail.getNext());
			tail.setNext(newItem);
		}
		size++;
	}
	
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}
	
	public E removeFirst() {
		if(isEmpty()) {
			return null;
		}
		Node<E> head = tail.getNext();
		if(head == tail) {
			tail = null;
		}else {
			tail.setNext(head.getNext());
			size --;
		}
		return head.getElement();
	}
	
	
	
	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node<E> node = tail.getNext();
		E e = node.getElement();
		while(node != null && e != node.getNext().getElement()) {
			builder.append(node);
			builder.append("\n");
			node = node.next;
			
		}
		return builder.toString();
	}*/
	
	public String toString(){
	    String str = "";
	    Node<E> head = tail.getNext();
	    if (head != null){
	        Node<E> current = head;
	        do {
	            str = str + current.getElement();
	            current = current.getNext();
	            if (current != head && current != null){
	                str = str + ", ";
	            }
	        } while(current != head && current != null);
	    }
	    return str;
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
			return "Node [\n\"element\"=\"" + element + "\", \nnext\"=\"" + next + "\n]";
		}
	}

}
