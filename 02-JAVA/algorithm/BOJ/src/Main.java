import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BigInteger a = new BigInteger("1");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1 ; i <= n; i++) {
			BigInteger b = new BigInteger(Integer.toString(i));
			a = a.multiply(b);
		}
		String im = a.toString();
		//System.out.println(a.toString());
		int cnt = 0;
		
		for(int i = im.length()-1; i >= 0; i--) {
		if(im.charAt(i) == '0')cnt++;
		else break;
			
		}
		System.out.println(cnt);
	}

}
