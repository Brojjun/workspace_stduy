package com.ssafy.off06;

public class LinkedStack<E> implements IStack<E> {
	
	class Node<T>{
		T data;
		Node<T> link;
		Node(T data, Node<T> link){
			this.data = data;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + ", link=" + link + "]";
		}
		
	}
	
	Node<E> top;
	@Override
	public void push(E data) {
		top = new Node(E, top);
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			System.out.println("없음");
			return null;
		}
		Node<E> node = top;
		top = top.link;
		node.link = null;
		return node.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			System.out.println("없음");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top==null;
	}

	@Override
	public int size() {
		int cnt = 0;
		for(Node<E> im = top; im.link != null; im = im.link) cnt++;
		return cnt;
	}

}
