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
		

	}

	private static void comb(int cnt, int start) {
		
	}

	private static void subset() {
		
	}

	private static void subset(int cnt) {
		

	private static void perm2(int cnt, int flag) {
		
	}

	private static void nextPerm() {
		
	}

	private static void nextComb() {
		
	}

	private static boolean np(int[] input) {
		
	}

	private static void swap(int numbers[], int i, int j) {
		
	}
}