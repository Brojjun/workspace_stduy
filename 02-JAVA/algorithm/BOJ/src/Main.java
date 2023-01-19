import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String[] yxbag = br.readLine().split(" ");

 */

public class Main {
	public static void main(String[] args) throws Exception {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] number = br.readLine().split(" ");
	
		//입력이 무조건 8개이기 때문에 동적으로 짤 필요가 없어보임
		//-> 정적으로 첫번째 값 1,8구분하고 1씩 증감만 검사하면 될듯
		
		//증가
		if(number[0].equals("1")) {	
			for(int i = 0; i < 8; i++) {
				if(Integer.parseInt(number[i]) != i+1) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
		}
		
		//감소
		else if(number[0].equals("8")) {
			for(int i = 0; i < 8; i++) {
				if(Integer.parseInt(number[i]) != 8-i) {
					System.out.println("mixed");
					return;
				}
			}
		
			System.out.println("decending");
		}
			
		else System.out.println("mixed");
	}
}