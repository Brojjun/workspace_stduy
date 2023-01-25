	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.Arrays;
	
	
	/*
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String[] yxbag = br.readLine().split(" ");
	
	 */
	
	public class Main {
			
		public static void main(String[] args) throws Exception {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			long num = Integer.parseInt(br.readLine()) - 1;
			long cnt = 0;
			
			while(true) {
				num -= (cnt * 6);
				if (num <= 0) break;
				cnt++;
			}
			System.out.println(cnt+1);
		}		
	}

	
	