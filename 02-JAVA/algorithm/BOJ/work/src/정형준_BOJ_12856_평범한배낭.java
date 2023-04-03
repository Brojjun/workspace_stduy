import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;

public class 정형준_BOJ_12856_평범한배낭 {
	static int bn, bw;
	static int bag[][];
	static int memo[][];
	static int maxValue = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bn = Integer.parseInt(st.nextToken());
		bw = Integer.parseInt(st.nextToken());
		bag = new int[bn+1][2];
		memo = new int[bn+1][bw+1];
		for(int i = 1;i <= bn; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int w = 1; w <= bw; w++) {
			for(int n = 1; n <= bn; n++) {
				memo[n][w] = memo[n-1][w];
				if(w >= bag[n][0]) {
					memo[n][w] = Math.max(memo[n-1][w], bag[n][1] + memo[n-1][w-bag[n][0]]);
				}
			}
		}
		System.out.println(memo[bn][bw]);

	}


}
