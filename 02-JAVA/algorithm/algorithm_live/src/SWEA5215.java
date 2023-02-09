import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class SWEA5215 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int BN = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <=BN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int maxScore = 0;
			
			int[] cal = new int[N];
			int[] score = new int[N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st2.nextToken());
				cal[i] = Integer.parseInt(st2.nextToken());
			}
			
			for(int i = 0; i < ( 1<<N ); i++) {
				int imScore = 0;
				int imCal = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) == 0) continue;
						imScore += score[j];
						imCal += cal[j];
				}
				if(imCal <= M)
					maxScore = Math.max(maxScore, imScore);
			}
			
			System.out.println("#"+t+" "+maxScore);
		}

		

	}
}
