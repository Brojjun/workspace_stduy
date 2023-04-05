import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 정형준_SWEA_5642_키순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Test = Integer.parseInt(br.readLine());
		for (int T = 1; T <= Test; T++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int map[][] = new int[n + 1][n + 1];

			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int small = Integer.parseInt(st.nextToken());
				int biger = Integer.parseInt(st.nextToken());
				map[small][biger]++;
			}

			for (int mid = 1; mid <= n; mid++) {
				for (int begin = 1; begin <= n; begin++) {
					for (int end = 1; end <= n; end++) {
						if (mid == begin || mid == end || begin == end)
							continue;
						if (map[begin][end] == 1)
							continue;
						if (map[begin][mid] + map[mid][end] == 2)
							map[begin][end] = 1;
					}
				}
			}
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				int c = 0;
				for (int j = 1; j <= n; j++) {
					if (map[i][j] == 1 || map[j][i] == 1)
						c++;
				}
				if (c == n - 1)
					cnt++;
			}
			System.out.println("#" + T + " " + cnt);
		}
	}

}
