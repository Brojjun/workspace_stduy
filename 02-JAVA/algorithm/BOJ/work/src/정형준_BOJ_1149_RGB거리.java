import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
boj 1463 : 1로 만들기
*/

public class 정형준_BOJ_1149_RGB거리 {

	static int memo[][] = new int[1001][3];
	static int rgb[][] = new int[1001][3];
	static int bn;
	static int savecol[] = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bn = Integer.parseInt(br.readLine());
		for (int i = 0; i < bn; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		memo[0][0] = rgb[0][0];
		memo[0][1] = rgb[0][1];
		memo[0][2] = rgb[0][2];

		dp(1,bn);
//		for(int i = 0; i < bn; i++) {
//			for(int j = 0; j < 3; j++) {
//				System.out.print(memo[i][j] + " ");
//			}
//			System.out.println();
//		}
		int number = Integer.MAX_VALUE;
		for(int i = 0 ; i < 3; i++) {
			if(number > memo[bn-1][i])number = memo[bn-1][i];
		}
		System.out.println(number);
	}

	static void dp(int begin, int end) {
		memo[begin][0] = rgb[begin][0] + Math.min(memo[begin-1][1], memo[begin-1][2]);
		memo[begin][1] = rgb[begin][1] + Math.min(memo[begin-1][0], memo[begin-1][2]);
		memo[begin][2] = rgb[begin][2] + Math.min(memo[begin-1][0], memo[begin-1][1]);
		
		if (begin == end - 1)
			return;
		dp(begin + 1, end);
	}

}
