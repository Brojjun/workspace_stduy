import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12891 {

	public static void main(String[] args) throws Exception {

		// INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());

		String word = br.readLine();
		int[] arr = new int[4];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st2.nextToken());
		arr[1] = Integer.parseInt(st2.nextToken());
		arr[2] = Integer.parseInt(st2.nextToken());
		arr[3] = Integer.parseInt(st2.nextToken());

		int cnt = 0;
		// 시작셋팅
		int[] imm = new int[4];
		
		for (int i = 0; i < M; i++) {
			if (word.charAt(i) == 'A')
				imm[0]++;
			else if (word.charAt(i) == 'C')
				imm[1]++;
			else if (word.charAt(i) == 'G')
				imm[2]++;
			else if (word.charAt(i) == 'T')
				imm[3]++;
		}
		
		// 시작
		for (int i = M; i <= N; i++) {
			
			if (arr[0] <= imm[0] && arr[1] <= imm[1] && arr[2] <= imm[2] && arr[3] <= imm[3]) cnt++;
				
			if (i == N)
				break;
			// 다음 문자열을 위한 후처리
			if (word.charAt(i - M) == 'A')
				imm[0]--;
			else if (word.charAt(i - M) == 'C')
				imm[1]--;
			else if (word.charAt(i - M) == 'G')
				imm[2]--;
			else if (word.charAt(i - M) == 'T')
				imm[3]--;

			if (word.charAt(i) == 'A')
				imm[0]++;
			else if (word.charAt(i) == 'C')
				imm[1]++;
			else if (word.charAt(i) == 'G')
				imm[2]++;
			else if (word.charAt(i) == 'T')
				imm[3]++;

		}
		System.out.println(cnt);

	}

}