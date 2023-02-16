import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> arr = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1.intValue()) == Math.abs(o2.intValue()))
					return (o1.intValue()) - (o2.intValue());
				return (Math.abs(o1.intValue()) - Math.abs(o2.intValue()));
			}
			
		});
		
		int N = Integer.parseInt(br.readLine());
	
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				if(arr.isEmpty())System.out.println(0);
				else
					System.out.println(arr.poll());
			}
			
			else{
				arr.add(n);
			}
			
		}

	}
}
