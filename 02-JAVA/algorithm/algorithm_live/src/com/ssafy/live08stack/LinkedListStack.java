package com.ssafy.live08stack;

public class LinkedListStack<T> implements IStack1<T> {

	private Node<T> top;
	
	@Override
	public void push(T e) {
		// top으로 삽입
		top = new Node<T>(e, top);
		
	}

	@Override
	public T pop() {
		if(isEmpty()) {
			System.out.println("공백스택");
			return null;
		}
		
		Node<T> popNode = top;
		top = popNode.link;
		popNode.link = null;
		
		return popNode.data;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			System.out.println("공백스택");
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
		
//		for(Node<T> next = top; next != null; next = next.link) {
//			cnt++;
//		}
		
		Node<T> next = top;
		
		while(next != null) {
			cnt++;
			next = next.link;
		}
		return cnt;
	}

}
