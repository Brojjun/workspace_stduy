import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] month = new int[13];
	static int[] money = new int[4];
	static int[] go = new int[13];
	static int[] dfs = new int[13];
	static int min_money = Integer.MAX_VALUE;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			clear();
			input();
			
			calmonth();

			dfs_third(1,0);
			
			System.out.println("#"+test+" "+Math.min(min_money, money[3]));
		}
		
	}
	
	private static void clear() {
		month = new int[13];
		money = new int[4];
		go = new int[13];
		dfs = new int[13];
		min_money = Integer.MAX_VALUE;
		
	}
	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) money[i] = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 1; i < 13; i++) go[i] = Integer.parseInt(st2.nextToken());

	}
	
	private static void dfs_third(int cnt,int sum) {
		if(cnt >= 13) {
			min_money = Math.min(min_money, sum);
			return;
		}
		dfs_third(cnt+1,sum + month[cnt]);
		dfs_third(cnt+3,sum + money[2]);
		
	}
	
	private static void calmonth() {
		for(int i = 1; i <= 12; i++) {
			month[i] = Math.min(money[1], go[i] * money[0]);
		}
		
	}
}
