import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int first = 0;
	static int second = 0;


	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		cal(1, 1, n);
		System.out.println(first);
		System.out.println(second);
		
	}

	private static void cal(int py, int px, int n) {
//		for (int y = py; y < py + n; y++) {
//			for (int x = px; x < px + n; x++) {
//				System.out.print(map[y][x] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

		int number = map[py][px];

		if (n == 1) {
			if (number == 0)
				first++;
			else if (number == 1)
				second++;

			return;
		}

		for (int y = py; y < py + n; y++) {
			for (int x = px; x < px + n; x++) {
				if (number == map[y][x])
					continue;
				else {
					for (int i = py; i < py + n; i += n / 2) {
						for (int j = px; j < px + n; j += n / 2) {
							cal(i, j, n / 2);
						}
					}
					return;
				}
			}
		}

		if (number == 0)
			first++;
		else if (number == 1)
			second++;

	}

}