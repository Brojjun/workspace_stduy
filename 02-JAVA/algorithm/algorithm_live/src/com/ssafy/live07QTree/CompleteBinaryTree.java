package com.ssafy.live07QTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//완전이진트리 : 1차원 배열 구현
public class CompleteBinaryTree<T> {

	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new Object[size+1];
	}
	
	private boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(T e) {
		if(isFull())return;
		
		nodes[++lastIndex] = e;
		
	}
	
	public void bfs() {
		Queue<Integer> arr = new ArrayDeque<Integer>();
		arr.offer(1);
		
		int current = 0, lvl = 0;
		while(!arr.isEmpty()) { // 큐에 대기하고 있는 순서대로 노드를 처리
			
			System.out.print("lvl "  + lvl++ + " ");
			
			for(int i = 0, size = arr.size(); i < size; i++) {
				
				current = arr.poll();
				System.out.print(nodes[current] + " ");
				if(lastIndex >= current * 2) arr.add(current * 2);
				if(lastIndex >= 1 + current * 2) arr.add(1 + current * 2);
			}
			System.out.println();
			//다음 거 넣기
	
			
		}
	}
	
	public void dfs() {
		Stack<Integer> arr = new Stack();
		arr.push(1);
		
		int current = 0, lvl = 0;
		while(!arr.isEmpty()) { // 큐에 대기하고 있는 순서대로 노드를 처리
			
			System.out.print("lvl "  + lvl++ + " ");
			
			for(int i = 0, size = arr.size(); i < size; i++) {
				
				current = arr.pop();
				System.out.print(nodes[current] + " ");
				if(lastIndex >= 1 + current * 2) arr.push(1 + current * 2);
				if(lastIndex >= current * 2) arr.push(current * 2);
			}
			System.out.println();
			//다음 거 넣기
			
			
		}
	}
	
	public void dfsByPreorder() {
		System.out.print("preorder : ");
		dfsByPreOrder(1);
		System.out.println();
	}

	private void dfsByPreOrder(int current) {
		System.out.print(nodes[current] + " ");
		
		if(current*2 <= lastIndex) dfsByPreOrder(current*2);
		if((current*2+1) <= lastIndex) dfsByPreOrder(current*2+1);
		
	}
	
	public void dfsByInorder() {
		System.out.print("Inorder : ");
		dfsByPreOrder(1);
		System.out.println();
	}
	
	private void dfsByInOrder(int current) {
		
		if(current*2 <= lastIndex) dfsByPreOrder(current*2);
		System.out.print(nodes[current] + " ");
		if((current*2+1) <= lastIndex) dfsByPreOrder(current*2+1);
		
	}
	public void dfsByPostorder() {
		System.out.print("Postorder : ");
		dfsByPreOrder(1);
		System.out.println();
	}
	
	private void dfsByPostOrder(int current) {
		
		if(current*2 <= lastIndex) dfsByPreOrder(current*2);
		if((current*2+1) <= lastIndex) dfsByPreOrder(current*2+1);
		System.out.print(nodes[current] + " ");
		
	}
	
}
