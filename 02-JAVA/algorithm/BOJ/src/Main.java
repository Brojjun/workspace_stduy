import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int start;

	public Point(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	int end;

	@Override
	public int compareTo(Point o) {
		if (this.end == o.end)
			return this.start - o.start;
		return this.end - o.end;
	}

}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		for (int T = 0; T < N; T++) {
			PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
			PriorityQueue<Integer> min = new PriorityQueue<Integer>();
			int n = Integer.parseInt(br.readLine());
			
			for(int t = 0; t < n; t++) {
				String[] st = br.readLine().split(" ");
				
				if(st[0].equals("I")) {
					max.offer(Integer.parseInt(st[1]));
					min.offer(Integer.parseInt(st[1]));
				}
				else if (max.isEmpty())continue;
				
				else  {		
					if(st[1].equals("1")) min.remove(max.poll());
					else max.remove(min.poll());
				}
			}
			
			if(max.isEmpty())System.out.println("EMPTY");
			else {
				System.out.println(max.peek() + " " + min.peek());
			}
		}
	}

}
