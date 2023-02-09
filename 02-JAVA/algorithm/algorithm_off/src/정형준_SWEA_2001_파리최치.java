import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 정형준_SWEA_2001_파리최치 {
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= Test; t++) {
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st1.nextToken());
        	int M = Integer.parseInt(st1.nextToken());
        	int[][] map = new int[N][N];
        	int maxKill = 0;
        	for(int y = 0; y < N; y++) {
        		StringTokenizer st2 = new StringTokenizer(br.readLine());
        		for(int x = 0; x < N; x++) {
        			map[y][x] = Integer.parseInt(st2.nextToken());
        		}
        	}
  
        	for(int y = 0; y < N; y++) {
        		for(int x = 0; x < N; x++) {
        			int kill = 0;
        			
        			outerloop:
        			for(int ny = y; ny < (y + M); ny++) {
        				if(ny >= N) break outerloop;
        				for(int nx = x; nx < (x + M); nx++) {
        					if(nx >= N) break outerloop;
        					kill += map[ny][nx];
        				}
        			}
        			maxKill = Math.max(kill, maxKill);
        		}
        	
        	}
        	System.out.println("#"+t+" "+maxKill);
        	
        }
        
    }
}