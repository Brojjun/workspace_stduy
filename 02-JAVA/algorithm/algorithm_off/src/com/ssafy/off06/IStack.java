package com.ssafy.off06;

public interface IStack<E> {
	void push();
	E pop();
	E peek();
	boolean isEmpty();
	int size();
	void push(E data);
}
