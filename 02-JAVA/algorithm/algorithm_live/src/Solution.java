import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int BN = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= BN; testcase++) {
			int size = Integer.parseInt(br.readLine());
			int[][] map = new int[size + 1][size + 1];
			int[][] vis = new int[size + 1][size + 1];
			
			// input
			for (int y = 0; y < size; y++) {
				String a = br.readLine();
				for (int x = 0; x < size; x++) {
					map[y][x] = a.charAt(x) - '0';
				}
			}
		

			// count
			int money = 0;
			int middle = size / 2;
			int[] dir = { -1, 1 };
			for (int y = 0; y < size; y++) {
				money += map[y][middle];
				//vis[y][middle] = 1;
				if (y <= middle) {
					for (int move = 1; move <= y; move++) {
						for (int d = 0; d < 2; d++) {
							int nx = middle + (move * dir[d]);
							money += map[y][nx];
							//vis[y][nx] = 1;
						}
					}
				}
				
				else{
					for (int move = 1; move < size - y; move++) {
						for (int d = 0; d < 2; d++) {
							int nx = middle + (move * dir[d]);
							money += map[y][nx];
							//vis[y][nx] = 1;
						}
					}
				}
				

			}
//			for (int y = 0; y < size; y++) {
//				for (int x = 0; x < size; x++) {
//					System.out.print(vis[y][x] + " ");
//				}
//				System.out.println();
//			}
			
			System.out.println("#" + testcase + " " + money);

		}

	}
}
