import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 정형준_BOJ_2042_구간합구하기 {

	static class Tree {
		long data[];
		int size;
		int start;
		
		public Tree(long[] input) {
			int len = input.length;
			int s = 1;
			while (s < len) {
				s *= 2;
			}
			size = s * 2;
			start = s - 1;
			data = new long[size];
			// leaf
			for (int i = 0; i < len; i++)
				data[i + s] = input[i];

			// 줄기
			for (int i = size - 1; i >= 0; i--)
				data[i / 2] += data[i];

		}
		
		long select(int begin, int end) {
			long result = 0;
			//start 는 홀수이다.
			begin += start;
			end += start;
			
			 while(begin <= end) { 
			        if(begin % 2 == 1) {
			            result += data[begin++];
			        }
			        if(end % 2 == 0) {
			            result += data[end--];
			        }
			        begin /= 2;
			        end /= 2;
			    }
			 
			if(begin == end)result+=data[begin];
			return result;
		}
		
		void update(int at, long num) {
			at = at + start;
			long nowData = data[at];
			long dis = Math.abs(num - nowData);

			data[at] = num;

			while (at >= 1) {
				at = at / 2;
				if (num < nowData) {
					data[at] -= dis;
				} else {
					data[at] += dis;
				}
			}
			print();
		}

		void print() {
			int j = 1;
			int cnt = 1;
			for (int i = 1; i < size; i++) {
				System.out.print(data[i] + " ");
				if (cnt++ == j) {
					System.out.println();
					j *= 2;
					cnt = 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long data[] = new long[n];
		
		for(int i = 0; i < n; i++)data[i] = Long.parseLong(br.readLine());
		
		Tree tree = new Tree(data);
		
		//tree.print();
		for(int i = 0; i < m+k; i++) {
			//System.out.println();
			st = new StringTokenizer(br.readLine());
			int what = Integer.parseInt(st.nextToken());

			if(what == 1) {
				int b = Integer.parseInt(st.nextToken()); 
				long c = Long.parseLong(st.nextToken()); 
				tree.update(b, c);
				//tree.print();
			}
			else {
				int b = Integer.parseInt(st.nextToken()); 
				int c = Integer.parseInt(st.nextToken()); 
				System.out.println(tree.select(b, c));
			}
			//tree.print();
		}

	}
}