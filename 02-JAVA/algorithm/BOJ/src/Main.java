import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/*
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String[] yxbag = br.readLine().split(" ");

int by = Integer.parseInt(yxbag[0]);
int bx = Integer.parseInt(yxbag[1]);
int bag = Integer.parseInt(yxbag[2]);

 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> book = new ArrayList<String>();
		
		for(int i = 0; i < n;i++) {
			String word = br.readLine();
			book.add(word);
		}
		Collections.sort(book);
		
		String[][] arr = new String[51][20000];
		int[] size = new int[51];
		while(!book.isEmpty()) {
			String word = book.get(0);
			arr[word.length()][size[word.length()]++] = word;
			book.remove(0);
		}
		
		for(int i = 0; i < 51; i++) {
			String words = "";
			for(int j = 0; j < size[i]; j++) {
				if(words.equals(arr[i][j]))
					continue;
				words = arr[i][j];
				System.out.println(arr[i][j]);

			}
			
		}
	}
}