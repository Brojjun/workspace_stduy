package morning;
import java.util.Arrays;
import java.util.Scanner;

public class test {
	static boolean[] visit;
	static int[] input;
	static int[] number;

	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		visit = new boolean[N];
		input = new int[N];
		number = new int[R];
		for(int i = 0 ; i < N ; i++)input[i] = sc.nextInt();
		
		System.out.println("순열");
		perm(0);

		System.out.println("조합");
		comb(0, 0);
		
		System.out.println("부분집합 - 재귀");
		subset(0);
		
		System.out.println("부분집합 - 비트");
		subset();
		
		System.out.println("순열 - 비트");
		perm2(0, 0);
		
		System.out.println("순열-Next");
		nextPerm();

		System.out.println("조합-Next");
		nextComb();
	}

	private static void perm(int cnt) {
		if (cnt == R) {
			for (int i = 0; i < R; i++)
				System.out.print(number[i] + " ");
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			number[cnt] = input[i];
			perm(cnt + 1);
			visit[i] = false;
			number[cnt] = 0;
		}

	}

	private static void comb(int cnt, int start) {
		if (cnt == R) {
			for (int i = 0; i < R; i++)
				System.out.print(number[i] + " ");
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			//if (visit[i])
			//	continue;
			//visit[i] = true;
			number[cnt] = input[i];
			comb(cnt + 1, i + 1);
			//visit[i] = false;
			number[cnt] = 0;
		}
	}

	private static void subset() {
		for(int i = 0; i < (1 << N); i++) {
			for(int j = 0 ; j < N; j++) {
				if((i & (1<<j)) == 0)continue;
				System.out.print(input[j] + " ");
			}
			System.out.println();
		}
	}

	private static void subset(int cnt) {
		if(cnt == N){
			for(int i = 0; i < N; i++) {
				if(!visit[i])continue;
				System.out.print(input[i]+" ");
			}
			System.out.println();
			return;
		}
		
		visit[cnt] = true;
		subset(cnt+1);
		visit[cnt] = false;
		subset(cnt+1);
	}

	private static void perm2(int cnt, int flag) {
		if(cnt == R) {
			for(int i = 0 ; i < R; i++)System.out.print(number[i]);
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++) {
		if((flag & (1 << i)) == 0)continue;
		number[cnt] = input[i];
		perm2(cnt+1, flag | 1 << i);
		}
	}

	private static void nextPerm() {
		Arrays.sort(input);
		do {
			for (int i = 0; i < N; i++) System.out.print(input[i] + " ");
			System.out.println();
		} while (np(input));
	}

	private static void nextComb() {
		number = new int[N];
		// 배열 뒤부터 R개수만큼 1로 만듦 : 5C2라면 00011 이런형태로
		int cnt = 0;
		while (++cnt <= R) {
			number[N - cnt] = 1;
		}

		do {
			for(int i = 0; i < N; ++i) {
				if(number[i] == 1) System.out.print(input[i] + " ");
			}
			System.out.println();
		} while(np(number));
	}

	private static boolean np(int[] input) {
		
		int len = input.length;
		int i = len - 1;
		while(i > 0 && input[i-1] >= input[i])i--;
		if(i == 0)return false;
		
		int j = len - 1;
		while(input[i-1] >= input[j])j--;
		
		swap(input, i-1, j);
		
		int k = len - 1;
		while(i < k)swap(input,i,k--);
		
		return true;
	}

	private static void swap(int numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = numbers[i];
	}
}