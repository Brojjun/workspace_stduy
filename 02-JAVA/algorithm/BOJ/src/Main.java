import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dat{
	int at;
	int data;
	
	public Dat(int at, int data) {
		this.at = at;
		this.data = data;
	}
}

public class Main {
	

	static StringBuffer sb = new StringBuffer();
	
	static int bn;
	static int[] map;
	static int[] cnt;
	
	public static void binarySearch(int target) {
		int begin = 0;
		int end = bn-1;
		while(begin <= end) {
			int mid = (begin + end) / 2;
			if(map[mid] == target) {
				findSameNum(mid, target);
				return;
			}
			else if(map[mid] > target) {
				end = mid - 1;
			}
			else
				begin = mid + 1;
		}
	sb.append("0 ");
	}
	
	//bfs를 활용한 같은 숫자 탐색
	public static void findSameNum(int at, int target) {
		//재탐색 불허를 위한 방문 표시 -> 없으면 탐색했던 장소를 무한하게 재 탐색
		boolean[] visited = new boolean[bn];
		
		//bfs
		Queue<Dat> que = new LinkedList<>();
		int cnt = 1;
		que.add(new Dat(at ,target));
		visited[at] = true;
		while(!que.isEmpty()) {
			Dat now = que.poll();
			if(now.at + 1 < bn)
			if(visited[now.at + 1] == false && map[now.at + 1] == target && now.at < bn ) {
				visited[now.at + 1] = true;
				cnt++;
				que.add(new Dat(at+1, target));
			}
			if(now.at -1 >= 0)
			if(visited[now.at - 1] == false && map[now.at - 1] == target && now.at >= 0 ) {
				visited[now.at - 1] = true;
				cnt++;
				que.add(new Dat(at-1, target));
			}
		}
		sb.append(cnt + " ");		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bn = Integer.parseInt(br.readLine());
		map = new int[bn];
		String[] imm = br.readLine().split(" "); 
		for(int i = 0; i < bn; i++) {
			map[i] = Integer.parseInt(imm[i]);
		}
		
		Arrays.sort(map);
	
		int bm = Integer.parseInt(br.readLine());
		
		String[] immm = br.readLine().split(" "); 
	
		for(int i = 0; i < bm; i++) {
			binarySearch(Integer.parseInt(immm[i]));
		}
		System.out.println(sb);
		
	}
}
