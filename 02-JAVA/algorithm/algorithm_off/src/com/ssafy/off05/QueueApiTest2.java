package com.ssafy.off05;

import java.util.Stack;

public class QueueApiTest2 {
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		System.out.println(s.isEmpty() + " : " + s.size());
		
		s.push("오");
		s.push("금");
		s.push("내");
		s.push("주");
		
		System.out.println(s.toString());
		
		System.out.println(s.pop());
		System.out.println(s.peek());
		
	}
}
