package com.ssafy.off01;

import java.util.Scanner;

public class Main {
	public static StringBuffer sb = new StringBuffer("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\r\n" + 
			"");
	
	public static void main(String[] args) {	
		sb.append("\"재귀함수가 뭔가요?\"\r\n");
		sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n");
		sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r\n");
		sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\r\n");
		
		
		Scanner sc = new Scanner(System.in);
		int bn = sc.nextInt();
		recursive(bn, 1);
		sb.delete(sb.length()-2, sb.length());
		System.out.println(sb.toString());
	}

	private static void recursive(int bn,int depth) {
		if(bn <= depth) {
			
			for(int i = 0; i < depth; i++)sb.append("____");
			sb.append("\"재귀함수가 뭔가요?\"\r\n");
			for(int i = 0; i < depth; i++)sb.append("____");
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\r\n");
			back_recursive(depth);
			return;
		}
		
		for(int i = 0; i < depth; i++)sb.append("____");
		sb.append("\"재귀함수가 뭔가요?\"\r\n");
		for(int i = 0; i < depth; i++)sb.append("____");
		sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n");
		for(int i = 0; i < depth; i++)sb.append("____");
		sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r\n");
		for(int i = 0; i < depth; i++)sb.append("____");
		sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\r\n");
		
		recursive(bn, depth+1);
	}
	
	private static void back_recursive(int depth) {
		if(depth < 0)return;
		for(int i = 0; i < depth; i++)sb.append("____");
		sb.append("라고 답변하였지.\r\n");
		back_recursive(depth - 1);
		
	}
	
}
