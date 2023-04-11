import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class aa implements Comparable<aa> {
		int num;

		public aa(int num) {
			super();
			this.num = num;
		}

		@Override
		public int compareTo(aa o) {
			// TODO Auto-generated method stub
			return this.num - o.num;
		}
	}

	
	public static void main(String[] args) {
		aa A[] = new aa[10];
		PriorityQueue<aa> pq = new PriorityQueue<>();
		
		for (int i = 0; i < 10; i++) {
			aa im = new aa(i);
			A[i] = im;
			pq.add(im);
		}
		
		A[3].num = 100;
		A[0].num = 999999;
		
		for(int i = 0; i < 10; i++) {
			System.out.println(pq.poll().num);
		}
	}
}