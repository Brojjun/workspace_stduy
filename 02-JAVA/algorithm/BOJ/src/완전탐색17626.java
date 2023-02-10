import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	
	public static long[] memo = new long[1009];
	public static int N;
	public static int minCnt = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		
		cal(N, 0);
		System.out.println(minCnt);
	}
	private static void cal(int num, int cnt) {
		if(num == 0) {
			minCnt = Math.min(cnt, minCnt);
			return;
		}
		
		int n = (int)Math.sqrt(num);
		
		for(int i = 1; i <= n; i++) {
			cal(num - (i*i), cnt+1);
		}
		
	}
}