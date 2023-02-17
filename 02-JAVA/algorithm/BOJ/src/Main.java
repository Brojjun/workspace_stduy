import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class July2 implements Comparable<July2>{
	int w;
	int v;
	public July2(int w, int v) {
		super();
		this.w = w;
		this.v = v;
	}
	
	@Override
	public int compareTo(July2 o) {
		return o.v - this.v;
	}
	
}

class July implements Comparable<July>{
	int w;
	int v;
	public July(int w, int v) {
		super();
		this.w = w;
		this.v = v;
	}
	
	@Override
	public int compareTo(July o) {
		if(this.w == o.w) return o.v - this.v;
		return this.w - o.w;
	}
	
}

public class Main {
	static int start = 100;
	static int end;
	static int cnt = 0;
	static int[] input = {};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		end = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		input = new int[10 - m];
		int[] imm = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			imm[i] = Integer.parseInt(st.nextToken());
		}
		int at = 0;
		int aat = 0;
		for(int i = 0; i < 10; i++) {
			if(i == at) {at++; continue;}
			input[aat++] = i;
		}


		for(int i = 0; i < input.length; i++)System.out.println(input[i]);
		
		
		
	}




}
