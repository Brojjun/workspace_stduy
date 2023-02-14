package com.ssafy.live06.linkedList;

public class ArrayList {
	static private int[] arr;
	static private int size;
	
	ArrayList(){arr = new int[10]; size = 0;};
	ArrayList(int n){arr = new int[n]; size = 0;};
	
	static public int get(int n) {
		return arr[n];
	}
	
	static public void add(int n) {
		if(size+1 > arr.length) {
			int[] imm = new int[arr.length * 2];
			for(int i = 0; i <= size; i++) imm[i] = arr[i];
			arr = imm;
		}
		arr[size++] = n;
	}
	
	static public void remove(int n) {
		for(int i = n; i <= size; i++) {
			arr[i] = arr[i+1];
		}
		arr[size--] = 0;
	}
	
}
