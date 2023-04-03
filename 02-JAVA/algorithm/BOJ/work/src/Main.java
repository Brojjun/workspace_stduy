import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int map[] = new int[n];
		int memo[] = new int[n];
		for (int i = 0; i < n; i++)
			map[i] = Integer.parseInt(st.nextToken());
		memo[0] = map[0];

		int at = 0;
		for (int i = 1; i < n; i++) {
			if (memo[at] < map[i])
				memo[++at] = map[i];
			else {
				int idx = Arrays.binarySearch(memo, 0, at, map[i]);
				if (idx < 0)
					idx = (-1 * idx) - 1;

				memo[idx] = map[i];
			}
		}
		System.out.println((at + 1));

	}
}
