	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.HashSet;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.PriorityQueue;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	public class Main {
	
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n, d, k, c;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int[] list = new int[n+1];
			
			for (int i = 0; i < n; i++)list[i] = Integer.parseInt(br.readLine());
			
			int[] cnt = new int[n + 1];
	
			int[] visit = new int[d + 1];
			HashSet<Integer> set = new HashSet<>();
			set.add(c);
			visit[c]++;
			int i = 0;
			int nt = 0;
			while(cnt[i] == 0) {
				set.add(list[i]);
				visit[list[i]]++;
				if(nt >= k) {
					cnt[i] = set.size();
					
				}
				
				
				i = (i+1) % n;
				nt++;
			}

			for (int i = k - 1; i < n; i++) {
				set.add(list.get(i));
				visit[list.get(i)]++;
				set.add(c);
				cnt[i] = set.size();
				int per = i - k + 1;
	
				if (list.get(per) != c) {
					if (visit[list.get(per)] == 1) {
						set.remove(list.get(per));
					}
					visit[list.get(per)]--;
				}
			}
	
			// 0 ~ k 계산
			set = new HashSet<>();
			set.add(c);
			visit[c]++;
			for (int i = n - k + 1; i < n; i++) {
				set.add(list.get(i));
				visit[list.get(i)]++;
			}
	
			for (int i = 0; i < k - 1; i++) {
				set.add(list.get(i));
				visit[list.get(i)]++;
				set.add(c);
				cnt[i] = set.size();
				int per = i - k;
				if (per < 0)
					per = n + per;
	
				if (list.get(per) != c) {
					if (visit[list.get(per)] == 1) {
						set.remove(list.get(per));
					}
					visit[list.get(per)]--;
				}
	
			}
			
			int max = 0;
			for (int i = 0; i < n; i++) max = Math.max(max, cnt[i]);
			System.out.println(max);
		}
	}
