import java.util.Arrays;
import java.util.Scanner;

public class 모닝순조부 {
	static int N, R;
	static int[] numbers;
	static int[] input;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();

		numbers = new int[R];
		input = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++)
			input[i] = sc.nextInt();

		// System.out.println("순열");
		// perm(0);
		// System.out.println("조합");
		// comb(0,0);
		System.out.println("부분집합 - 재귀");
		subset(0);
		/*
		 * System.out.println("부분집합 - 비트"); subset();
		 */
	}

	// i는 N를 이진수의 단위로 바꿔 준 것
	private static void subset() {
		for (int i = 0; i < (1 << N); ++i) {
			System.out.print("[ ");

			for (int j = 0; j < N; ++j) {
				if ((i & (1 << j)) == 0)
					continue;

				System.out.print(input[j] + " ");
			}
			System.out.println(" ]");
		}

	}

	private static void subset(int cnt) {
		if (cnt == N) {
			
			System.out.print("[ ");
			for (int i = 0; i < N; i++) {
				System.out.print(visited[i] ? input[i] + " " : "");
			}

			System.out.println(" ] ");
			return;
		}

		visited[cnt] = false;
		subset(cnt + 1);
		visited[cnt] = true;
		subset(cnt + 1);
	}

	private static void comb(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
			visited[i] = false;
			numbers[cnt] = 0;
		}

	}

	private static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			numbers[cnt] = input[i];
			perm(cnt + 1);
			visited[i] = false;
			numbers[cnt] = 0;
		}

	}
}
