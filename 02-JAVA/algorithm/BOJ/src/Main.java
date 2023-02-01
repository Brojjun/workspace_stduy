import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> arr = new Stack<>();
		
		int bn = sc.nextInt();
		for(int i = 0; i < bn; i++) {
			//System.out.println(i);
			String imm = br.readLine();
			
			if(imm.contains("push")) 
				arr.push(Integer.parseInt(imm.substring(5)));
			
			else if(imm.equals("pop")) {
				if(arr.isEmpty())	System.out.println(-1);
				else	System.out.println(arr.pop());
			}
			
			else if(imm.equals("size")) 
				System.out.println(arr.size());
			
			else if(imm.equals("empty")) 
				System.out.println(arr.isEmpty() ? 0 : 1);
			
			else if(imm.equals("top")) {
				if(arr.isEmpty())	System.out.println(-1);
				else	System.out.println(arr.peek());
			}
		}
	
		
	}
}
