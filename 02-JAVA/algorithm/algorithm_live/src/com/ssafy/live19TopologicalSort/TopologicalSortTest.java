package com.ssafy.live19TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologicalSortTest {

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		};

	}

	static int N, M;
	static Node[] adjList;
	static int[] inDegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new Node[N];
		inDegree = new int[N + 1];
		int from, to;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		
		ArrayList<Integer> list = topologySort();
		if(list.size() == N) {
			for(Integer vertex : list)
				System.out.print(vertex + " ");
		}
		else {
			System.out.println("Cycle");
		}
	}

	static ArrayList<Integer> topologySort() {

		ArrayList<Integer> orderList = new ArrayList<>();
		Queue<Integer> que = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0)
				que.offer(i);
		}

		while (!que.isEmpty()) {
			int cur = que.poll();
			orderList.add(cur);

			// 현재 정점 기준으로 인접정점 처리

			for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
				if (--inDegree[temp.vertex] == 0)
					que.offer(temp.vertex);
			}

		}
		return orderList;

	}

}
