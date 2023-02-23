import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


class Point{
	int y;
	int x;
	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}
public class Main {
	

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int n = Integer.parseInt(br.readLine());
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		String map[][] = new String [n][n];
		boolean visit[][] = new boolean[n][n];
		for(int i = 0 ; i < n ; i++) {
			map[i] = br.readLine().split("");
		}
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n; j++) {
				if(visit[i][j])continue;
				if(map[i][j].equals("0"))continue;
				int cnt = 1;
				Queue<Point> arr = new LinkedList<>();
				arr.add(new Point(i,j));
				visit[i][j] = true;
				while(!arr.isEmpty()) {
					cnt++;
					int x = arr.peek().x;
					int y = arr.poll().y;
					for(int d = 0 ; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if( nx < 0 || ny < 0 || nx >= n || ny >= n)continue;
						if(map[ny][nx].equals("0") || visit[ny][nx]) continue;
						
						visit[ny][nx] = true;
						arr.add(new Point(ny,nx));
						
					}
					
				}
				a.add(cnt);
			}
		}
		
		Collections.sort(a);
		System.out.println(a.size());
		for(int i = 0; i < a.size(); i++)System.out.println(a.get(i));
	}
	

}
