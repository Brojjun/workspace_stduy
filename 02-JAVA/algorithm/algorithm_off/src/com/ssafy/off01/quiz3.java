package com.ssafy.off01;

/*
 * 2입력 -> 
 * 00
 * 01
 * 10
 * 11
 * 3입력 ->
 * 000
 * 001
 * 0
 * ...
 * 
 */
public class quiz3 {
	public static void main(String[] args) {
		solve(4,"");
	}

	
	private static void solve(int num, String st) {
		// TODO Auto-generated method stub
		if(st.length() >= num) {
			System.out.println(st);
			return;
		}
		
		for(int i = 0; i < 2; i++) 
			solve(num,st+Integer.toString(i));
		
	}

}
