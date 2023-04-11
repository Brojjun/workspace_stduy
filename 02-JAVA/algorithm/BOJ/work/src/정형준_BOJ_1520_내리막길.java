import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정형준_BOJ_1520_내리막길 {
	static int by, bx;
	static long cnt = 0;
	static int map[][];
	static int memo[][];
	static int dy[] = { 1, -1, 0, 0 };
	static int dx[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		by = Integer.parseInt(st.nextToken());
		bx = Integer.parseInt(st.nextToken());
		map = new int[by][bx];
		memo = new int[by][bx];
		for (int i = 0; i < by; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < bx; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1;
			}
		}
		// memo[by - 1][bx - 1] = 1;
		// 인자 y, x, 이전데이터,
		playGame(0, 0);
//		for (int i = 0; i < by; i++) {
//			for (int j = 0; j < bx; j++) {
//				System.out.print(memo[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(memo[0][0]);
	}

	private static int playGame(int y, int x) {
		if (y == by - 1 && x == bx - 1) {
			return 1;
		}
		if (memo[y][x] == -1) {
			memo[y][x] = 0;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny >= by || nx >= bx)
					continue;
				if (map[ny][nx] >= map[y][x])
					continue;

				memo[y][x] += playGame(ny, nx);
			}
		}
		return memo[y][x];
	}
}
