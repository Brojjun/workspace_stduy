package com.ssafy.off06;

public class LinkedList<T> {
	class Node<E> {
		public E data;
		public Node node;
		public Node(E data, Node node) {
			super();
			this.data = data;
			this.node = node;
		}
		public Node(E data) {
			super();
			this.data = data;
		}
		public Node(Node node) {
			super();
			this.node = node;
		}
		public Node() {
			super();
		}	
	}
	
	public Node<T> top;
	public Node<T> bottom;
	
	void push(T t){
		boolean cnt = false;
		if(isEmpty()) cnt = true;
		top = new Node<T>(t,top);
		if(cnt) bottom = top;
	}
	
	T pop() {
		if(isEmpty()) {
			System.out.println("불가능");
			return null;
		}
		Node<T> temp = top;
		top = top.node;
		temp.node = null;
		if(isEmpty())bottom = null;
		return temp.data;
	}
	
	void concat(LinkedList<T> another) {
		this.bottom.node = another.top;
		this.bottom = another.bottom;
	}
	
	boolean isEmpty() {
		return top == null;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Node<T> start = top; start != null; start = start.node) {
			sb.append(start.data.toString() + " ");
		}
		return sb.toString();
	}
}
