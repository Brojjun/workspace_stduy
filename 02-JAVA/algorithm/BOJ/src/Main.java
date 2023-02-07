import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i += 2) {
			String a = br.readLine();
			String b = br.readLine();
			map.put(a,b);
		}
		
		for(int i = 0; i < M; i++) {
			System.out.println(map.get(br.readLine()));
		}
		
	}
}