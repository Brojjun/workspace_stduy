package com.ssafy.live08stack;

public class StackTest {

	public static void main(String[] args) {
		IStack1<String> stack = new LinkedListStack<String>();
		
		System.out.println(stack.peek());
		System.out.println(stack.size());
		stack.push("1");
		stack.pop();
		System.out.println(stack.size());
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		stack.push("6");
		stack.push("7");
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
	}
}
