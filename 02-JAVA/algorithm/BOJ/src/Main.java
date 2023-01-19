import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String[] yxbag = br.readLine().split(" ");

int by = Integer.parseInt(yxbag[0]);
int bx = Integer.parseInt(yxbag[1]);
int bag = Integer.parseInt(yxbag[2]);

 */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		long a1 = Integer.parseInt(br.readLine());
		long a2 = Integer.parseInt(br.readLine());
		long a3 = Integer.parseInt(br.readLine());
		
		
		long a4 = a1 * a2 * a3;
		int[] numberMap = new int[10];
		while(a4 > 0) {
			int a = (int) a4 % 10;
			numberMap[a]++;
			a /= 10;
		}
		
		for(int i = 1; i < 10; i++)System.out.println(numberMap[i]);
	}
}