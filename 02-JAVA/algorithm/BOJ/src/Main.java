import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean visitD[];
	static boolean visitB1[];
	static boolean visitB2[];
	static int N, dab=Integer.MAX_VALUE;
	static int people[];
	static ArrayList<ArrayList<Integer>> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = 1+Integer.parseInt(br.readLine());
		people = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++)
			people[i] = Integer.parseInt(st.nextToken());

		map = new ArrayList<>();
		for (int i = 0; i < N; i++)
			map.add(new ArrayList<>());
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) map.get(i).add(Integer.parseInt(st.nextToken()));
		}
		visitD = new boolean[N];
		dfs(1);

		System.out.println(dab);
	}

	private static void dfs(int cnt) {
		if(cnt == N) {
			bfs();
			return;
		}
		visitD[cnt] = true;
		dfs(cnt+1);
		visitD[cnt] = false;
		dfs(cnt+1);
		
	}

	private static void bfs() {
		boolean flag = false;
		boolean visit[] = new boolean[N];
		
		int start1 = -1, start2 = -1;
		for(int i = 1 ; i < N; i++) {
			if(start1 == -1 && visitD[i])start1 = i;
			if(start2 == -1 && !visitD[i])start2 = i;

		}
		if(start1 == -1 || start2 == -1 )return;
		
		int first_ans = 0;
		//첫번째 map 만들기
		Queue<Integer> que1 = new LinkedList<Integer>();

		que1.add(start1);
		int cnt=0;
		while(!que1.isEmpty()) {
			int now = que1.poll();
			visit[now] = true;
			first_ans += people[now];
			cnt++;
			for(int i = 0 ; i < map.get(now).size(); i++) {
				int next = map.get(now).get(i);
				if(visit[next]) continue;
				if(!visitD[next]) continue;
				que1.add(next);
			}
		}
		//if(first_ans != end1)return;
		
		
//		if(visitD[1] && !visitD[2] && !visitD[3]&& visitD[4]&& !visitD[5]&& !visitD[6]) {
//			System.out.println("!");
//		}
		int second_ans = 0;
		//2 map 만들기
		Queue<Integer> que2 = new LinkedList<Integer>();
		que2.add(start2);
		
		while(!que2.isEmpty()) {
			int now = que2.poll();
			visit[now] = true;
			second_ans += people[now];
			cnt++;
			for(int i = 0 ; i < map.get(now).size(); i++) {
				int next = map.get(now).get(i);
				if(visit[next]) continue;
				if(visitD[next]) continue;
				que2.add(next);
			}
		}

		
//		if(Math.abs(first_ans - second_ans) == 0){
//			System.out.println("!");
//		}
		//if(second_ans != end2)return;
		if(cnt == N-1)
			dab = Math.min(dab, Math.abs(first_ans - second_ans));
		
	}

}
