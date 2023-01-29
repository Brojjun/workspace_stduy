import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int v = Integer.parseInt(s[2]);
				
		
		int day = (v-a) / (a-b);
		/*
		 * a-b는 하루 이동 양
		 * day * (a-b)는 어제까지 한 일
		 * day * (a-b) + a는 내일 낯까지
		 */
		while((day * (a-b))+a < v) day++;
		
		System.out.println(day+1);
	}
}
