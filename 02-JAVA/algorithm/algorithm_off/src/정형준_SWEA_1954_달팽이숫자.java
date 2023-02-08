import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int BN = Integer.parseInt(br.readLine());

		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		for (int i = 1; i <= BN; i++) {
			
			int N = Integer.parseInt(br.readLine());
			int cnt = 1;
			int x = 0;
			int y = 0;
			int nx = 0;
			int ny = 0;
			int dir = 0;
			int[][] map = new int[N][N];
			map[y][x] = cnt++;
			while (true) {
				nx = x + dx[dir];
				ny = y + dy[dir];
				
				int aaa= 0;
				for (int l = 0; l < 4; l++) {
					int yy = y + dy[l];
					int xx = x + dx[l];
					if(yy < 0 || xx < 0 || yy >=N || xx >= N ) {
						aaa++;
						continue;
					}
					else if (map[yy][xx] != 0)
						aaa++;
				}
				
				if(aaa == 4)break;
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					dir = (dir + 1) % 4;
					continue;
				}
				if (map[ny][nx] != 0) {
					dir = (dir + 1) % 4;
					continue;
				}
				
				x = nx;
				y = ny;
				map[y][x] = cnt++;
			}
			System.out.println("#" + i);
			for(int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					System.out.print(map[a][b] + " ");
				}
				System.out.println();
			}
			
		}
	}

	

}