import java.util.Scanner;

public class Main {
		public static void main(String[] args) throws Exception {
			Scanner sn = new Scanner(System.in);
			int n = sn.nextInt();
			int[][] map = new int[2][n];
			for(int i = 0; i < n; i++) {
				map[0][i] = sn.nextInt();
				map[1][i] = sn.nextInt();
			}
			int[] memo = new int[n];
			
			for(int i = 0; i < n; i++) {
				int cnt = 0;
				for(int j = 0; j < n; j++) {
					if(i == j)continue;
					if(map[0][i] < map[0][j] && map[1][i] < map[1][j]) cnt++;
					
				}
				memo[i] = cnt+1;
			}
			
			for(int i = 0; i < n; i++) {
				System.out.print(memo[i] + " ");
			}
			
		}
			
	
			
}		
	

	
	