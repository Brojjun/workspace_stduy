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
	
	static class Node implements Comparable<Node>{
		int at, weight;

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

		public Node(int at, int weight) {
			super();
			this.at = at;
			this.weight = weight;
		}

		
		
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int MAX = Integer.MAX_VALUE;
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		boolean[] visit = new boolean[V+1];
		int[] memo = new int[V+1];
		Arrays.fill(memo, MAX);
		
		ArrayList<ArrayList<Node>> nodeMap = new ArrayList<>();
		for(int i = 0; i <= V; i++)nodeMap.add(new ArrayList<>());
		
		for(int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeMap.get(from).add(new Node(to,weight));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		memo[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			visit[now.at] = true;
			
			for(Node next : nodeMap.get(now.at)) {
				if(visit[next.at]) continue;
				if(memo[next.at] > now.weight + next.weight) {
					memo[next.at] = now.weight + next.weight;
					pq.add(new Node(next.at, memo[next.at]));
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			System.out.println(memo[i] == MAX ? "INF" : memo[i]);
		}
	}

}