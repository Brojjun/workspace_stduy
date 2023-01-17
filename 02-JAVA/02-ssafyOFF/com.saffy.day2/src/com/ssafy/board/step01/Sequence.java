package com.ssafy.board.step01;

class Sequence {
	private static int no = 1;
	
	static int nextVal() {
		return no++;
	}
	static void set(int no) {
		Sequence.no = no;
	}
}
