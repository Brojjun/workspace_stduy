import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static public int[] input = new int[9];;
	static public boolean[] visited = new boolean[9];
	static public int N;
	static public List<Integer> arr = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 9; i++) input[i] = sc.nextInt();
		makeNum(0,0);
	}

	private static void makeNum(int cnt,int start) {
		if(cnt == 7) {
			int number = 0;
			for(int i = 0; i < 7; i++) number += arr.get(i);
			if(number == 100) {
				for(int i = 0; i < 7; i++)
					System.out.println(arr.get(i));
			}
		}
		for(int i = start; i < 9; i++) {
			if(visited[i])continue;
			visited[i] = true;
			arr.add(input[i]);
			makeNum(cnt+1, i+1);
			arr.remove(arr.size()-1);
			visited[i] = false;
		}
	}
}
