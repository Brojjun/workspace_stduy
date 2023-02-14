package com.ssafy.live06.linkedList;
class Node{
	Node node;
	int data;
	public int get() {
		return data;
	}
	
	public Node getNode() {return node;}
	public void set(Node node) {
		this.node = node;
	
	}
	
	public Node() {};
	
	public Node(int data) {
		super();
		this.data = data;
	}
	
	public Node(Node node, int data) {
		super();
		this.node = node;
		this.data = data;
	}
	
}

public class LinkedList {
	static public Node head = new Node();
	
	static public void add(int n) {
		Node now = new Node(n);
		if(head == null)
			head.set(now);
		else {
			now.set(head);
			head.set(now);
		}
	}
	
	static public void remove(int n) {
		int at = -1;
		Node next = head;
		while(next != null){
			if(head.get() == n) {
				//삭제
				return;
			}
			else {
				next = head.getNode();
			}
		}
	}
	
}
