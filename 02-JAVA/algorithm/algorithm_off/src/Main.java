import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());

		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		// 구간합 구하기
		
		for (int i = 1; i <= N; i++) {
			map[i][0] = map[i-1][N];
			for (int j = 1; j <= N; j++) {
				map[i][j] = map[i][j] + map[i][j-1];
			}
		}
/*		System.out.println();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}*/
		
		// 답 구하기
		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st3.nextToken());
			int sx = Integer.parseInt(st3.nextToken());
			int ny = Integer.parseInt(st3.nextToken());
			int nx = Integer.parseInt(st3.nextToken());
			//System.out.println(map[ny][nx] + " " +  map[sy][sx]);
			System.out.println(map[ny][nx] - map[sy][sx-1]);
		}
	}
}
