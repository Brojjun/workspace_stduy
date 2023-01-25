	
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
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int[] numberMap = new int[1000002];
			
			//소수 표기
			for(int i = 2; i <= 1000000; i++) {
				if(numberMap[i] >= 1)continue;
				numberMap[i] = 2;
				for(int j = i;j <= 1000000; j += i) {
					if(numberMap[j] == 0) numberMap[j] = 1;
				}
			}
			
			String[] imm = br.readLine().split(" ");
			int sn = Integer.parseInt(imm[0]);
			int fn = Integer.parseInt(imm[1]);
			
			for(int i = sn; i <= fn; i++) {
				if(numberMap[i] == 2) System.out.println(i);
				
			}
		}
	}