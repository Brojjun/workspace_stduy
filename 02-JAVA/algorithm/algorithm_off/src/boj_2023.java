import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2023 {
	static int end = 1;
	static int[] map = { 2, 3, 5, 7 };
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		// 첫 자리 가능 수 : 2,3,5,7
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n-1; i++)
			end *= 10;

		makeNum(2);
		makeNum(3);
		makeNum(5);
		makeNum(7);
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb.toString());
	}
	//숫자 제조
	private static void makeNum(int number) {
		if (number > end) {
			if (isPrime(number))
				sb.append(number + "\n");
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			int num2 = (number * 10) + i;
			if(isPrime(num2))
				makeNum(num2);
		}
	}
	//소수 판별
	static boolean isPrime(int n) {
		int number = n;
		while (number > 9) {
			for (int i = 2; i <= (int) Math.sqrt(number); i++) {
				if (number % i == 0)
					return false;
			}
			number /= 10;
		}

		return true;
	}

}