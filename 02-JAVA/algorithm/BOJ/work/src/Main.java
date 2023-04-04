import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point> {
		int end, value;

		public Point(int end, int value) {
			super();
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Point o) {

			return this.value - o.value;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Point> arr[] = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			arr[begin].add(new Point(end, value));
		}
		long last = Integer.MAX_VALUE;
		for (int begin = 1; begin <= n; begin++) {

			boolean[] visit = new boolean[n + 1];
			long min_data = 0;
			visit[begin] = true;
			PriorityQueue<Point> pq = new PriorityQueue<>();
			for (Point now : arr[begin]) {
				pq.add(now);
			}

			while (!pq.isEmpty()) {

				Point now = pq.poll();
				if (visit[now.end])
					continue;
				visit[now.end] = true;
				min_data += now.value;

				for (Point next : arr[now.end])
					if (!visit[next.end])
						pq.add(next);
			}
			//System.out.println(min_data);
			if(min_data != 0)
			last = Math.min(last, min_data);
		}
		System.out.println(last);
	}
}
