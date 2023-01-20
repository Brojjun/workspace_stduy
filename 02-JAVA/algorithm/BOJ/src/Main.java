import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;


/*
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String[] yxbag = br.readLine().split(" ");

 */

public class Main {
		
	public static void main(String[] args) throws Exception {
		
		int[] map = new int[1002];
		for(int i = 2; i < 1001; i++) {
			if(map[i] > 0) continue;
			int j = i;
			map[j] = 2;
			while(j <= 1000) {
				j += i;
				if(j > 1000)break;
				map[j] = 1;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String a = br.readLine();
		
		int cnt = 0;
		for(int i = 0; i < a.length(); i++) {
			
			int ss = a.charAt(i) - '0';
			System.out.println(ss);
			if(map[1] == 2) cnt++;
		}
		
		
				
		System.out.println(cnt);
	}
}