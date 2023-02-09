import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public Main() throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int BN = Integer.parseInt(br.readLine());
	
		for(int i = 0; i < BN; i++) {
			int B = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			for(int j = 0; j < B; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				int cnt = 1;
				if(map.containsKey(type)) {
					cnt += map.get(type);
				}
				map.put(type, cnt);
			}
			
			
		}
	}
	

}