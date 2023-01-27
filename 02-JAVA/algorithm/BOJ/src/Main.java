import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int map[];
	static int virtual[];
	static int bn;

	public static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bn = Integer.parseInt(br.readLine());
		map = new int[bn];
		virtual = new int[bn];

		for (int i = 0; i < bn; i++)
			map[i] = Integer.parseInt(br.readLine());

	}

	public static void divide(int begin, int end) {
		int mid = (begin + end) / 2;
		if (begin < end) {
			divide(begin, mid);
			divide(mid + 1, end);
		}
		else
			merge(begin, mid, end);

	}

	public static void merge(int begin, int mid, int end) {
		int left = begin;
		int right = mid;
		int cnt = begin;
		
		while(left <= mid && right <= end) {
			if(map[left] < map[right]) 
				virtual[cnt++] = map[left++];
			
			else if(map[left] >= map[right])
				virtual[cnt++] = map[right++];
		}
		
		if(left > mid) {
			while(right < end) {
				virtual[cnt++] = map[left++];
			}
		}
		else if(right > end) {
			while(left < mid) {
				virtual[cnt++] = map[right++];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		divide(0, bn-1);
		// print
		for (int i = 0; i < bn; i++) {
			System.out.println(virtual[i]);
		}

	}
}
