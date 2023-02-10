package com.ssafy.off05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Student implements Comparable<Student>{
	public String a;
	public String b;
	public int c;
	public Student(String a, String b,int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.c - o.c;
	}
	@Override
	public String toString() {
		return "Student [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
}
public class StackApiTest {
	public static void main(String[] args) {
		PriorityQueue<Student> q2 = new PriorityQueue<>();
		q2.offer(new Student("1피지컬1","add",1));
		q2.offer(new Student("2피지컬100","sdd",2));
		q2.offer(new Student("3피지컬100","dcd",3));
		q2.offer(new Student("4피지컬100","vdd",4));
		q2.offer(new Student("5피지컬100","gdd",5));
		System.out.println(q2.poll().toString());
		System.out.println(q2.peek().toString());
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		
		
		
		Queue<String> q = new LinkedList<>();
		q = new ArrayDeque<>();
		
		// 어레이디큐 : 배열기반 <-> 링크드리스트 기반
		System.out.println(q.isEmpty() + " : " +q.size());
		q.add("슬");
		q.offer("램");
		q.add("덩");
		q.offer("크");
		
		System.out.println(q.size());
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.size());
		
		
	
	}
}
