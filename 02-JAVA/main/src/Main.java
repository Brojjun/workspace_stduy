import java.io.*;
import java.util.*;

public class Main {
	static int bn;
	static boolean[] visited;
	static char[] data;
	static List<Integer> arr = new ArrayList<>();
	static long max_data = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bn = Integer.parseInt(br.readLine());
		data = br.readLine().toCharArray();
		visited = new boolean[bn];
		makeNum(1, data[0]-'0');
		System.out.println(max_data);
	}

	private static void makeNum(int cnt, long sum) {
		if (cnt >= bn) {
			max_data = Math.max(max_data, sum);
			return;
		}

		long num = 0;
		long immnum = 0;
		// 괄호일 때
		if (cnt <= bn - 4) {
			if (data[cnt+2] == '+') {
				immnum = (data[cnt + 1] - '0') + (data[cnt + 3] - '0');
			}
			if (data[cnt+2] == '-') {
				immnum = (data[cnt + 1] - '0') - (data[cnt + 3] - '0');
			}
			if (data[cnt+2] == '*') {
				immnum = (data[cnt + 1] - '0') * (data[cnt + 3] - '0');
			}

			if (data[cnt] == '+') {
				num = sum + immnum;
			}
			if (data[cnt] == '-') {
				num = sum - immnum;
			}
			if (data[cnt] == '*') {
				num = sum * immnum;
			}
		}
		makeNum(cnt + 4, num);
		// 괄호가 아닐 때
		if (data[cnt] == '+') {
			num = sum + (data[cnt + 1] - '0');
		}
		if (data[cnt] == '-') {
			num = sum - (data[cnt + 1] - '0');
		}
		if (data[cnt] == '*') {
			num = sum * (data[cnt + 1] - '0');
		}
		makeNum(cnt + 2, num);

	}

}
