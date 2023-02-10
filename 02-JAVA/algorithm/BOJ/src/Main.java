import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static int[] memo = new int[1009000];
	public static int N;
	public static int minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		// bruteforce(N, 0);

		memo[1] = 1; // 1
		memo[2] = 2; // 1 + 1
		memo[3] = 3; // 1 + 1 + 1
		memo[4] = 1; // 2
		memo[5] = 2; // 2 + 1
		memo[6] = 3; // 2 + 1 + 1
		memo[7] = 4; // 2 + 1 + 1 + 1
		// 7은 7의 가장 큰 제곱근인 memo[4] + 나머지 값인 memo[3]
		/*
		 * for(int i = 7; i <= N; i++) dynamicprogram(N);
		 */

		dynamicprogram(N);
		System.out.println(memo[N]);
	}

	private static int dynamicprogram(int num) {
		if (num <= 1)
			return num;
		if ((Math.sqrt(num) % 1) == 0) {
			memo[num] = 1;
			System.out.println(num + " : " + memo[num]);
			return 1;
		} 
		else {
			int a = 0;
			for (int i = num; i > 0; i--) {
				if (memo[i] != 0) {
					a = i;
					break;
				}
			}
			System.out.println(a);
			return memo[num] = memo[a] + dynamicprogram(num - a);
		}
	}

	private static void bruteforce(int num, int cnt) {
		if (num == 0) {
			minCnt = Math.min(cnt, minCnt);
			return;
		}

		int n = (int) Math.sqrt(num);

		for (int i = 1; i <= n; i++) {
			bruteforce(num - (i * i), cnt + 1);
		}

	}
}