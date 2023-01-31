import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	
	static StringBuffer sb = new StringBuffer();

	
	static int[] map;
	static int bn;
	static long bc;
	static long end;


	public static boolean check(long cut) {
		long tree = 0;
		for(int i = 0; i < bn; i++)
			if(map[i] - cut > 0)
				tree += (map[i] - cut);
		
		return tree >= bc;
	}
	
	
	public static void binary_search() {
		long begin = 0;
		long end = 1000000001;
		
		while(begin + 1 < end) {
			long mid = (begin + end) / 2;
		
			if(check(mid)) {
				begin = mid;
				//System.out.println(begin +" : " + end);
			}
			else end = mid;
			
		}
		System.out.println(begin);
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		bn = sc.nextInt();
		bc = sc.nextInt();
		map = new int[bn];
		for(int i = 0; i < bn; i++) {map[i] = sc.nextInt(); end = Math.max(end, map[i]);}
		Arrays.sort(map);
		binary_search();
		
	}
}
