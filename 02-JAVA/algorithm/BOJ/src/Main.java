import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] map = new int[10][10];
	static int min_data = Integer.MAX_VALUE;

	static int number[] = { 5, 5, 5, 5, 5 };

	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		findPaper(0, 0, 0);//백트래킹 호출
		if(min_data == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min_data);
	}
	
	//백트래킹
	private static void findPaper(int cnt, int y, int x) {
		if(min_data <= cnt)return;//가지치기
		if (x == 10) {
			x = 0;
			y++;
		}
		
		if (y == 10) {//엔드 조건
			min_data = Math.min(min_data, cnt);
			return;
		}
		
		if (map[y][x] == 0) {//다음 위치 탐색
			findPaper(cnt, y, x + 1);
		}
		
		else if (map[y][x] == 1) {
			int possible = check(y, x);
			if (possible == 0 && number[0] == 0)
				return;
						
			for (int k = 0; k <= possible; k++) {
				if (number[k] == 0)
					continue;
				number[k]--;
				
				for(int yy = 0; yy <= k; yy++) {
					for(int xx = 0; xx <= k; xx++) {
						map[yy+y][xx+x] = 0;
					}
				}

				findPaper(cnt + 1, y, x + 1);

				number[k]++;
				for(int yy = 0; yy <= k; yy++) {
					for(int xx = 0; xx <= k; xx++) {
						map[yy+y][xx+x] = 1;
						
					}
				}

			}
		}
		return;
	}

	private static int check(int y, int x) {
		int yy = y;
		int xx = x;

		while (true) {
		    if (yy == 9 || map[yy+1][x] == 0) break;
		    yy++;
		}
		while (true) {
		    if (xx == 9 || map[y][xx+1] == 0) break;
		    xx++;
		}
		yy = yy - y;
		xx = xx - x;

		int minSquare = Math.min(yy, xx);
		if(minSquare >= 4) minSquare = 4;
		loop:
		while (true) {
			if(minSquare <= 0)break;
			for (int i = 0; i <= minSquare; i++) {
				for (int j = 0; j <= minSquare; j++) {
					if(map[y+i][x+j] == 0) {
						minSquare = Math.min(i-1,j-1);
						continue loop;
						}
				}
			}
			break;
		}
		if(minSquare < 0)minSquare = 0;
		return minSquare;
	}

}