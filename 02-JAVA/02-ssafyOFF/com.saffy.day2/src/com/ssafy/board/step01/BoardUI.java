/*
 * public
 * protected
 * private
 * default
 */


package com.ssafy.board.step01;

import java.util.Arrays;
import java.util.Scanner;

class BoardUI {
	Scanner in = new Scanner(System.in);
	Board[] list = new Board[2];
	private int pos = 0;//배열의 크기와 입력의 위치
	
	void start() {
		System.out.println("게시판 관리 프로그램 V1");
		
		while (true) {

			switch (menu()) {
			case 1:
				list();
				break;
				
			case 2:
				write();
				break;
				
			case 0:
				quit();
				return;
			}
		}
		
	}

	private void quit() {
		System.out.println("종료 메뉴 선택");
	}

	private void list() {
		System.out.println("------------------------------");
		System.out.println("글번호\t제목\t글쓴이");
		System.out.println("------------------------------");
		if(pos == 0)
			System.out.println("등록된 게시글이 존재하지 않습니다.");
		for(int i = pos-1; i >= 0; i--) {
			Board b = list[i];
			System.out.println(b.no + "\t" + b.title + "\t" + b.writer);
		}
		
	}

	private void write() {
		//배열의 크기가 꽉 찼다면?
		if(list.length == pos) {
			Board[] temp = new Board[pos*2];
			//list = Arrays.copyOf(list, pos*2);
			System.arraycopy(list, 0, temp, 0, list.length);
			/*
			for(int i = 0; i < list.length; i++) {
				temp[i] = list[i];
			}
			*/
			list=temp;
		}
		System.out.println("Author : ");
		String writer = in.nextLine();
		System.out.println("Title : ");
		String title = in.nextLine();
		System.out.println("Content : ");
		String content =in.nextLine();
		
		Board b = new Board(writer,title,content);
		b.no = Sequence.nextVal();
		list[pos++] = b;
		System.out.println("END");
	}
	
	private int menu() {
		System.out.println("------------------------------");
		System.out.println("1. 목록          ");
		System.out.println("2. 등록          ");
		System.out.println("0. 종료          ");
		System.out.println("------------------------------");
		System.out.println("메뉴(번호)");
		return Integer.parseInt(in.nextLine());
	}
}
