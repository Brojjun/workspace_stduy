import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[] input;
	public static int[] numbers;
	public static boolean[] visited;
	public static int max;
	public static int N;
	public static int M;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		numbers = new int[N];
		visited = new boolean[N];
		for(int i = 0 ; i < N; i++) input[i] = sc.nextInt();
		
		makeNum(0, 0);
		
		System.out.println(max);
			
		}

	private static void makeNum(int cnt, int start) {
		if(cnt == 3) {
			int num = 0;
			for(int i = 0 ; i < 3; i++)num += numbers[i];
			
			if(num <= M) max = Math.max(max, num);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = input[i];
			makeNum(cnt+1, i+1);
			visited[i] = false;
			numbers[cnt] = 0;
		}
	}
		
	
}