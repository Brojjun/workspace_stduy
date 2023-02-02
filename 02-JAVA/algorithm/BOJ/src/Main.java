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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int aa = 1;
		
		while (true) {
			boolean check = false;
	
			Stack<Character> arr = new Stack<>();
			String st = br.readLine();
			if(st == ".")return;
			
			for (int i = 0; i < st.length(); i++) {
				char imm = st.charAt(i);
				if (imm == '(' || imm == '[')
					arr.push(imm);

				else if (imm == ')') {
					if (arr.isEmpty()) {
						System.out.println("no");
						check = true;
						break;
					}
					if (arr.pop() == '(')
						continue;
					
					else {
						System.out.println("no");
						check = true;
						break;
					}
				}
				
				else if (imm == ']') {
					if (arr.isEmpty()) {
						System.out.println("no");
						check = true;
						break;
					}
					
					if (arr.pop() == '[')
						continue;
					
					else {
						System.out.println("no");
						check = true;
						break;
					}
				}
			}
			if(!check)
				System.out.println("yes");
		}
	

	}
}
